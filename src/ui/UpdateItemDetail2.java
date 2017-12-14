package ui;

import java.awt.Image;
import java.io.File;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class UpdateItemDetail2 extends javax.swing.JFrame {
    public static String value;
    String host = "jdbc:derby://localhost:1527/RESTAURANTDB";
    String name = "nbuser";
    String password = "nbuser";
    Connection conn;
    Statement stmt;
    ResultSet rs;

    public UpdateItemDetail2() {
        initComponents();
        displayRecord();
    }
    
    public ImageIcon ResizeImage(String ImagePath){
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(showImage.getWidth(), showImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    
    private void displayRecord(){
        try{
            conn = DriverManager.getConnection(host, name, password);
            
            stmt = conn.createStatement();
            String strDisplay = " SELECT * FROM MENU WHERE ITEMID = '" + value + "'";
            rs = stmt.executeQuery(strDisplay);
            
            while(rs.next()){
                itemID.setText(value);
                itemName.setText(rs.getString(3));
                Description.setText(rs.getString(4));
                Price.setText(rs.getString(5));
                Image1.setText(rs.getString(2));
            }
            itemID.setEditable(false);
            Image1.setEditable(false);
            showImage.setIcon(ResizeImage(Image1.getText()));
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        itemID = new javax.swing.JTextField();
        itemName = new javax.swing.JTextField();
        Description = new javax.swing.JTextField();
        Price = new javax.swing.JTextField();
        Image1 = new javax.swing.JTextField();
        conform = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        Browse = new javax.swing.JButton();
        showImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Item ID");

        jLabel2.setText("Item Name");

        jLabel3.setText("Description");

        jLabel4.setText("Price");

        jLabel5.setText("Image");

        itemID.setText("jTextField1");
        itemID.setPreferredSize(new java.awt.Dimension(200, 30));

        itemName.setText("jTextField2");
        itemName.setPreferredSize(new java.awt.Dimension(200, 30));

        Description.setText("jTextField3");
        Description.setPreferredSize(new java.awt.Dimension(200, 30));

        Price.setText("jTextField4");
        Price.setPreferredSize(new java.awt.Dimension(200, 30));

        Image1.setText("jTextField5");
        Image1.setPreferredSize(new java.awt.Dimension(200, 30));

        conform.setText("Conform");
        conform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conformActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        Browse.setText("Browse");
        Browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseActionPerformed(evt);
            }
        });

        showImage.setMaximumSize(new java.awt.Dimension(50, 50));
        showImage.setMinimumSize(new java.awt.Dimension(50, 50));
        showImage.setPreferredSize(new java.awt.Dimension(125, 125));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(itemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(showImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Image1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(42, 42, 42)
                        .addComponent(Browse))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancel)
                        .addGap(18, 18, 18)
                        .addComponent(conform)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(itemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Image1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Browse)))
                        .addGap(18, 18, 18)
                        .addComponent(showImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(conform)
                            .addComponent(cancel))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        UpdateItemDetail1 update = new UpdateItemDetail1();
        update.setVisible(true);
        UpdateItemDetail2.this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void conformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conformActionPerformed
        final String priceExp = "[0-9]{1,7}+([.][0-9]{1,2})?";
        final Pattern pattern = Pattern.compile(priceExp);
        Matcher matcher = pattern.matcher(Price.getText());
        boolean matches = matcher.matches();
        
        if(itemName.getText().equals("")||Description.getText().equals("")||Price.getText().equals("")||Image1.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please fill all the field, TQ");
        }else if(itemName.getText().length() > 100){
            JOptionPane.showMessageDialog(null, "Item Name cannot exceed 100 char, TQ");
        }else if(Description.getText().length() > 150){
            JOptionPane.showMessageDialog(null, "Description cannot exceed 150 char, TQ");
        }else if(Price.getText().length() > 10){
            JOptionPane.showMessageDialog(null, "Price cannot exceed 10 char, TQ");
        }else if(matches == false){
            JOptionPane.showMessageDialog(null, "Price format wrong and re-enter it, TQ");
        }else{
            try{
                String updateStr ="UPDATE MENU SET ITEMNAME = ?, DESCRIPTION = ?, PRICE = ?, IMAGE = ? WHERE ITEMID = ?";
                conn = DriverManager.getConnection(host, name, password);
                PreparedStatement stmt= conn.prepareStatement(updateStr);
                stmt.setString(1, itemName.getText());
                stmt.setString(2, Description.getText());
                stmt.setDouble(3, Double.parseDouble(Price.getText()));
                stmt.setString(4, Image1.getText());
                stmt.setString(5, itemID.getText());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Update Successful, TQ");
                UpdateItemDetail1 update = new UpdateItemDetail1();
                update.setVisible(true);
                UpdateItemDetail2.this.dispose();
            }catch(SQLException ex){
                ex.getMessage();
            }
        }
    }//GEN-LAST:event_conformActionPerformed

    private void BrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose Folder");
        chooser.setAcceptAllFileFilterUsed(false);
        
        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File path = chooser.getSelectedFile();
            Image1.setText(path.toString());
            showImage.setIcon(ResizeImage(Image1.getText()));
        }else{
            JOptionPane.showMessageDialog(null, "No path selected.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BrowseActionPerformed

    public static void main(String args[]) {
        value = args[0];
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
            java.util.logging.Logger.getLogger(UpdateItemDetail2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateItemDetail2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateItemDetail2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateItemDetail2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateItemDetail2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Browse;
    private javax.swing.JTextField Description;
    private javax.swing.JTextField Image1;
    private javax.swing.JTextField Price;
    private javax.swing.JButton cancel;
    private javax.swing.JButton conform;
    private javax.swing.JTextField itemID;
    private javax.swing.JTextField itemName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel showImage;
    // End of variables declaration//GEN-END:variables
}
