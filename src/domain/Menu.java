package domain;

public class Menu {
    private String itemID;
    private String image;
    private String itemName;
    private String description;
    private double price;
    private String restID;

    public Menu() {
    }

    public Menu(String itemID, String image, String itemName, String description, double price, String restID) {
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

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRestID() {
        return restID;
    }

    public void setRestID(String restID) {
        this.restID = restID;
    }

    @Override
    public String toString() {
        return "Menu{" + "itemID=" + itemID + ", image=" + image + ", itemName=" + itemName + ", description=" + description + ", price=" + price + ", restID=" + restID + '}';
    }
    
    
    
}
