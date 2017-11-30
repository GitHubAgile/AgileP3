/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
//testing
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author x.x
 */

//testing
public class TrackStatusDeliveryMan extends javax.swing.JFrame {
    Connection conn;
    Statement stmt;
    ResultSet rs;
    
    /**
     * Creates new form TrackStatusDeliveryMan
     */
    public TrackStatusDeliveryMan() {
        initComponents();
        showRecords();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Delivery = new javax.swing.JButton();
        TakeOff = new javax.swing.JButton();
        BreakTime = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Delivery.setText("Delivery");
        Delivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeliveryActionPerformed(evt);
            }
        });

        TakeOff.setText("Take Off");
        TakeOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TakeOffActionPerformed(evt);
            }
        });

        BreakTime.setText("Break Time");
        BreakTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BreakTimeActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Staff ID", "Staff Name", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BreakTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Delivery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TakeOff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Delivery, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TakeOff, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BreakTime)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeliveryActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try{
            model.setRowCount(0);
            //Connect to the database
            String host = "jdbc:derby://localhost:1527/RESTAURANTDB";
            String name = "nbuser";
            String password = "nbuser";
            conn = DriverManager.getConnection(host, name, password);
            
            stmt = conn.createStatement();
            String strDisplay = " SELECT * FROM STAFF WHERE STATUS = 'Delivery' ";
            rs = stmt.executeQuery(strDisplay);
            
            while(rs.next()){
                String row1 = rs.getString(1);
                String row2 = rs.getString(3);
                String row3 = rs.getString(7);
                
                Object[] row = { row1, row2, row3 };              
                model.addRow(row);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_DeliveryActionPerformed

    private void TakeOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TakeOffActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try{
            model.setRowCount(0);
            //Connect to the database
            String host = "jdbc:derby://localhost:1527/RESTAURANTDB";
            String name = "nbuser";
            String password = "nbuser";
            conn = DriverManager.getConnection(host, name, password);
            
            stmt = conn.createStatement();
            String strDisplay = " SELECT * FROM STAFF WHERE STATUS = 'Take Off' ";
            rs = stmt.executeQuery(strDisplay);
            
            while(rs.next()){
                String row1 = rs.getString(1);
                String row2 = rs.getString(3);
                String row3 = rs.getString(7);
                
                Object[] row = { row1, row2, row3 };              
                model.addRow(row);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_TakeOffActionPerformed

    private void BreakTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BreakTimeActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try{
            model.setRowCount(0);
            //Connect to the database
            String host = "jdbc:derby://localhost:1527/RESTAURANTDB";
            String name = "nbuser";
            String password = "nbuser";
            conn = DriverManager.getConnection(host, name, password);
            
            stmt = conn.createStatement();
            String strDisplay = " SELECT * FROM STAFF WHERE STATUS = 'Break Time' ";
            rs = stmt.executeQuery(strDisplay);
            
            while(rs.next()){
                String row1 = rs.getString(1);
                String row2 = rs.getString(3);
                String row3 = rs.getString(7);
                
                Object[] row = { row1, row2, row3 };              
                model.addRow(row);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_BreakTimeActionPerformed

    private void showRecords(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try{
            //Connect to the database
            String host = "jdbc:derby://localhost:1527/RESTAURANTDB";
            String name = "nbuser";
            String password = "nbuser";
            conn = DriverManager.getConnection(host, name, password);
            
            stmt = conn.createStatement();
            String strDisplay = " SELECT * FROM STAFF WHERE POSITION = 'DeliveryMan' ";
            rs = stmt.executeQuery(strDisplay);
            
            while(rs.next()){
                String row1 = rs.getString(1);
                String row2 = rs.getString(3);
                String row3 = rs.getString(7);
                
                Object[] row = { row1, row2, row3 };              
                model.addRow(row);
            }
           
            
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrackStatusDeliveryMan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrackStatusDeliveryMan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrackStatusDeliveryMan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrackStatusDeliveryMan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrackStatusDeliveryMan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BreakTime;
    private javax.swing.JButton Delivery;
    private javax.swing.JButton TakeOff;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
