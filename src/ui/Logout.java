/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import da.DailyRecordDA;
import da.DeliveryDA;
import domain.DailyRecord;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
class Logout extends JFrame{
    private JButton jbtLogout = new JButton("Check Out");
    private JButton jbtCheckTime = new JButton("Check Duty Time");
    
    private JPanel jp1 = new JPanel();
    
    public Logout(){
        jp1.add(jbtCheckTime);
        jp1.add(jbtLogout);
        add(jp1);
        jbtLogout.addActionListener(new ButtonListener());
        jbtCheckTime.addActionListener(new CheckTimeListener());
    }
    
 public class ButtonListener implements ActionListener{
     public void actionPerformed(ActionEvent e){
        DailyRecordDA dRDA = new DailyRecordDA();
        DailyRecord dR = new DailyRecord();
        DMLogin dm = new DMLogin();
        dR = dRDA.getLastRecord(dm.getId());
        if (dR != null){
            dRDA.updateLogoutTime(dR.getRecordID());
            JOptionPane.showMessageDialog(null, "Check out successfully.");
            new Logout().setVisible(false);
            new Logout().dispose();
            
            new DMLogin().getFocusableWindowState();
        }
        else{
            JOptionPane.showMessageDialog(null, "Error");
        }
     }
     
}
    
 public class CheckTimeListener implements ActionListener{
     public void actionPerformed(ActionEvent e){
         DeliveryDA deDA = new DeliveryDA();
         
         
     }
 }
    
    public static void main(String[] args){
    Logout lg = new Logout();
    lg.setVisible(true);
    }
    
}
