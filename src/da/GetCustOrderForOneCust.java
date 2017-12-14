/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author BryanLee
 */
public class GetCustOrderForOneCust {
    private String host = "jdbc:derby://localhost:1527/RESTAURANTDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "ORDER";
    private Connection conn;
    private PreparedStatement stmt;
    private String tableName2 = "ORDERMENU";
    private Connection conn2;
    private PreparedStatement stmt2;

    
    public GetCustOrderForOneCust() {
        createConnection();
        
    }
    
    private void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host, user, password);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
        
    public ResultSet getOverviewOrder(String custid){
        String queryStr = "SELECT O.ORDERID, O.ORDERDATE, O.ORDERTIME, D.DELIVERYSTATUS, R.RESTNAME FROM NBUSER.\"ORDER\" O, DELIVERY D, RESTAURANT R WHERE O.CUSTID = ? AND O.ORDERSTATUS = 'Complete' AND D.DELIVERYSTATUS !='Complete' AND D.DELIVERYID = O.DELIVERYID AND R.RESTID = O.RESTID";
        ResultSet rs = null;
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, custid);
            
            rs = stmt.executeQuery();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
        
    public ResultSet getDeliveryByOrderID(String orderid){
        String queryStr = "SELECT DELIVERYID FROM NBUSER.\"ORDER\" WHERE ORDERID = ?";
        ResultSet rs = null;
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, orderid);
            
            rs = stmt.executeQuery();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public ResultSet getDelivery(String deliveryid){
        String queryStr = "SELECT * FROM NBUSER.\"DELIVERY\" WHERE DELIVERYID = ?";
        ResultSet rs = null;
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, deliveryid);
            
            rs = stmt.executeQuery();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
    
    public ResultSet getRestaurant(String restanme){
        String queryStr = "SELECT RESTPHONE FROM NBUSER.\"RESTAURANT\" WHERE RESTNAME = ?";
        ResultSet rs = null;
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, restanme);
            
            rs = stmt.executeQuery();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
    
        public ResultSet getStaff(String staffid){
        String queryStr = "SELECT STAFFNAME, STAFFPHONE FROM NBUSER.\"STAFF\" WHERE STAFFID = ?";
        ResultSet rs = null;
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, staffid);
            
            rs = stmt.executeQuery();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
    
    public void UpdateDoneOrder(String orderid, String deliveryid){
        String queryStr = "UPDATE NBUSER.\"ORDER\" SET ORDERSTATUS = 'Complete', DELIVERYID = ? WHERE ORDERID = ?";
        ResultSet rs = null;
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, deliveryid);
            stmt.setString(2, orderid);
            
            stmt.executeUpdate();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ResultSet generateDeliveryID(){
        String queryStr = "SELECT * FROM DELIVERY";
        ResultSet rs = null;
        try{
            stmt = conn.prepareStatement(queryStr);
            
            rs = stmt.executeQuery();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
    
    public void addDeliveryRecord(String deliveryid) throws SQLException{
        String insertStr = "INSERT INTO DELIVERY VALUES(?, ?, ?, ?, ?, ?, ?)";
        
        try{
    
                       stmt = conn.prepareStatement(insertStr);
                       stmt.setString(1,deliveryid);
                       stmt.setString(2, null);
                       stmt.setString(3, null);
                       stmt.setString(4, "Pending");
                       stmt.setDouble(5, 0);
                       stmt.setString(6, null);
                       stmt.setString(7, null);
                       stmt.executeUpdate();                        

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
        
}