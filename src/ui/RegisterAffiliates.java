/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import domain.registerAffiliates;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import da.registerAffiliatesDA;
import java.io.File;
import java.sql.Blob;
import java.sql.ResultSet;

/**
 *
 * @author AaronLee
 */
public class RegisterAffiliates extends JFrame{
  //declaration
    String ErrorMsg;
    int Error = 0;
    ResultSet rs = null;
    Blob image = null;
    private JLabel jlblPlain = new JLabel("");
    private JLabel jlblTitle = new JLabel("Register As Affiliates");
    private JLabel jlblName = new JLabel("Company Name :");
    private JLabel jlblType = new JLabel("Restaurant Type :");
    private JLabel jlblAddress = new JLabel("Address :");
    private JLabel jlblContactNo = new JLabel("Contact Number :");
    private JLabel jlblownerContactNo = new JLabel("Owner's Contact Number :");
    private JLabel jlblownerName = new JLabel("Owner's Name");
    private JLabel jlblOpen = new JLabel("Choose Image :");
    private JLabel jlblImage = new JLabel ();
    private JTextField jtfName = new JTextField();
    private JComboBox jcoRestaurantType = new JComboBox();
    private JTextField jtfAddress = new JTextField();
    private JTextField jtfContactNo = new JTextField();
    private JTextField jtfOwnerName = new JTextField();
    private JTextField jtfOwnerContactNo = new JTextField();
    private JTextField jtfOpen = new JTextField();
    private JButton jbtSubmit = new JButton("Submit");
    private JButton jbtCancel = new JButton("Cancel");
    private JButton jbtOpen = new JButton("Open");
    

    public RegisterAffiliates() {
        //declaration
        Font fontTitle = new Font("Courier", Font.BOLD, 30);
        Font fontlabel = new Font("Courier", Font.BOLD, 15);
        JPanel jpane = new JPanel(new BorderLayout());
        JPanel jgridpane = new JPanel(new GridLayout(9, 2));
        jpane.add(jlblTitle);
        jcoRestaurantType.addItem("");
        jcoRestaurantType.addItem("Western Cuisine");
        jcoRestaurantType.addItem("Chinese Cuisine");
        jcoRestaurantType.addItem("Malay Cuisine");
        jcoRestaurantType.addItem("Indian Cuisine");
        jcoRestaurantType.addItem("Others");
        jgridpane.add(jlblName);
        jgridpane.add(jtfName);
        jgridpane.add(jlblownerName);
        jgridpane.add(jtfOwnerName);
        jgridpane.add(jlblownerContactNo);
        jgridpane.add(jtfOwnerContactNo);
        jgridpane.add(jlblType);
        jgridpane.add(jcoRestaurantType);
        jgridpane.add(jlblAddress);
        jgridpane.add(jtfAddress);
        jgridpane.add(jlblContactNo);
        jgridpane.add(jtfContactNo);
        jgridpane.add(jlblOpen);
        jgridpane.add(jtfOpen);
        jgridpane.add(jlblPlain);
        jgridpane.add(jbtOpen);
        jgridpane.add(jbtSubmit);
        jgridpane.add(jbtCancel);

        //Bold Label
        jlblTitle.setFont(fontTitle);
        jlblName.setFont(fontlabel);
        jlblType.setFont(fontlabel);
        jlblAddress.setFont(fontlabel);
        jlblContactNo.setFont(fontlabel);
        jlblOpen.setFont(fontlabel);
        jlblownerName.setFont(fontlabel);
        jlblownerContactNo.setFont(fontlabel);
        

        //add panel to frame
        add(jpane, BorderLayout.NORTH);
        add(jgridpane, BorderLayout.CENTER);
        jbtCancel.addActionListener(new cancelActionListener());
        jbtSubmit.addActionListener(new AddListener());
        jbtOpen.addActionListener(new openActionListener());
        //GUI settings
        setTitle("Register Affiliates");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private class AddListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //declaration
            String restaurantId = null;
            int temp;
            registerAffiliates registeraffiliates = new registerAffiliates();
            registerAffiliatesDA registeraffiliatesda = new registerAffiliatesDA();
            ConstraintCheck();
            if(Error == 0){
                
            
            
            try {

                //display record and +1 restaurant id
                rs = registeraffiliatesda.displayRecord();
                if (rs.next()) {

                    restaurantId = rs.getString(1);
                    restaurantId = restaurantId.substring(1);
                    temp = Integer.parseInt(restaurantId);
                    temp++;
                    restaurantId = String.format("R%04d", temp);
                }
            } catch (Exception ex) {

            }
            //set Data
            registeraffiliates.setRestaurantId(restaurantId);
            registeraffiliates.setCompanyName(jtfName.getText());
            registeraffiliates.setRestaurantType(jcoRestaurantType.getSelectedItem().toString());
            registeraffiliates.setAddress(jtfAddress.getText());
            registeraffiliates.setContactNo(jtfContactNo.getText());
            registeraffiliates.setOwnerName(jtfOwnerName.getText());
            registeraffiliates.setOwnerContactNo(jtfOwnerContactNo.getText());
            registeraffiliates.setImage(jtfOpen.getText());
            
            
           
            try {
                registeraffiliatesda.addData(registeraffiliates);
            } catch (Exception ex) {
                ex.getMessage();

            }
            JOptionPane.showMessageDialog(null, "Thank You for joining us as an Affiliates! Your Restaurant ID is : " + registeraffiliates.getRestaurantId());
            }
            else 
                Error = 0;

        
            

    }
            
    }
