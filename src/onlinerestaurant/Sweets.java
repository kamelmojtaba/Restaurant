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
public class Sweets extends Item{
      private double price;
      private String name;
     
  
    public Sweets(String name, double Price)
    {
        super(name,"Sweet",Price);
        this.price=Price;
        this.name=name;
       
    }
    public void printItemDetails()
    {
        super.printItemDetails();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
