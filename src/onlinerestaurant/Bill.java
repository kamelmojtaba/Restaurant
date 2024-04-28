/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinerestaurant;

/**
 *
 * @author Hanas
 */
public class Bill {
    
    int PaymentID;
    String location;
    Double Price;

    public Bill( int PaymentID, String location, Double Price) {
        
        this.PaymentID = PaymentID;
        this.location = location;
        this.Price = Price;
    } 

   

    public int getPaymentID() {
        return PaymentID;
    }

    public void setPaymentID(int PaymentID) {
        this.PaymentID = PaymentID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }
   
    
}
