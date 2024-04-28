/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinerestaurant;

import java.util.ArrayList;

/**
 *
 * @author Hanas
 */
public class Users  {
//      private double amountAvailable;
//      ArrayList<Orders> allOrders;
     private String username;
    private String password;

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
