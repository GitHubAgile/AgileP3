package ui;
//123
import java.awt.Image;
import java.io.File;
import java.sql.*;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class RegisterAffiliates extends javax.swing.JFrame {

    Connection conn;
    Statement stmt;
    ResultSet rs;
    String host = "jdbc:derby://localhost:1527/RESTAURANTDB";
    String name = "nbuser";
    String password = "nbuser";

    public RegisterAffiliates() {
        initComponents();
        showRestaurantID();
    }

    private void showRestaurantID() {
        int count = 1001;
        try {
            conn = DriverManager.getConnection(host, name, password);

            stmt = conn.createStatement();
            String strCountRestID = " SELECT RESTID FROM RESTAURANT ";
            rs = stmt.executeQuery(strCountRestID);
            while (rs.next()) {
                count++;
            }
            jRestID.setText("R" + count);
            jRestID.setEditable(false);
            jRestImage.setEditable(false);
            jRestName.setText("");
            jRestPhone.setText("");
            jRestAddress.setText("");
            jOwnerName.setText("");
            jOwnerPhone.setText("");
            jRestImage.setText("");
            jLabelImage.setText("");
            jLabelImage.setIcon(ResizeImage(jRestImage.getText()));
            ButtonRestType.clearSelection();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonRestType = new javax.swing.ButtonGroup();
        RestID = new javax.swing.JLabel();
        RestName = new javax.swing.JLabel();
        RestPhone = new javax.swing.JLabel();
        RestAddress = new javax.swing.JLabel();
        OwnerName = new javax.swing.JLabel();
        OwnerPhone = new javax.swing.JLabel();
        RestType = new javax.swing.JLabel();
        RestImage = new javax.swing.JLabel();
        jRestID = new javax.swing.JTextField();
        jRestName = new javax.swing.JTextField();
        jRestAddress = new javax.swing.JTextField();
        jOwnerName = new javax.swing.JTextField();
        jRadioFastFood = new javax.swing.JRadioButton();
        jRadioJapaneseFood = new javax.swing.JRadioButton();
        jRadioWestern = new javax.swing.JRadioButton();
        jRadioChineseFood = new javax.swing.JRadioButton();
        jLabelImage = new javax.swing.JLabel();
        ButtonRegister = new javax.swing.JButton();
        ButtonReset = new javax.swing.JButton();
        jRestImage = new javax.swing.JTextField();
        jBrowse = new javax.swing.JButton();
        jRestPhone = new javax.swing.JFormattedTextField();
        jOwnerPhone = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        RestID.setText("Restaurant ID : ");

        RestName.setText("Restaurant Name : ");

        RestPhone.setText("Restaurant Phone : ");

        RestAddress.setText("Restaurant Address :");

        OwnerName.setText("Owner Name : ");

        OwnerPhone.setText("Owner Phone : ");

        RestType.setText("Restaurant Type : ");

        RestImage.setText("Restaurant Image : ");

        jRestID.setText("jTextField1");

        jRestName.setText("jTextField2");
        jRestName.setPreferredSize(new java.awt.Dimension(200, 20));

        jRestAddress.setText("jTextField4");
        jRestAddress.setPreferredSize(new java.awt.Dimension(200, 20));

        jOwnerName.setText("jTextField5");
        jOwnerName.setPreferredSize(new java.awt.Dimension(200, 20));

        ButtonRestType.add(jRadioFastFood);
        jRadioFastFood.setText("Fast Food");
        jRadioFastFood.setPreferredSize(new java.awt.Dimension(99, 23));

        ButtonRestType.add(jRadioJapaneseFood);
        jRadioJapaneseFood.setText("Japanese Food");

        ButtonRestType.add(jRadioWestern);
        jRadioWestern.setText("Western");

        ButtonRestType.add(jRadioChineseFood);
        jRadioChineseFood.setText("Chinese Food");

        jLabelImage.setText("jLabel1");
        jLabelImage.setPreferredSize(new java.awt.Dimension(125, 125));

        ButtonRegister.setText("Register");
        ButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRegisterActionPerformed(evt);
            }
        });

        ButtonReset.setText("Reset");
        ButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonResetActionPerformed(evt);
            }
        });

        jRestImage.setText("jTextField1");
        jRestImage.setPreferredSize(new java.awt.Dimension(200, 20));

        jBrowse.setText("Browse");
        jBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowseActionPerformed(evt);
            }
        });

        try {
            jRestPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jRestPhone.setPreferredSize(new java.awt.Dimension(200, 20));

        try {
            jOwnerPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jOwnerPhone.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RestID)
                            .addComponent(RestName)
                            .addComponent(RestPhone)
                            .addComponent(RestAddress)
                            .addComponent(OwnerName)
                            .addComponent(OwnerPhone)
                            .addComponent(RestType))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioJapaneseFood)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioChineseFood))
                            .addComponent(jOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRestAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRestName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRestID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioFastFood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioWestern))
                            .addComponent(jRestPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jOwnerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(ButtonReset)
                            .addGap(18, 18, 18)
                            .addComponent(ButtonRegister))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(RestImage)
                            .addGap(42, 42, 42)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jRestImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(48, 48, 48)
                                    .addComponent(jBrowse))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RestID)
                    .addComponent(jRestID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RestName)
                    .addComponent(jRestName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RestPhone)
                    .addComponent(jRestPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RestAddress)
                    .addComponent(jRestAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OwnerName)
                    .addComponent(jOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OwnerPhone)
                    .addComponent(jOwnerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RestType)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioFastFood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioWestern)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioJapaneseFood)
                    .addComponent(jRadioChineseFood))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(RestImage)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRestImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBrowse))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ButtonRegister)
                                    .addComponent(ButtonReset))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(43, Short.MAX_VALUE))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowseActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose Folder");
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File path = chooser.getSelectedFile();
            jRestImage.setText(path.toString());
            jLabelImage.setIcon(ResizeImage(jRestImage.getText()));
        } else {
            JOptionPane.showMessageDialog(null, "No path selected.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBrowseActionPerformed

    private void ButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonResetActionPerformed
        showRestaurantID();

    }//GEN-LAST:event_ButtonResetActionPerformed

    private void ButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRegisterActionPerformed
        ButtonModel buttonRestType = ButtonRestType.getSelection();
        jRadioFastFood.setActionCommand("Fast Food");
        jRadioJapaneseFood.setActionCommand("Japanese Food");
        jRadioChineseFood.setActionCommand("Chinese Food");
        jRadioWestern.setActionCommand("Western");
        if (buttonRestType == null || jRestName.getText().equals("") || jRestPhone.getText().equals("") || jRestAddress.getText().equals("") || jRestImage.getText().equals("") || jOwnerName.getText().equals("") || jOwnerPhone.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the field, TQ");
        } else {
            try {
                String choice = buttonRestType.getActionCommand();
                String addStr = "INSERT INTO RESTAURANT VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
                conn = DriverManager.getConnection(host, name, password);
                PreparedStatement stmt = conn.prepareStatement(addStr);
                stmt.setString(1, jRestID.getText());
                stmt.setString(2, jRestName.getText());
                stmt.setString(3, jRestImage.getText());
                stmt.setString(4, choice);
                stmt.setString(5, jRestPhone.getText());
                stmt.setString(6, jRestAddress.getText());
                stmt.setString(7, jOwnerName.getText());
                stmt.setString(8, jOwnerPhone.getText());
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Insert New Restaurant Successful, TQ");
                showRestaurantID();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_ButtonRegisterActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterAffiliates().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonRegister;
    private javax.swing.JButton ButtonReset;
    private javax.swing.ButtonGroup ButtonRestType;
    private javax.swing.JLabel OwnerName;
    private javax.swing.JLabel OwnerPhone;
    private javax.swing.JLabel RestAddress;
    private javax.swing.JLabel RestID;
    private javax.swing.JLabel RestImage;
    private javax.swing.JLabel RestName;
    private javax.swing.JLabel RestPhone;
    private javax.swing.JLabel RestType;
    private javax.swing.JButton jBrowse;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JTextField jOwnerName;
    private javax.swing.JFormattedTextField jOwnerPhone;
    private javax.swing.JRadioButton jRadioChineseFood;
    private javax.swing.JRadioButton jRadioFastFood;
    private javax.swing.JRadioButton jRadioJapaneseFood;
    private javax.swing.JRadioButton jRadioWestern;
    private javax.swing.JTextField jRestAddress;
    private javax.swing.JTextField jRestID;
    private javax.swing.JTextField jRestImage;
    private javax.swing.JTextField jRestName;
    private javax.swing.JFormattedTextField jRestPhone;
    // End of variables declaration//GEN-END:variables
}
