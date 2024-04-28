/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyConnection;
import javax.swing.JOptionPane;
import onlinerestaurant.Users;
import java.sql.*;
import onlinerestaurant.Payments;
import onlinerestaurant.PayCash;
import onlinerestaurant.Admin;
import onlinerestaurant.Bill;
import onlinerestaurant.CustomerSighUp;
/**
 *
 * @author Hanas
 */
public class CustomerOperation {
     public static void save(CustomerSighUp cus)
    {
        String query="insert into CustomerSighup(First_Name, Last_Name, Email, city,Neighborhood,username,password) values('"+cus.getFname()+"','"+cus.getLname()+"','"+cus.getEmail()+"','"+cus.getCity()+"','"+cus.getNeighborhood()+"','"+cus.getUsername()+"','"+cus.getPassword()+"')";
        DBOperations.setDataOrDelete(query, " Customer Registered Successfully! ");
    }
    
    public static int login(String username,String password){
//        User user=null;
        try{
            ResultSet rs=DBOperations.getData("SELECT * FROM CustomerSighup WHERE username='"+username+"' AND password='"+password+"'");
            if(rs.next())
            {
               return 1;//exist
            }
           else
            {
            return 0;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        return -1;//Not connected to database
}
    
     public static int Adminlogin(String username,String password){
//        User user=null;
        try{
            ResultSet rs=DBOperations.getData("SELECT * FROM Admin WHERE AdminUsername='"+username+"' AND AdminPassword='"+password+"'");
            if(rs.next())
            {
               return 1;//exist
            }
           else
            {
            return 0;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        return -1;//Not connected to database
}
      public static void Adminsave(Admin admin)
    {
        String query="insert into Admin(AdminUsername,AdminPassword) values('"+admin.getUsername()+"','"+admin.getPassword()+"')";
        DBOperations.setDataOrDelete(query, " Admin Registered Successfully! ");
    }
      
     public static void Paymentsave(Payments payment,int orderID)
    {
        String query="insert into Payment(PaymentMethod,Card_Number,Name_On_Card,ccv,Total_Price,Payment_Date,Order_ID) values('"+payment.getPaymentType()+"','"+payment.getCardNumber()+"','"+payment.getCardName()+"',"+payment.getCcv()+","+payment.getAmountToBePaid()+",'"+payment.getPaymentDate()+"',"+orderID+")";
        DBOperations.setDataOrDelete(query, " payment done! ");
    }
     public static void PaymentCashsave(PayCash payCash,int orderID){
        String query="insert into Payment(PaymentMethod,Total_Price,Payment_Date,Order_ID) values('"+payCash.getPaymentType()+"',"+payCash.getAmountToBePaid()+",'"+payCash.getPaymentDate()+"',"+orderID+")";
        DBOperations.setDataOrDelete(query, " payment done! ");
    }
     public static void SaveBill(Bill bill,Date date) 
     {
         String query="insert into BILL (PAYMENTID,LOCATION,BILL_DATE,PAIDPRICE)values("+bill.getPaymentID()+",'"+bill.getLocation()+"','"+date+"',"+bill.getPrice()+")";
         DBOperations.setDataOrDelete(query, "Thank you for Ordering !");
     }
     
}
