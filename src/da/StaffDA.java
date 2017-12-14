package da;

import domain.Staff;
import java.sql.*;
import javax.swing.*;

public class StaffDA {
    private String host = "jdbc:derby://localhost:1527/Agile";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName ="Staff";
    private Connection conn;
    private PreparedStatement stmt;
    
    public StaffDA(){
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

     public Staff getRecord(String id, String password) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE STAFFID = ? AND STAFFPW = ?";
        Staff staff = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                staff = new Staff(id, password, 
                        rs.getString("STAFFNAME"), rs.getString("STAFFPHONE"), rs.getString("STAFFEMAIL"),
                        rs.getString("POSITION"), rs.getString("STATUS"));
           
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staff;
    }
     
    
    public static void main(String args[]){
        
    }
    
    
}
