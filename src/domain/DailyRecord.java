package domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */

public class DailyRecord {
    private String recordID;
    private String todayDate;
    private String checkInTime;
    private String checkOutTime;
    private double totalDistanceTravel;
    private int totalDeliveryCount;
    private String staffID;
    
    public DailyRecord(){
        
    }

    public DailyRecord(String recordID, String todayDate, String checkInTime, String checkOutTime, double totalDistanceTravel, int totalDeliveryCount, String staffID) {
        this.recordID = recordID;
        this.todayDate = todayDate;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.totalDistanceTravel = totalDistanceTravel;
        this.totalDeliveryCount = totalDeliveryCount;
        this.staffID = staffID;
    }

    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getTodayDate() {
        return todayDate;
    }

    public void setTodayDate(String todayDate) {
        this.todayDate = todayDate;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public double getTotalDistanceTravel() {
        return totalDistanceTravel;
    }

    public void setTotalDistanceTravel(double totalDistanceTravel) {
        this.totalDistanceTravel = totalDistanceTravel;
    }

    public int getTotalDeliveryCount() {
        return totalDeliveryCount;
    }

    public void setTotalDeliveryCount(int totalDeliveryCount) {
        this.totalDeliveryCount = totalDeliveryCount;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }
    
    
    
}
