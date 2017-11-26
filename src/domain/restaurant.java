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
public class restaurant {
private String restaurantID;
    private String companyName;
    private String restaurantType;
    private String contactNo;
    private byte[] image;

    public restaurant() {
    }

    public restaurant(String restaurantID ,String companyName, String restaurantType, byte[] image, String contactNo) {
this.restaurantID = restaurantID;
        this.companyName = companyName;
        this.restaurantType = restaurantType;
        this.image = image;

        this.contactNo = contactNo;

    }
 public String getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(String restaurantType) {
        this.restaurantType = restaurantType;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

}
