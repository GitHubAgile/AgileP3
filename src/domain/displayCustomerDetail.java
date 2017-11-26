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
public class displayCustomerDetail {
    private String CustID;
    private String CustName;
    private String CustAddress;
    private String CustPhone;
   
   
   
     public displayCustomerDetail(){}
    
    public displayCustomerDetail(String CustID, String CustName,String CustAddress,String CustPhone){
        this.CustID = CustID;
        this.CustName = CustName;
        this.CustAddress = CustAddress;
        this.CustPhone = CustPhone;
       
               

    }
      public String getCustID(){
        return CustID;
    }
    public void setCustID(String CustID){
        this.CustID = CustID;
    }
    
    public String getCustName(){
    return CustName;
    }
    public void setCustName(String CustName){
    this.CustName = CustName;
    }
   
    public String getCustAddress(){
        return CustAddress;
    }
    public void setCustAddress(String CustAddress){
        this.CustAddress = CustAddress;
    }
    
    public String getCustPhone(){
        return CustPhone;
    }
    public void setCustPhone(String CustPhone){
        this.CustPhone = CustPhone;
    }
}
