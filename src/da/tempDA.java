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
import javax.swing.JOptionPane;

/**
 *
 * @author AaronLee
 */
public class tempDA {

    private String host = "jdbc:derby://localhost:1527/RESTAURANTDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "ORDERMENU";
    private Connection conn;
    private PreparedStatement stmt;
    private String sqlInsertStr = "INSERT INTO " + tableName + " VALUES(?, ? ,?)";
    private ResultSet rs;

    public tempDA() {
        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host, user, password);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void addData(String OrderID, String item, int index) {

        try {

            stmt = conn.prepareStatement(sqlInsertStr);
            stmt.setString(1, OrderID);
            stmt.setString(2, item);
            stmt.setInt(3, index);

            stmt.executeUpdate();
//            conn.close();
            // force garbage collection to unload the EmbeddedDriver
            //  so Derby can be restarted
            System.gc();
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
