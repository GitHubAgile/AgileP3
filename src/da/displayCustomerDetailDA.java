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

/**
 *
 * @author AaronLee
 */
public class displayCustomerDetailDA {
    private String host = "jdbc:derby://localhost:1527/Agile";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "CUSTOMER";
    private Connection conn;
    private PreparedStatement stmt;
    private String sqlInsertStr = "INSERT INTO " + tableName + " VALUES(? ,?, ?, ?, ?, ?,?,?)";
    private ResultSet rs;
    
 public displayCustomerDetailDA() {
        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host, user, password);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
public ResultSet displayRecord() {
        String queryStr = "SELECT NBUSER.\"ORDER\".OrderID, NBUSER.\"ORDER\".CUSTID, Customer.CUSTNAME, CUSTOMER.CUATADDRESS,  CUSTOMER.CUSTPHONE\n" +
"FROM NBUSER.\"ORDER\" ,CUSTOMER\n" +
"WHERE NBUSER.\"ORDER\".CUSTID = CUSTOMER.CUSTID  \n";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return rs;
       
    }
public ResultSet displayChoosenRecord(String custID) {
        String queryStr = "SELECT NBUSER.\"ORDER\".OrderID , Customer.CustID, CustName, CUATAddress, CustPhone FROM NBUSER.\"ORDER\", CUSTOMER WHERE Customer.CUSTID = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, custID);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return rs;
       
    }
    

}