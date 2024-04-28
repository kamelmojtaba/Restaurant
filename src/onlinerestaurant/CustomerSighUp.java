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
public class CustomerSighUp extends Users {
     int userID;
    static int totalUsers =1;
    private String Fname;
    private String Lname;
    private String email;
    private String password;
    private String city;
    private String Neighborhood;
    private String username;
    

    public CustomerSighUp(String Fname,String Lname,String email,String city, String Neighborhood,String username,String password)
    {
       userID = totalUsers;
        totalUsers++;

        this.Fname = Fname;
        this.Lname=Lname;
        this.email = email;
        this.city=city;
        this.Neighborhood=Neighborhood;
        this.username=username;
        this.password = password;
        
    }

    void printUserDetails()
    {
        System.out.println("Name:"+Fname);
        System.out.println("Email:"+email);
    }

    public String getPassword()
    {
        return password;
    }
    public String getEmail()
    {
        return email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public static int getTotalUsers() {
        return totalUsers;
    }

    public static void setTotalUsers(int totalUsers) {
        CustomerSighUp.totalUsers = totalUsers;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return Neighborhood;
    }

    public void setNeighborhood(String Neighborhood) {
        this.Neighborhood = Neighborhood;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
    
}
