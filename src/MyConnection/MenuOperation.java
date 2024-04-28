/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyConnection;

import static MyConnection.DBOperations.setDataOrDelete;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import onlinerestaurant.Drinks;
import onlinerestaurant.MainDishes;
import onlinerestaurant.Sweets;

/**
 *
 * @author Hanas
 */
public class MenuOperation {
//   
     public static ResultSet FillComboBox()
     {
        String query="select NAME,CATEGORY from Items";
        ResultSet rs=DBOperations.getData(query);
        return rs;
     }
     public static void insertOrder(String username,Date date)
     {
         String query="Insert into Orders (CustomerUserName, Orderdate) Values ('"+username+"','"+date+"')";
         DBOperations.setDataOrDelete(query,"");
     }
      public static void insertOrderItem(int orderid,int itemid,int quantity)
     {
         String query="Insert into OrderItem (Order_ID,Item_ID,Quantity) Values ("+orderid+","+itemid+","+quantity+")";
         DBOperations.setDataOrDelete(query,"Item Added Successfully!");
     }
     public static ResultSet GetItem(String ItemName)
     {
         String query="Select ItemID,PRICE from Items where NAME='"+ItemName+"'";
         ResultSet rs=DBOperations.getData(query);
         
         return rs;
     }
     
     public static ResultSet FillCart(int orderID)
     {
        String query="select * from ORDERITEM where ORDER_ID="+orderID;
        ResultSet rs=DBOperations.getData(query);
        return rs; 
     }
     public static ResultSet getItemID(String Itemname)
     {
         String query="Select ITEMID from ITEMS where NAME='"+Itemname+"'";
         ResultSet rs=DBOperations.getData(query);
         return rs;
     }
     
     public static ResultSet OrderCart(int orderNum)
     {
         String query="Select ITEM_ID,QUANTITY from ORDERITEM where ORDER_ID="+orderNum;
         ResultSet rs=DBOperations.getData(query);
         return rs;
     }
     
     public static ResultSet ItemPrice(int itemNum)
     {
         String query="Select PRICE from ITEMS where ITEMID="+itemNum;
         ResultSet rs=DBOperations.getData(query);
         return rs;
     }
    public static void UpdatePrice(int orderNum,double total)
    {
        String query="UPDATE Orders SET TotalPrice="+total+" Where ORDERID="+orderNum;
        setDataOrDelete(query,"");
    }
    public static ResultSet getPrice(int orderid)
    {
        String query="Select TotalPrice from Orders where ORDERID="+orderid;
        ResultSet rs=DBOperations.getData(query);
         return rs;
    }
    public static ResultSet GetPayment()
    {
        String query="Select PAYMENT_ID,TOTAL_PRICE from PAYMENT";
        ResultSet rs=DBOperations.getData(query);
         return rs;
    }
     public static ResultSet Customerlocation(int paymentid)
 {        String query="Select CITY,NEIGHBORHOOD from CUSTOMERSIGHUP where USERNAME IN(CUSTOMERUSERNAME from ORDERS WHERE ORDERID IN(ORDER_ID from PAYMENT WHERE PAYMENT_ID="+paymentid+" ) ); ";
 
        ResultSet rs=DBOperations.getData(query);
         return rs;
    }
     public static boolean CheckCart(int orderID)
    {        
        String query="Select * from ORDERITEM where ORDER_ID="+orderID;
        ResultSet rs=DBOperations.getData(query);
         try {
             if(rs.next())
             {
               return true;
             }
         }
             catch (SQLException ex) {
             Logger.getLogger(MenuOperation.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
    }
    public static void deleteOrder(int orderID)
    {
        String query="Delete from ORDERS where ORDERID="+orderID;
        DBOperations.setDataOrDelete(query,"");
    }
}
