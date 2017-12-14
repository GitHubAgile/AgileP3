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
import javax.swing.JOptionPane;
/**
 *
 * @author BryanLee
 */
public class GetCustOrderForOneRest {
    private String host = "jdbc:derby://localhost:1527/RESTAURANTDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "ORDER";
    private Connection conn;
    private PreparedStatement stmt;
    private String tableName2 = "ORDERMENU";
    private Connection conn2;
    private PreparedStatement stmt2;

    
    public GetCustOrderForOneRest() {
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
        
    public ResultSet getOrder(String restid){
        String queryStr = "SELECT O.ORDERID, O.ORDERDATE, O.ORDERTIME, SUM(M.QUANTITY), O.CUSTID FROM NBUSER.\"ORDER\" O, NBUSER.\"ORDERMENU\" M WHERE O.RESTID = ? AND O.ORDERSTATUS = ? AND M.ORDERID = O.ORDERID GROUP BY O.ORDERID, O.ORDERDATE, O.ORDERTIME, O.CUSTID";
        ResultSet rs = null;
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, restid);
            stmt.setString(2, "Pending");
            
            rs = stmt.executeQuery();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
        
    public ResultSet getOrderMenu(String orderid){
        String queryStr = "SELECT M.ITEMNAME, O.QUANTITY FROM NBUSER.\"ORDERMENU\" O, NBUSER.\"MENU\" M WHERE O.ORDERID = ? AND M.ITEMID = O.ITEMID";
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