public void clearText(){
    
   jtfName.setText("");
    jtfAddress.setText("");
    jtfContactNo.setText("");
    jtfOwnerName.setText("");
    jtfOwnerContactNo.setText("");
    jtfOpen.setText("");
   
}
public void ConstraintCheck()
{
 //validation CompanyName 
    //Testing
if(!jtfName.getText().matches("[a-zA-Z]+")){
    ErrorMsg = "Company Name could not contain characters such as symbol and digits.\n";
    
    
   }

//validation owners name

if(!jtfOwnerName.getText().matches("[a-zA-Z]+")){
    
  ErrorMsg += "Please enter Correct Owner's Name !\n";
       
}

//validation Owner's Contact Number

if(!jtfOwnerContactNo.getText().matches("\\d{3}-\\d{7}")&&!jtfContactNo.getText().matches("\\d{3}\\d{7}")){
     
     ErrorMsg += "Please Enter the correct Owner's Phone Number\n";
}

//Validation company type
if(jcoRestaurantType.getSelectedItem().equals("")){
    
    ErrorMsg += "Please Select A restaurant Type!\n";

}

//valitation address

if(jtfAddress.getText().equals("")){
    
    ErrorMsg += "Please enter restaurant address!\n";

}

//validation phone number
  if(!jtfContactNo.getText().matches("\\d{3}-\\d{7}")&&!jtfContactNo.getText().matches("\\d{3}\\d{7}") ){
   ErrorMsg += "Please Enter the correct Phone Number \n";
 } 
 //validation image
 if(jtfOpen.getText().equals("")){
     ErrorMsg += "Please choose a restaurant Image!";
 }
  
  //checkErrorExists
  if(!ErrorMsg.equals("")){
      //clear
      JOptionPane.showMessageDialog(this, ErrorMsg ,  "Error",JOptionPane.ERROR_MESSAGE);
      ErrorMsg = "";
      Error = 1;
      clearText();
     
  }
  
 
}
private class cancelActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        clearText();
    }
}
 private class openActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Choose Folder");
            chooser.setAcceptAllFileFilterUsed(false);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File path = chooser.getSelectedFile();
                jtfOpen.setText(path.toString());
                
                jlblImage = new JLabel(new ImageIcon(jtfOpen.getText()));
            } else {
                JOptionPane.showMessageDialog(null, "No path selected.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         new RegisterAffiliates();
    }
    
}
