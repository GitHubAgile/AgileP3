package ui;

import da.DeliveryDA;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CheckDeliveryTime extends JFrame{
    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    Date date = new Date();
    //get tomorrow date
    Date tomorrow = new Date(date.getTime() + (1000 * 60 * 60 * 24));
    //get day after tomorrow date
    Date daTomorrow = new Date(date.getTime() + (1000 * 60 * 60 * 24) * 2);
    
    ResultSet rs = null;
    static int i =0;
    //JTable
    int row = 0, column = 0;
    JTable listTable;
    String[] columnNames = {"Delivery Date", "Delivery Time", "Order ID", "Customer Name", "Customer Address", "Customer Contact"};
    Object[][] data = {};
    DefaultTableModel listTableModel;
    
    private JButton jbtCheck = new JButton("Check");
    String[] dateStrings = {String.valueOf(df.format(date)), String.valueOf(df.format(tomorrow)), String.valueOf(df.format(daTomorrow))};
    JComboBox dateList = new JComboBox(dateStrings); 
    JPanel jpl = new JPanel();          
    
    public CheckDeliveryTime(){ 
        
        jpl.add(dateList, BorderLayout.PAGE_START);
        jpl.add(jbtCheck);
        
        add(jpl, BorderLayout.NORTH);
        
        jbtCheck.addActionListener(new ButtonListener());
        
    }
     
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (i != 0){
                 jpl.remove(listTable);
             }
            listTableModel = new DefaultTableModel(data, columnNames);
            listTableModel.addRow(new Object[]{"Delivery Date", "Delivery Time", "Order ID", "Customer Name", "Customer Address", "Customer Contact"});
           DMLogin dm = new DMLogin();
            DeliveryDA deliveryDA = new DeliveryDA();
        try {
            rs = deliveryDA.displayRecord(dateList.getSelectedItem().toString(), dm.getId());

            while (rs.next()) {
                listTableModel.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6)});
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
          
            listTable = new JTable(listTableModel);
            i++;
            jpl.add(listTable);
            listTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            listTable.setCellEditor(null);
           
            add(jpl, BorderLayout.CENTER);
            
        }
}
    
    public static void main(String args[]){
       CheckDeliveryTime cdTime = new CheckDeliveryTime();
       
       cdTime.setVisible(true);
       cdTime.setLocationRelativeTo(null);
       cdTime.setSize(500,500);
       cdTime.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
}
