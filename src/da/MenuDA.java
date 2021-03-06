package da;

import domain.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MenuDA {
    private String host = "jdbc:derby://localhost:1527/Agile";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName ="Menu";
    private String sqlInsertStr = "INSERT INTO " + tableName + " VALUES(? ,?, ?, ?, ?, ?,?,?)";
   
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs = null;
    
    public MenuDA(){
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
    public ResultSet displayRecord(String resId) {
        String queryStr = "Select * from " + tableName + " where restId = ?";
        ResultSet rs = null;
        try {
           stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, resId);
               
            rs = stmt.executeQuery();
            
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return rs;
       
    }
     public ArrayList getMenu(String resId){
        String selectStr = "Select * from " + tableName + " where restId = ?";
        Menu menu = null;
        ArrayList<Menu> resultList = new ArrayList<Menu>();
        try {
            stmt = conn.prepareStatement(selectStr);
            stmt.setString(1, resId);
               
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                menu = new Menu(rs.getString(1),rs.getBytes(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6));
                resultList.add(menu);
           
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return resultList;
        
    }
      public ArrayList<Menu> BindTable(){
        
   ArrayList<Menu> list = new ArrayList<Menu>();
  
   Statement st;

   
   try {
   st = conn.createStatement();
   rs = st.executeQuery("SELECT * FROM MENU");
   
   Menu p;
   while(rs.next()){
   p = new Menu(
   rs.getString("ITEMID"),rs.getBytes("IMAGE"),rs.getString("ITEMNAME"),rs.getString("DESCRIPTION"),rs.getString("PRICE"),rs.getString("RESTID")
   );
   list.add(p);
   }
   
   } catch (Exception ex) {
   
   }
   return list;
   }

}
