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
import javax.swing.JOptionPane;
import ui.Restaurant;

/**
 *
 * @author Admin
 */
public class RestaurantDA {
     private String host = "jdbc:derby://localhost:1527/Agile";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName ="Restaurant";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs = null;
    
    public RestaurantDA(){
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
    
    public Restaurant getMenu(String resName){
        String selectStr = "Select * from " + tableName + " where restName = ?";
        
        Restaurant restaurant = null;
        try {
            stmt = conn.prepareStatement(selectStr);
            stmt.setString(1, resName);
               
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                restaurant = new Restaurant(rs.getString(1), resName, 
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8));
           
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return restaurant;
        
    }
    
     public ResultSet getRestaurant(){
        String queryStr = "SELECT * FROM " + tableName;
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
    
}
