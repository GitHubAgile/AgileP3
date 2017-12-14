/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import da.GetCustOrderForOneRest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import da.GetCustOrderForOneCust;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CustTrackDetail extends javax.swing.JFrame {

    GetCustOrderForOneCust gcofor = new GetCustOrderForOneCust();
    
    public CustTrackDetail(String orderid, String restname) {
        initComponents();
        Calendar cal = Calendar.getInstance();
                 int year = cal.get(Calendar.YEAR);
                 int month = cal.get(Calendar.MONTH)+1;
                 int day = cal.get(Calendar.DATE);
                 int hour = cal.get(Calendar.HOUR);
                 int minute = cal.get(Calendar.MINUTE);
String Date = String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day);
        jtfRestName.setText(restname);
        jtfCurrentDate.setText(Date);
        ResultSet rs2 = gcofor.getRestaurant(restname);
        try{
            if(rs2.next()){
                jtfRestCont.setText(rs2.getString(1));
            }
        }catch (SQLException ex) {
            Logger.getLogger(CustTrackDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet rs4 = gcofor.getDeliveryByOrderID(orderid);
        String deliveryid = "";
        try {
            if(rs4.next()){
                deliveryid = rs4.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustTrackDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = gcofor.getDelivery(deliveryid);
        try {
            while(rs.next()){
                jtfID.setText(rs.getString(1));
                jtfDeliveryStatus.setText(rs.getString(4));
                switch (rs.getString(4)) {
                    case "Delivering":
                        {
                            jtfDeliveryStatus.setDisabledTextColor(new java.awt.Color(0,255,0));
                            jtfDistance.setText(rs.getString(6)+"KM");
                            jtfDeliverTime.setText(rs.getString(3));
                            jtfEstimateTime.setText(rs.getString(5));
                            int hourleft = 0;
                            int minuteleft = 0;
                            String[] time = rs.getString(5).split(":");
                            hourleft = Integer.parseInt(time[0]) - hour;
                            if(hourleft == 0){
                                minuteleft = Integer.parseInt(time[1]) - minute;
                            }else if(hourleft > 0){
                                if(Integer.parseInt(time[1]) > minute){
                                    minuteleft = Integer.parseInt(time[1]) - minute;
                                }else if(minute > Integer.parseInt(time[1])){
                                    minuteleft =  Integer.parseInt(time[1]) - minute + 60;
                                    hourleft -= 1;
                                }
                            }       if(hourleft < 1){
                                jlblMessage.setText("Your food will be arrive in " + minuteleft + " minutes.Please be patient.");
                            }else{
                                jlblMessage.setText("Your food will be arrive in "+hourleft+ " hours " + minuteleft + " minutes.Please be patient.");
                            }       ResultSet rs3 = gcofor.getStaff(rs.getString(7));
                            try{
                                if(rs3.next()){
                                    jtfStaffName.setText(rs3.getString(1));
                                    jtfStaffCont.setText(rs3.getString(2));
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(CustTrackDetail.class.getName()).log(Level.SEVERE, null, ex);
                            }       break;
                        }
                    case "Assigned":
                        {
                            jtfDeliveryStatus.setDisabledTextColor(new java.awt.Color(255,255,51));
                            jtfDeliverTime.setText("-");
                            jtfDistance.setText("-");
                            jtfEstimateTime.setText("-");
                            jlblMessage.setText("Delivery Man is assigned. Delivery will be conducted soon.");
                            ResultSet rs3 = gcofor.getStaff(rs.getString(7));
                            try{
                                if(rs3.next()){
                                    jtfStaffName.setText(rs3.getString(1));
                                    jtfStaffCont.setText(rs3.getString(2));
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(CustTrackDetail.class.getName()).log(Level.SEVERE, null, ex);
                            }       break;
                        }
                    case "Pending":
                        jtfDeliveryStatus.setDisabledTextColor(new java.awt.Color(0,255,255));
                        jtfStaffName.setText("-");
                        jtfStaffCont.setText("-");
                        jtfDeliverTime.setText("-");
                        jtfDistance.setText("-");
                        jtfEstimateTime.setText("-");
                        jlblMessage.setText("Your Order is still in Pending.Please check it later.");
                        break;
                    default:
                        break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustTrackDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public CustTrackDetail() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblFrom = new javax.swing.JLabel();
        jtfRestName = new javax.swing.JTextField();
        jlblDateTime = new javax.swing.JLabel();
        jtfDistance = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfDeliverTime = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfEstimateTime = new javax.swing.JTextField();
        jlblStatus = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfDeliveryStatus = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfStaffName = new javax.swing.JTextField();
        jlblRestCont = new javax.swing.JLabel();
        jtfRestCont = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtfCurrentDate = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtfStaffCont = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
        jlblMessage = new javax.swing.JLabel();
        jbtOK = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlblFrom.setBackground(new java.awt.Color(0, 0, 0));
        jlblFrom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblFrom.setText("         Delivery From");
        jlblFrom.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlblFrom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlblFrom.setMaximumSize(new java.awt.Dimension(94, 14));
        jlblFrom.setMinimumSize(new java.awt.Dimension(94, 14));

        jtfRestName.setEditable(false);
        jtfRestName.setBackground(new java.awt.Color(255, 255, 255));
        jtfRestName.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jtfRestName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfRestName.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jlblDateTime.setBackground(new java.awt.Color(0, 0, 0));
        jlblDateTime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblDateTime.setText("                       DELIVERY TIME");
        jlblDateTime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtfDistance.setEditable(false);
        jtfDistance.setBackground(new java.awt.Color(255, 255, 255));
        jtfDistance.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jtfDistance.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfDistance.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("           Distance");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfDeliverTime.setEditable(false);
        jtfDeliverTime.setBackground(new java.awt.Color(102, 255, 102));
        jtfDeliverTime.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jtfDeliverTime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfDeliverTime.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel1.setText("  :");

        jLabel3.setText("  :");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("              ESTIMATIED ARRIVAL TIME");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtfEstimateTime.setEditable(false);
        jtfEstimateTime.setBackground(new java.awt.Color(102, 255, 102));
        jtfEstimateTime.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jtfEstimateTime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfEstimateTime.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jlblStatus.setBackground(new java.awt.Color(0, 0, 0));
        jlblStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblStatus.setText("            STATUS");
        jlblStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("  :");

        jtfDeliveryStatus.setEditable(false);
        jtfDeliveryStatus.setBackground(new java.awt.Color(255, 255, 255));
        jtfDeliveryStatus.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jtfDeliveryStatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfDeliveryStatus.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("           Staff Name");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("  :");

        jtfStaffName.setEditable(false);
        jtfStaffName.setBackground(new java.awt.Color(255, 255, 255));
        jtfStaffName.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jtfStaffName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfStaffName.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jlblRestCont.setBackground(new java.awt.Color(0, 0, 0));
        jlblRestCont.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblRestCont.setText(" Restaurant Contact NO");
        jlblRestCont.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlblRestCont.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jtfRestCont.setEditable(false);
        jtfRestCont.setBackground(new java.awt.Color(255, 255, 255));
        jtfRestCont.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jtfRestCont.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfRestCont.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel7.setText("  :");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("               Date");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("  :");

        jtfCurrentDate.setEditable(false);
        jtfCurrentDate.setBackground(new java.awt.Color(255, 255, 255));
        jtfCurrentDate.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jtfCurrentDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfCurrentDate.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("                                                                       DELIVERY INFO");
        jLabel11.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("     Staff Contact NO");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("  :");

        jtfStaffCont.setEditable(false);
        jtfStaffCont.setBackground(new java.awt.Color(255, 255, 255));
        jtfStaffCont.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jtfStaffCont.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfStaffCont.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("         DELIVERY ID");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setText("  :");

        jtfID.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jtfID.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfID.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jlblMessage.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlblMessage.setFocusable(false);
        jlblMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jbtOK.setBackground(new java.awt.Color(0, 255, 51));
        jbtOK.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtOK.setText("OK");
        jbtOK.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtOKActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Note : Please contact the restaurant or staff if any problem occurs.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtOK, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlblMessage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlblDateTime, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                            .addComponent(jtfDeliverTime))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                            .addComponent(jtfEstimateTime)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfDeliveryStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtfStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtfStaffCont, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jlblFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlblRestCont, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfRestCont, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfRestName, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfDistance)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfCurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfID)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfID)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlblFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfRestName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblRestCont, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfRestCont, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfCurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDeliveryStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfStaffCont, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfEstimateTime)
                    .addComponent(jtfDeliverTime, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtOK, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtOKActionPerformed
        new CustOrderView().setVisible(true);
            dispose();
    }//GEN-LAST:event_jbtOKActionPerformed

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
            java.util.logging.Logger.getLogger(CustTrackDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustTrackDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustTrackDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustTrackDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustTrackDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbtOK;
    private javax.swing.JLabel jlblDateTime;
    private javax.swing.JLabel jlblFrom;
    private javax.swing.JLabel jlblMessage;
    private javax.swing.JLabel jlblRestCont;
    private javax.swing.JLabel jlblStatus;
    private javax.swing.JTextField jtfCurrentDate;
    private javax.swing.JTextField jtfDeliverTime;
    private javax.swing.JTextField jtfDeliveryStatus;
    private javax.swing.JTextField jtfDistance;
    private javax.swing.JTextField jtfEstimateTime;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfRestCont;
    private javax.swing.JTextField jtfRestName;
    private javax.swing.JTextField jtfStaffCont;
    private javax.swing.JTextField jtfStaffName;
    // End of variables declaration//GEN-END:variables
}
