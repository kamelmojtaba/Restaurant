/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

//import static MyConnection.MenuOperation.saveDrinks;
import MyConnection.Connectionprovider;
import static MyConnection.MenuOperation.FillComboBox;
import static MyConnection.MenuOperation.GetItem;
import static MyConnection.MenuOperation.ItemPrice;
import static MyConnection.MenuOperation.OrderCart;
import static MyConnection.MenuOperation.insertOrder;
import static MyConnection.MenuOperation.insertOrderItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import onlinerestaurant.Drinks;
import onlinerestaurant.MainDishes;
import onlinerestaurant.Sweets;
import onlinerestaurant.Item;
//import static MyConnection.MenuOperation.saveMainDish;
//import static MyConnection.MenuOperation.saveSweet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hanas
 */
public class JF_menu extends javax.swing.JFrame {
//     ArrayList<MainDishes> MainDish = new ArrayList<>();
//     ArrayList<Sweets> Sweet = new ArrayList<>();
//     ArrayList<Drinks> Drink = new ArrayList<>();
     int index;
     MainDishes Dish;
     Drinks drink;
     Sweets sweet;
     
     int DrinkQuantity;
     int MainQuantity;
     int SweetQuantity;
     double priceMain;
     double WholeMain;
     double priceDrink;
     double wholeDrink;
     double priceSweet;
     double wholeSweet;
     double total;
     String UserName;
      Connection connection;
      Statement st;
      ResultSet rs;
      int Orderid;
      double itemPrice;
      int itemID;
      double summation=0;
    double priceAndQuantity=0;
    /**
     * Creates new form JF_menu
     */
    public JF_menu() {
      
        initComponents();
        fillTable();
        createOrder();
        BestSeller();
//        addMainDish();
//        fullJcomboMainDish();
//        addDrinks();
//        fullJcomboDrinks();
//        addSweet();
//        fullJcomboSweet();
    }
    public JF_menu(String Username) {
        UserName=Username;
        initComponents();
        fillTable();
        createOrder();
        BestSeller();
//        addMainDish();
//        fullJcomboMainDish();
//         addDrinks();
//        fullJcomboDrinks();
//        addSweet();
//        fullJcomboSweet();
    }
    private void fillTable()
    {
       ResultSet result=FillComboBox();
         try {
             while(result.next())
             {
               String name=result.getString("NAME");
               String category=result.getString("CATEGORY");
               if(category.equals("MainDish"))
               {
                   jComboBoxmainDish.addItem(name);
               }
               else if(category.equals("Drink"))
                       {
                         jComboBoxDrinks.addItem(name);
                       }
               else
               {
                   jComboBoxSweet.addItem(name);
               }
             }
         } 
         catch (SQLException ex) {
             Logger.getLogger(JF_menu.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    private void createOrder(){
        java.util.Date date=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        insertOrder(UserName,sqlDate);
        
         try {
            Connection con=Connectionprovider.getCon();
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
             String getOrderId="Select ORDERID from Orders";
              rs=st.executeQuery(getOrderId);
              rs.last();
              Orderid=rs.getInt(1);//taking the id
         } catch (SQLException ex) {
             Logger.getLogger(JF_menu.class.getName()).log(Level.SEVERE, null, ex);
         }
             
    }
    private void BestSeller(){
     try {
            Connection con=Connectionprovider.getCon();
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=st.executeQuery("Select ITEM_ID from ORDERITEM group by ITEM_ID order by Count(ITEM_ID) Desc");
            rs.next();
            int itemid=rs.getInt(1);//returns the most used isbn
            
            rs=st.executeQuery("Select NAME from ITEMS where ITEMID="+itemid);
            rs.next();
            String ItemName=rs.getString(1);
            BestSeller.setText(ItemName);
            
        } catch (SQLException ex) {
            Logger.getLogger(JF_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//     private void addMainDish() 
//     {
//        MainDish.add(new MainDishes("Burger","Chicken",20));
//        MainDish.add(new MainDishes("Pizza","Beef",25));
//        MainDish.add(new MainDishes("Grilled Beef Steak","Steak",40));
//        MainDish.add(new MainDishes("Shawarma","Chicken",10));
// 
//     }
//     private void fullJcomboMainDish(){
//            
//            for(int i = 0; i < MainDish.size() ; i++){
//                jComboBoxmainDish.addItem(MainDish.get(i).getName());
//            } 
//           
//     }
//        //Coca-cola Sprite Pepsi
//       private void addDrinks() 
//     {
//       Drink.add(new Drinks("Coca_cola",2.5,"whithout ice"));
//        Drink.add(new Drinks("Sprite",2.5,"whithout ice"));
//        Drink.add(new Drinks("Pepsi",2.5,"whithout ice"));
//        Drink.add(new Drinks("Black Coffee",15,"whithout ice"));
//        Drink.add(new Drinks("Water",2,"whithout ice"));
//        Drink.add(new Drinks("Latte",20,"whithout ice"));
//     }
//      private void fullJcomboDrinks(){
//            for(int i = 0; i < Drink.size() ; i++){
//               jComboBoxDrinks.addItem(Drink.get(i).getName());
//            }
//      }    
//        private void addSweet() 
//     {
// 
//       Sweet.add(new Sweets("Chocolate Cake",20,"No fruit added"));
//       Sweet.add(new Sweets("Cheese Cake",25,"No fruit added"));
//       Sweet.add(new Sweets("Muffin",15,"No fruit added"));
//     }
//      private void fullJcomboSweet(){
//            for(int i = 0; i < Sweet.size() ; i++){
//               jComboBoxSweet.addItem(Sweet.get(i).getName());
//               
//            }
//      }
//       
       
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelMainDish = new javax.swing.JLabel();
        jLabelDrinks = new javax.swing.JLabel();
        jLabelSweet = new javax.swing.JLabel();
        jComboBoxmainDish = new javax.swing.JComboBox<>();
        jComboBoxDrinks = new javax.swing.JComboBox<>();
        jComboBoxSweet = new javax.swing.JComboBox<>();
        jLabelQuntityMAIN = new javax.swing.JLabel();
        jLabelQuntityDRINK = new javax.swing.JLabel();
        jLabelQuntitySweet = new javax.swing.JLabel();
        jSpinnercount1 = new javax.swing.JSpinner();
        jSpinnercount2 = new javax.swing.JSpinner();
        jSpinnercount3 = new javax.swing.JSpinner();
        jLabelMianPrice = new javax.swing.JLabel();
        jLabelDrinkPrice = new javax.swing.JLabel();
        jLabelSweetPrice = new javax.swing.JLabel();
        jButtonTotal = new javax.swing.JButton();
        jLabeltotal = new javax.swing.JLabel();
        jButtonBuy = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SaveMain = new javax.swing.JButton();
        SaveDrink = new javax.swing.JButton();
        SaveSweet = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        BestSeller = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Background.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(1100, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMainDish.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabelMainDish.setText("Main Dish");
        getContentPane().add(jLabelMainDish, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 105, -1));

        jLabelDrinks.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabelDrinks.setText("Drinks");
        getContentPane().add(jLabelDrinks, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 99, -1));

        jLabelSweet.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabelSweet.setText("Sweet");
        getContentPane().add(jLabelSweet, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, -1, -1));

        jComboBoxmainDish.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jComboBoxmainDish.setForeground(new java.awt.Color(102, 102, 102));
        jComboBoxmainDish.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxmainDishItemStateChanged(evt);
            }
        });
        jComboBoxmainDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxmainDishActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxmainDish, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 170, -1));

        jComboBoxDrinks.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jComboBoxDrinks.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDrinksItemStateChanged(evt);
            }
        });
        jComboBoxDrinks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDrinksActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxDrinks, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, 163, -1));

        jComboBoxSweet.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jComboBoxSweet.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSweetItemStateChanged(evt);
            }
        });
        jComboBoxSweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSweetActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxSweet, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 240, 160, -1));

        jLabelQuntityMAIN.setText("Quntity");
        getContentPane().add(jLabelQuntityMAIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 93, -1));

        jLabelQuntityDRINK.setText("Quntity");
        getContentPane().add(jLabelQuntityDRINK, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, -1, -1));

        jLabelQuntitySweet.setText("Quntity");
        getContentPane().add(jLabelQuntitySweet, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 300, -1, -1));

        jSpinnercount1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnercount1StateChanged(evt);
            }
        });
        getContentPane().add(jSpinnercount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 97, -1));

        jSpinnercount2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnercount2StateChanged(evt);
            }
        });
        getContentPane().add(jSpinnercount2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 300, 90, -1));

        jSpinnercount3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnercount3StateChanged(evt);
            }
        });
        getContentPane().add(jSpinnercount3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 300, 98, -1));

        jLabelMianPrice.setText("0");
        getContentPane().add(jLabelMianPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 50, -1));

        jLabelDrinkPrice.setText("0");
        getContentPane().add(jLabelDrinkPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, 60, 20));

        jLabelSweetPrice.setText("0");
        getContentPane().add(jLabelSweetPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 360, 30, -1));

        jButtonTotal.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButtonTotal.setText("Total");
        jButtonTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTotalActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 510, 93, -1));

        jLabeltotal.setText("0");
        getContentPane().add(jLabeltotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 510, -1, -1));

        jButtonBuy.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButtonBuy.setText("View Cart");
        jButtonBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuyActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 570, 150, -1));

        jLabel1.setText("price");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, -1));

        jLabel2.setText("Price");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(182, 144, 106));
        jLabel6.setText("Welcome to our restaurnat menu: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 700, -1));

        jLabel3.setText("price");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 360, -1, -1));

        SaveMain.setText("Save");
        SaveMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveMainActionPerformed(evt);
            }
        });
        getContentPane().add(SaveMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, -1, -1));

        SaveDrink.setText("save");
        SaveDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveDrinkActionPerformed(evt);
            }
        });
        getContentPane().add(SaveDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, -1, -1));

        SaveSweet.setText("save");
        SaveSweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveSweetActionPerformed(evt);
            }
        });
        getContentPane().add(SaveSweet, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 410, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/MenuImage.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-320, 100, 640, 600));

        jPanel1.setBackground(new java.awt.Color(231, 198, 164));
        jPanel1.setForeground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 710, 350));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(182, 144, 106));
        jLabel9.setText("Our Current Best Seller Item : ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        BestSeller.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        BestSeller.setForeground(new java.awt.Color(182, 144, 106));
        BestSeller.setText("jLabel10");
        getContentPane().add(BestSeller, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 140, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/White.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1790, 880));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxSweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSweetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSweetActionPerformed

    private void SaveMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveMainActionPerformed
        // TODO add your handling code here:
