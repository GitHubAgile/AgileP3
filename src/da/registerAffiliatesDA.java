/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.registerAffiliates;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author AaronLee
 */
public class registerAffiliatesDA {

    private String host = "jdbc:derby://localhost:1527/RESTAURANTDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "RESTAURANT";
    private Connection conn;
    private PreparedStatement stmt;
    private String sqlInsertStr = "INSERT INTO " + tableName + " VALUES(? ,?, ?, ?, ?, ?,?,?)";
    private ResultSet rs;

    public registerAffiliatesDA() {
        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host, user, password);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void addData(registerAffiliates registerAffiliates) throws FileNotFoundException {
        
        try {
            File image = new File(registerAffiliates.getImage());
            FileInputStream fis = new FileInputStream(registerAffiliates.getImage());
            

            stmt = conn.prepareStatement(sqlInsertStr);
            stmt.setString(1, registerAffiliates.getRestaurantId());
            stmt.setString(2, registerAffiliates.getCompanyName());
          
                stmt.setBinaryStream(3, fis, (int) image.length());
            
            stmt.setString(4, registerAffiliates.getRestaurantType());
            stmt.setString(5, registerAffiliates.getContactNo());
            stmt.setString(6, registerAffiliates.getAddress());
            stmt.setString(7, registerAffiliates.getOwnerName());
            stmt.setString(8, registerAffiliates.getOwnerContactNo());
            stmt.executeUpdate();
               conn.close();
        } catch (SQLException ex) {
            ex.getMessage();
            JOptionPane.showMessageDialog(null, ex);
        }
     
    }

    public ResultSet displayRecord() {
        String queryStr = "SELECT * FROM RESTAURANT ORDER BY RESTID DESC";
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
