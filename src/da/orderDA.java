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
import java.sql.Statement;
import java.util.ArrayList;
import domain.Order;

import domain.Menu;
import domain.registerAffiliates;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author AaronLee
 */

public class orderDA {

    private String host = "jdbc:derby://localhost:1527/RESTAURANTDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "NBUSER.\"ORDER\"";
    private Connection conn;
    private PreparedStatement stmt;
    private String sqlInsertStr = "INSERT INTO " + tableName + " VALUES(?, ? ,? , ? ,? ,? ,?)";
    private ResultSet rs;
      Calendar cal = Calendar.getInstance();
       int year = cal.get(Calendar.YEAR);
       int month = cal.get(Calendar.MONTH)+1;
       int date = cal.get(Calendar.DATE);
       int hour = cal.get(Calendar.HOUR);
       int minute = cal.get(Calendar.MINUTE);
       String Date = String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(date);
       String time = String.valueOf(hour) + ":" + String.valueOf(minute);

    public orderDA() {
        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host, user, password);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
     
   public void addData(String OrderID)  {
     
       
        try {
           
            stmt = conn.prepareStatement(sqlInsertStr);
            stmt.setString(1, OrderID);
            stmt.setString(2, Date);
            stmt.setString(3, time);
            stmt.setString(4,"Pending");
            stmt.setString(5,"C0001");
            stmt.setString(6,"D0001");
            stmt.setString(7, "R0001");

            

          
            stmt.executeUpdate();
            conn.close();
     
        } catch (SQLException ex) {
            ex.getMessage();
            JOptionPane.showMessageDialog(null, ex);
        }
}
   public ResultSet displayData() {
        String queryStr = "SELECT * FROM NBUSER.\"ORDER\" ORDER BY ORDERID DESC";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return rs;
    }
}