//        saveMainDish(Dish,MainQuantity,WholeMain,UserName);
          insertOrderItem(Orderid,itemID,MainQuantity);
          jLabelMianPrice.setText("0");
    }//GEN-LAST:event_SaveMainActionPerformed

    private void jSpinnercount1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnercount1StateChanged
//         TODO add your handling code here:
          index=jComboBoxmainDish.getSelectedIndex();
          String MaidishName=jComboBoxmainDish.getItemAt(index);
          MainQuantity= (Integer)jSpinnercount1.getValue();
         
          rs=GetItem(MaidishName);
         
         try {
             rs.next();
              itemID=rs.getInt(1);
              itemPrice=rs.getDouble(2);
             
         } catch (SQLException ex) {
             Logger.getLogger(JF_menu.class.getName()).log(Level.SEVERE, null, ex);
         }
            //priceMain=MainDish.get(index).getPrice();
         
         MainDishes maindish=new MainDishes(MaidishName,itemPrice);
        if(MainQuantity<=1){
            jSpinnercount1.setValue(1);
             MainQuantity=1;
             WholeMain=itemPrice;
        }
        else{
            WholeMain=MainQuantity*itemPrice;
        }
            jLabelMianPrice.setText(WholeMain+""); 
       
    }//GEN-LAST:event_jSpinnercount1StateChanged
    
    private void jSpinnercount2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnercount2StateChanged
        // TODO add your handling code here:
        index=jComboBoxDrinks.getSelectedIndex();
          String DrinkName=jComboBoxDrinks.getItemAt(index);
          DrinkQuantity= (Integer)jSpinnercount2.getValue();
         
          rs=GetItem(DrinkName);
         
         try {
             rs.next();
              itemID=rs.getInt(1);
              itemPrice=rs.getDouble(2);
             
         } catch (SQLException ex) {
             Logger.getLogger(JF_menu.class.getName()).log(Level.SEVERE, null, ex);
         }
            //priceMain=MainDish.get(index).getPrice();
         
         Drinks drink=new Drinks(DrinkName,itemPrice);
        if(DrinkQuantity<=1){
            jSpinnercount2.setValue(1);
             DrinkQuantity=1;
             wholeDrink=itemPrice;
        }
        else{
            wholeDrink=DrinkQuantity*itemPrice;
        }
            jLabelDrinkPrice.setText(wholeDrink+""); 
       
        
        
    }//GEN-LAST:event_jSpinnercount2StateChanged

    private void SaveDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveDrinkActionPerformed
        // TODO add your handling code here:
