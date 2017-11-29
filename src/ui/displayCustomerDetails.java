package ui;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import da.displayCustomerDetailDA;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AaronLee
 */
public class displayCustomerDetails extends JFrame {

    //declaration 
   
    JTable listTable;
    ResultSet rs = null;
    displayCustomerDetailDA displaycustomerdetailda = new displayCustomerDetailDA();
    int row = 0, column = 0;
    private JLabel jTitle = new JLabel("Customer Details");
    String[] columnNames = {"Order ID", "Customer ID", "Customer Name", "Customer Address", "Customer Phone"};
    Object[][] data = {};
    DefaultTableModel listTableModel;
    JPanel jpane = new JPanel(new BorderLayout());
    JPanel jpane2 = new JPanel(new GridLayout(1, 2));
    private JButton jbtSubmit = new JButton("View");
    private JButton jbtCancel = new JButton("Close");
 JFrame frame = new JFrame("Customer Details");
    public displayCustomerDetails() {
        listTableModel = new DefaultTableModel(data, columnNames);

        listTableModel.addRow(new Object[]{"Order ID", "Customer ID", "Customer Name", "Customer Address", "Customer Phone"});

        try {
            rs = displaycustomerdetailda.displayRecord();

            while (rs.next()) {
                listTableModel.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)});
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

        listTable = new JTable(listTableModel);
        listTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        listTable.setCellEditor(null);
        listTable.setBounds(37, 143, 397, 183);

       
        jpane.add(listTable);
        jpane2.add(jbtSubmit);
        jpane2.add(jbtCancel);
        frame.add(jTitle, BorderLayout.NORTH);
        frame.add(jpane, BorderLayout.CENTER);
        frame.add(jpane2, BorderLayout.SOUTH);
        jbtCancel.addActionListener(new cancelActionListener());
        jbtSubmit.addActionListener(new submitActionListener());

        //frame.add(listTable);
        setTitle("Customer Details");
        setSize(500, 600);
        setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();

    }

    private class cancelActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            
        }
    }

    private class submitActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String Details = null;
            rs = null;
            int row;
             row = listTable.getSelectedRow();
            if(row == -1){
                JOptionPane.showMessageDialog(null, "Please select a field first!");
            }else{
            String value = listTable.getModel().getValueAt(row, 1).toString();
            try {
                rs = displaycustomerdetailda.displayChoosenRecord(value);
                if(rs.next()){
                Details = "Order ID : " +rs.getString(1) +  "\nCustomer ID : " + rs.getString(2) + "\nCustomer Name : " + rs.getString(3) + "\nCustomer Address : " + rs.getString(4) + "\nCustomer Phone :" + rs.getString(5);
          JOptionPane.showMessageDialog(null, Details, "Customer Details", JOptionPane.INFORMATION_MESSAGE);
                }
                } catch (Exception ex) {

            }
            }
        }
    }

    public static void main(String args[]) {

        new displayCustomerDetails();
    }

}
