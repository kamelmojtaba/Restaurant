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
public class Drinks extends Item{
     
      private String name;
      private double price;

    public Drinks(String name,double price)
    {
       super(name,"Drink",price);
       this.name=name;
       this.price=price;
    
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

}