//        saveDrinks(drink,DrinkQuantity,wholeDrink,UserName);
         insertOrderItem(Orderid,itemID,DrinkQuantity);
         jLabelDrinkPrice.setText("0");


    }//GEN-LAST:event_SaveDrinkActionPerformed

    private void SaveSweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveSweetActionPerformed
        // TODO add your handling code here:
//        saveSweet(sweet, SweetQuantity,wholeSweet,UserName);

          insertOrderItem(Orderid,itemID,SweetQuantity);
          jLabelSweetPrice.setText("0");
    }//GEN-LAST:event_SaveSweetActionPerformed

    private void jSpinnercount3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnercount3StateChanged

          index=jComboBoxSweet.getSelectedIndex();
          String SweetName=jComboBoxSweet.getItemAt(index);
          SweetQuantity= (Integer)jSpinnercount3.getValue();
         
          rs=GetItem(SweetName);
         
         try {
             rs.next();
              itemID=rs.getInt(1);
              itemPrice=rs.getDouble(2);
             
         } catch (SQLException ex) {
             Logger.getLogger(JF_menu.class.getName()).log(Level.SEVERE, null, ex);
         }
            //priceMain=MainDish.get(index).getPrice();
         
         Sweets sweet=new Sweets(SweetName,itemPrice);
        if(SweetQuantity<=1){
            jSpinnercount3.setValue(1);
             SweetQuantity=1;
             wholeSweet=itemPrice;
        }
        else{
            wholeSweet=SweetQuantity*itemPrice;
        }
            jLabelSweetPrice.setText(wholeSweet+""); 
       
        
    }//GEN-LAST:event_jSpinnercount3StateChanged

    private void jButtonTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTotalActionPerformed
        // TODO add your handling code here:
        
        ResultSet resultS=OrderCart(Orderid);
         try {
             while(resultS.next())
             {
               int ItemNumber=resultS.getInt(1);
               int quantity=resultS.getInt(2);
               ResultSet resultS2=ItemPrice(ItemNumber);
               resultS2.next();
                double ItemPrice=resultS2.getDouble(1);
                priceAndQuantity=ItemPrice*quantity;
                summation+=priceAndQuantity;
             }
              String summ=String.valueOf(summation);
             jLabeltotal.setText(summ);
         }
         catch (SQLException ex) {
             Logger.getLogger(JF_menu.class.getName()).log(Level.SEVERE, null, ex);
         }
