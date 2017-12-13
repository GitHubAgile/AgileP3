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
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class UpdateStaffDA {
     private String host = "jdbc:derby://localhost:1527/Agile";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "STAFF";
    private Connection conn;
    private PreparedStatement stmt;
    
    public UpdateStaffDA() {
        createConnection();
  
    }
    
     public void UpdateStaff(String ID,String PASSWORD, String NAME, String PHONE, String EMAIL, String POSITION, String Status) throws ParseException,SQLException{
         String UpdateStaffStr = "UPDATE STAFF SET STAFFPW = ?, STAFFNAME = ?, STAFFPHONE = ?, STAFFEMAIL = ?, POSITION = ?, STATUS = ? WHERE STAFFID = ?";      
         try{
              stmt = conn.prepareStatement(UpdateStaffStr);
              
              stmt.setString(1,PASSWORD);
              stmt.setString(2,NAME);
              stmt.setString(3,PHONE);
              stmt.setString(4,EMAIL);
              stmt.setString(5,POSITION);
              stmt.setString(6,Status);
              stmt.setString(7,ID);
              stmt.executeUpdate();
              
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
         }
     }
    
     public ResultSet getStaff(){
         
          String queryID = "SELECT * FROM " + tableName;
          ResultSet rs = null;
         try{
             stmt = conn.prepareStatement(queryID);
             rs = stmt.executeQuery(); 
         }catch(SQLException ex){
             ex.getMessage();
         }
         return rs;
     }
     public ResultSet getSpecificStaff(String ID){
         
          String queryID = "SELECT * FROM " + tableName + " WHERE STAFFID = ? ";
          ResultSet rs = null;
         try{
             stmt = conn.prepareStatement(queryID);
             stmt.setString(1,ID);
             rs = stmt.executeQuery(); 
         }catch(SQLException ex){
             ex.getMessage();
         }
         return rs;
     }
    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***Hostel: Connection established.");
        } catch (SQLException ex) {
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
    
}
