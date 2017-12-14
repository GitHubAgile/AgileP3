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
public class Menu {

    private String itemID;
    private byte[] image;
    private String itemName;
    private String description;
    private String price;
    private String restID;

    public Menu() {
    }

    public Menu(String itemID, byte[] image, String itemName, String description, String price, String restID) {
        this.itemID = itemID;
        this.image = image;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.restID = restID;

    }

    public String getItemID() {
        return itemID;
    }

    public void setitemID(String itemID) {
        this.itemID = itemID;
    }

    public byte[] getimage() {
        return image;
    }

    public void setOrderDate(byte[] image) {
        this.image = image;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {

        this.price = price;
    }

    public String getRestID() {
        return restID;
    }

    public void setRestID(String restID) {
        this.restID = restID;
    }

}
