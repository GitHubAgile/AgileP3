/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author AaronLee
 */
public class Order {

    private String orderID;
    private String orderDate;
    private String orderTime;
    private String orderStatus;
    private String custID;
    private String deliveryID;
    private int index;
    private int[] item ;

    public Order() {
    }

    public Order(String orderID, String orderDate, String orderTime, String orderStatus, String custID, String deliveryID, int index, int[] item) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.custID = custID;
        this.deliveryID = deliveryID;
        this.index = index;
        this.item = item;

    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {

        this.custID = custID;
    }

    public String getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(String deliveryID) {
        this.deliveryID = deliveryID;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int[] getItem() {
        return item;
    }

    public void setItem(int[] item) {
        this.item = item;
    }

}
