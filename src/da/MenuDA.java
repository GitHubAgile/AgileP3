/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author AaronLee
 */

public class MenuDA {

    private String host = "jdbc:derby://localhost:1527/RESTAURANTDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "MENU";
    private Connection conn;
    private PreparedStatement stmt;
    private String sqlInsertStr = "INSERT INTO " + tableName + " VALUES(? ,?, ?, ?, ?, ?,?,?)";
    private ResultSet rs;

    public MenuDA() {
        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host, user, password);
        } catch (Exception ex) {
            ex.getMessage();
        }
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
