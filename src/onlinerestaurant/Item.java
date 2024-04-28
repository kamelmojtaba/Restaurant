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
public class Item {
    private int itemID;
    static int totalItems = 1;
    private String name;
    private String type;
    private double price;
  
    public Item(){};
    public Item(String name, String type, double price) {
        itemID = totalItems;
        totalItems++;
        this.name = name;
        this.type = type;
        this.price = price;
        
    }

    public void printItemDetails() {
        System.out.println("ItemID:" + itemID);
        System.out.println("Name:" + name);
        System.out.println("Type:" + type);
        System.out.println("Price:" + price + "SAR");
        

    }

    public void printItemDetails(boolean brief) {
        System.out.println("Name:" + name);
        System.out.println("Price:" + price + "SAR");
    }

    public int getItemID() {
        return itemID;
    }

 
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public static void setTotalItems(int totalItems) {
        Item.totalItems = totalItems;
    }

    public void setType(String type) {
        this.type = type;
    }

   

    public static int getTotalItems() {
        return totalItems;
    }

    public String getType() {
        return type;
    }

}