//        total=wholeSweet+wholeDrink+WholeMain;
//        jLabeltotal.setText(total+"");
         Connection con=Connectionprovider.getCon();
         Statement st;
         try {
             st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
              String TotalPrice="UPDATE Orders SET TotalPrice="+summation+" Where ORDERID="+Orderid;
              st.executeUpdate(TotalPrice);
         } catch (SQLException ex) {
             Logger.getLogger(JF_menu.class.getName()).log(Level.SEVERE, null, ex);
         }
            
    }//GEN-LAST:event_jButtonTotalActionPerformed

    private void jComboBoxmainDishItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxmainDishItemStateChanged
        // TODO add your handling code here:
        int i=jComboBoxmainDish.getSelectedIndex();
         jSpinnercount1.setValue(0);
//        Dish=MainDish.get(i);
//       
    }//GEN-LAST:event_jComboBoxmainDishItemStateChanged

    private void jComboBoxDrinksItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDrinksItemStateChanged
        // TODO add your handling code here:
         int i=jComboBoxDrinks.getSelectedIndex();
          jSpinnercount2.setValue(0);
//        drink=Drink.get(i);
        
    }//GEN-LAST:event_jComboBoxDrinksItemStateChanged

    private void jComboBoxDrinksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDrinksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDrinksActionPerformed

    private void jComboBoxSweetItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSweetItemStateChanged
        // TODO add your handling code here:
         int i=jComboBoxSweet.getSelectedIndex();
         jSpinnercount3.setValue(0);
//        sweet=Sweet.get(i);
        
    }//GEN-LAST:event_jComboBoxSweetItemStateChanged

    private void jButtonBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuyActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new JF_Cart(Orderid).setVisible(true);
    }//GEN-LAST:event_jButtonBuyActionPerformed

    private void jComboBoxmainDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxmainDishActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxmainDishActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BestSeller;
    private javax.swing.JButton SaveDrink;
    private javax.swing.JButton SaveMain;
    private javax.swing.JButton SaveSweet;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButtonBuy;
    private javax.swing.JButton jButtonTotal;
    private javax.swing.JComboBox<String> jComboBoxDrinks;
    private javax.swing.JComboBox<String> jComboBoxSweet;
    private javax.swing.JComboBox<String> jComboBoxmainDish;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDrinkPrice;
    private javax.swing.JLabel jLabelDrinks;
    private javax.swing.JLabel jLabelMainDish;
    private javax.swing.JLabel jLabelMianPrice;
    private javax.swing.JLabel jLabelQuntityDRINK;
    private javax.swing.JLabel jLabelQuntityMAIN;
    private javax.swing.JLabel jLabelQuntitySweet;
    private javax.swing.JLabel jLabelSweet;
    private javax.swing.JLabel jLabelSweetPrice;
    private javax.swing.JLabel jLabeltotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinnercount1;
    private javax.swing.JSpinner jSpinnercount2;
    private javax.swing.JSpinner jSpinnercount3;
    // End of variables declaration//GEN-END:variables
}
