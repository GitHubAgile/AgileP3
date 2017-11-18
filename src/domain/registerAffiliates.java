/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.Blob;

/**
 *
 * @author AaronLee
 */
public class registerAffiliates {
    private String restaurantId;
    private String companyName;
    private String restaurantType;
    private String address;
    private String contactNo;
    private String ownerName;
    private String ownerContactNo;
   private String image;
   
   
     public registerAffiliates(){}
    
    public registerAffiliates(String restaurantId, String companyName,String restaurantType,String image,String address,String contactNo){
        this.restaurantId = restaurantId;
        this.companyName = companyName;
        this.restaurantType = restaurantType;
        this.image = image;
        this.address = address;
        this.contactNo = contactNo;
               

    }
      public String getRestaurantId(){
        return restaurantId;
    }
    public void setRestaurantId(String restaurantId){
        this.restaurantId = restaurantId;
    }
    
    public String getCompanyName(){
    return companyName;
    }
    public void setCompanyName(String companyName){
    this.companyName = companyName;
    }
   
    public String getRestaurantType(){
        return restaurantType;
    }
    public void setRestaurantType(String restaurantType){
        this.restaurantType = restaurantType;
    }
    
    public String getContactNo(){
        return contactNo;
    }
    public void setContactNo(String contactNo){
        this.contactNo = contactNo;
    }
   public String getAddress(){
       return address;
       
   }
   public void setAddress(String address){
       this.address = address;
   }
    
   public String getOwnerName(){
       return ownerName;
   }
   public void setOwnerName(String ownerName){
       this.ownerName = ownerName;
   }
   public String getOwnerContactNo(){
       return ownerContactNo;
       
   }
   public void setOwnerContactNo(String ownerContactNo){
       this.ownerContactNo = ownerContactNo;
   }
    public void setImage (String image){
        this.image = image;
    } 
    public String getImage(){
        return image;
    }
    
    
}
