/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.DailyRecord;
import domain.Staff;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class DailyRecordDA {
    private String host = "jdbc:derby://localhost:1527/Agile";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName ="DailyRecord";
    private Connection conn;
    private PreparedStatement stmt;
    
    public DailyRecordDA(){
        createConnection();
        
    }
     private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
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
    
    public void searchRecord(DailyRecord dR){
        String searchStr = "Select * from " + tableName + " where TodayDate = ? and StaffID = ?";
        
        try{
        stmt = conn.prepareStatement(searchStr);
        stmt.setString(1, dR.getTodayDate());
        stmt.setString(2, dR.getStaffID());
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()){
            addRecord(dR);
        }
        else{
             addRecord(dR);
        }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        
    }
    
    public void addRecord(DailyRecord dR) {
        String insertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, dR.getRecordID());
            stmt.setString(2, dR.getTodayDate());
            stmt.setString(3, dR.getCheckInTime());
            stmt.setString(4, dR.getCheckOutTime());
            stmt.setDouble(5, Double.parseDouble(dR.getTotalDistanceTravel() + ""));
            stmt.setInt(6, Integer.parseInt(dR.getTotalDeliveryCount() + ""));
            stmt.setString(7, dR.getStaffID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

     public int getLastID(){
      String selectStr = "Select max(recordId) from " + tableName;
      ResultSet rs;
      int id = 0;
      try{
      rs = stmt.executeQuery(selectStr);
      id = rs.getInt(1);

      }catch(Exception ex){
          JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

      }
      return id;
     }
     
     public DailyRecord getLastRecord(String staffID){
         String filterStr = "Select * from " + tableName + " where STAFFID = ? AND CHECKOUTTIME = ?";
         ResultSet rs;
         DailyRecord dR = null;
         try{
             stmt = conn.prepareStatement(filterStr);
             stmt.setString(1, staffID);
             stmt.setString(2, "0");
             rs = stmt.executeQuery();
             
             if (rs.next()){
                dR  = new DailyRecord(rs.getString(1), rs.getString(2), rs.getString(3)
                 , rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getString(7));
                
                return dR;
                
             }
         }catch (Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

         }
         return dR;
     }
     
     public void updateLogoutTime(String recordID){
        String updateStr = "update " + tableName + " set checkouttime = ? where recordID = ?";
        DateFormat tf = new SimpleDateFormat("HH:mm:ss");
        java.util.Date dateobj = new java.util.Date();
        
        try{
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, tf.format(dateobj));
            stmt.setString(2, recordID);
            stmt.executeUpdate();
          
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Test", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
     }
     
   
    
}