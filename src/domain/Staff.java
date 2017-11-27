package domain;

public class Staff {
    private String staffID;
    private String staffPw;
    private String staffName;
    private String staffPhone;
    private String staffEmail;
    private String position;
    private String status;
 
    
    public Staff(){
    
    }

    public Staff(String staffID, String staffPw, String staffName, String staffPhone, String staffEmail, String position, String status) {
        this.staffID = staffID;
        this.staffPw = staffPw;
        this.staffName = staffName;
        this.staffPhone = staffPhone;
        this.staffEmail = staffEmail;
        this.position = position;
        this.status = status;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getStaffPw() {
        return staffPw;
    }

    public void setStaffPw(String staffPw) {
        this.staffPw = staffPw;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    

}