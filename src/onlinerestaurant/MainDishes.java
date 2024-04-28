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
public class MainDishes extends Item{
    private String Name;
    private double Price;

   public MainDishes(String Name, double Price ){
   
       super(Name ,"MainDish", Price);
       this.Name=Name;
       this.Price=Price;
   }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

}
