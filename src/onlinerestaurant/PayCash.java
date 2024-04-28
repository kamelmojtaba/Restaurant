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
public class PayCash extends Payments {
     public PayCash(double amountToBePaid,String paymentDate)
    {
        super("Cash",amountToBePaid,paymentDate);
    }
    public PayCash(double amountToBePaid)
    {
        super("Cash",amountToBePaid);
    }

    public double calculateBill()
    {
        return(amountToBePaid);
    }
}
