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
public class Payments {
     double amountToBePaid;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    String paymentType,cardNumber,cardName, paymentDate;
    int ccv;
   // private String pay_date;

    public Payments(String paymentType,String cardNumber, String cardName,int ccv,String paymentDate,double amountToBePaid)
    {
        this.paymentType = paymentType;
        this.amountToBePaid = amountToBePaid;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.paymentDate = paymentDate;
        this.ccv = ccv;

    }
    public Payments(String paymentType, double amountToBePaid)
    {
        this.paymentType = paymentType;
        this.amountToBePaid = amountToBePaid;
        
    }
 public Payments(String paymentType,double amountToBePaid, String paymentDate)
    {
        this.paymentType = paymentType;
        this.amountToBePaid = amountToBePaid;
         this.paymentDate = paymentDate;

        
    }
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }
    
     public boolean voidCheckValidDate(){
        return true;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
     
    
     
     public void setAmountToBePaid(double amountToBePaid) {
        this.amountToBePaid = amountToBePaid;
    }
      public double getAmountToBePaid() {
        return amountToBePaid;
    }

      public void setPaymentType(String paymentType) {
       this.paymentType = paymentType;
    }
      public String getPaymentType() {
        return paymentType;
    }

    public double calculateBill()
    {
        return 0;
    }
}
