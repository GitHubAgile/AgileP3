package domain;

public class Delivery {
    private String deliveryID;
    private String deliveryDate;
    private String deliveryTime;
    private String deliveryStatus;
    private String estimationTime;
    private int estimationDistance;
    private String staffID;

    public Delivery() {
    }

    public Delivery(String deliveryID, String deliveryDate, String deliveryTime, String deliveryStatus, String estimationTime, int estimationDistance, String staffID) {
        this.deliveryID = deliveryID;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.deliveryStatus = deliveryStatus;
        this.estimationTime = estimationTime;
        this.estimationDistance = estimationDistance;
        this.staffID = staffID;
    }

    public String getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(String deliveryID) {
        this.deliveryID = deliveryID;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getEstimationTime() {
        return estimationTime;
    }

    public void setEstimationTime(String estimationTime) {
        this.estimationTime = estimationTime;
    }

    public int getEstimationDistance() {
        return estimationDistance;
    }

    public void setEstimationDistance(int estimationDistance) {
        this.estimationDistance = estimationDistance;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    @Override
    public String toString() {
        return "Delivery{" + "deliveryID=" + deliveryID + ", deliveryDate=" + deliveryDate + ", deliveryTime=" + deliveryTime + ", deliveryStatus=" + deliveryStatus + ", estimationTime=" + estimationTime + ", estimationDistance=" + estimationDistance + ", staffID=" + staffID + '}';
    }

    
    
    
}
