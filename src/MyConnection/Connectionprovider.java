/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyConnection;

import java.sql.*;

/**
 *
 * @author Hanas
 */
public class Connectionprovider {
    
      public static Connection getCon(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/online [groupone on GROUPONE]","groupone","groupone");
            return con;
        }
        catch(Exception e){
            return null;
        }
    }
}
