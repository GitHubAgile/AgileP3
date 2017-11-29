package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DeliveryDA {
     private String host = "jdbc:derby://localhost:1527/Agile";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName ="Delivery";
    private Connection conn;
    private PreparedStatement stmt;
    ResultSet rs = null;
    
    public DeliveryDA(){
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
    
    public ResultSet displayRecord(String date, String staffId){
        String queryStr = "Select D.DeliveryDate, D.DeliveryTime, O.OrderId, C.CustName, C.CustAddress, C.CustPhone from " +
                "Delivery D, NBUSER.\"ORDER\" O, Customer C where D.StaffId = ? AND D.DELIVERYDATE = ? AND D.OrderId = O.OrderId AND O.CustId = C.CustId";
        
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, staffId);
            stmt.setString(2, date);
            rs = stmt.executeQuery();
            
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return rs;
    }
}

