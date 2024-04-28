/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import MyConnection.Connectionprovider;
import static MyConnection.CustomerOperation.SaveBill;
import static MyConnection.MenuOperation.Customerlocation;
import static MyConnection.MenuOperation.GetPayment;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import onlinerestaurant.Bill;

/**
 *
 * @author Hanas
 */
public class JF_Bill extends javax.swing.JFrame {
     private static Formatter output;
    private static Scanner input;
    final String DATABASE_URL = "jdbc:derby://localhost:1527/OnlineRestaurant";
    
    
    Connection con;
    int paymentID;
    int BillID;
    double PaidPrice;
    String city;
    String nh;
    java.sql.Date sqlDate;
    int Orderid;
    /**
     * Creates new form JF_Bill
     */
    public JF_Bill() {
        initComponents();
    }
    public JF_Bill(int orderid) {
        initComponents();
        Orderid=orderid;
         getDate();
         getPayment();
         Getlocation();
         createBill();
         getBillID();
         OpenText();
         FillText();
         closeFile();
    }
    public void getPayment(){
        try {
            Connection con=Connectionprovider.getCon();
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query="Select PAYMENT_ID,TOTAL_PRICE from PAYMENT";
            ResultSet rs=st.executeQuery(query);
            rs.last();
             paymentID=rs.getInt(1);
             PaidPrice=rs.getDouble(2);
             Payment.setText(paymentID+"");
             paidPrice.setText(PaidPrice+"");
             
        } catch (SQLException ex) {
            Logger.getLogger(JF_Bill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getDate(){
        java.util.Date date=new java.util.Date();
        sqlDate=new java.sql.Date(date.getTime());
        DateLabel.setText(sqlDate.toString());
    }
    
    public void Getlocation(){
        Connection con=Connectionprovider.getCon();
        try {
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query="Select CITY,NEIGHBORHOOD from CUSTOMERSIGHUP where USERNAME IN(Select CUSTOMERUSERNAME from ORDERS WHERE ORDERID IN(Select ORDER_ID from PAYMENT WHERE PAYMENT_ID="+paymentID+" ) )";
            ResultSet rs=st.executeQuery(query);
            rs.next();
            city=rs.getString(1);
            nh=rs.getString(2);
            Location.setText(city+" - "+nh);
        } catch (SQLException ex) {
            Logger.getLogger(JF_Bill.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void createBill(){
        String location=city+"-"+nh;
        Bill bill=new Bill(paymentID,location,PaidPrice);
        SaveBill(bill,sqlDate);
    }
    public void getBillID(){
        
        try {
            Connection con=Connectionprovider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query="Select BILLID from BILL";
            ResultSet rs=st.executeQuery(query);
            rs.last();
             BillID=rs.getInt(1);
             BIll.setText(BillID+"");
        } catch (SQLException ex) {
            Logger.getLogger(JF_Bill.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
     public void OpenText()
    {
        
            try {
                output=new Formatter("OrderDetails.txt");
            } 
            catch (FileNotFoundException ex) {
                System.out.println("Could not find& create!");
	        System.exit(1);
            }
              catch(SecurityException se)
                {
		System.out.println("NO permission to write!");
                System.exit(1);
		}
    }
     
       public void FillText()
    {
         String query="SELECT * from ORDERITEM ";
        try {
             con=DriverManager.getConnection(DATABASE_URL,"groupone","groupone");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
               while(rs.next())
               {
                   try{
                       int orderID=rs.getInt(1);
                       int itemID=rs.getInt(2);
                       int quantity=rs.getInt(3);
                        String name=getname(itemID);
                              
                       output.format("%d/%s/%d%n", orderID,name,quantity);
                   }
                   catch(FormatterClosedException f){
                       JOptionPane.showMessageDialog(this, "Formatter closed","error",JOptionPane.CLOSED_OPTION);
                       break;
                   }
                    catch(NoSuchElementException nsa)
			{
			JOptionPane.showMessageDialog(this, "No such element ","error",JOptionPane.CLOSED_OPTION);
			}
               }
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error DB","error",JOptionPane.CLOSED_OPTION);
            
        }
        
    }
        public String getname(int itemID){
        String namee="";
        try {
            con = DriverManager.getConnection(DATABASE_URL,"groupone","groupone");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("Select NAME FROM ITEMS WHERE ITEMID ="+itemID);
            rs.next();
             namee=rs.getString(1);
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(this, "Error !! cannot find item name ","error",JOptionPane.CLOSED_OPTION);
        }
       return namee;
   }
        
     public static void closeFile(){
	if(output!=null)//if file was opened
	output.close();
     
     }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Location = new javax.swing.JLabel();
        Payment = new javax.swing.JLabel();
        BIll = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        paidPrice = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(860, 740));
        setSize(new java.awt.Dimension(860, 740));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(231, 231, 231));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, null, null, null, new java.awt.Font("Times New Roman", 2, 24))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 204, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Bill ID");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Payment ID");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Date");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Paid Price");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Location");

        Location.setText("jLabel6");

        Payment.setText("jLabel7");

        BIll.setText("jLabel8");

        DateLabel.setText("jLabel9");

        paidPrice.setText("jLabel10");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(18, 104, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BIll, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Payment, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Location, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DateLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(paidPrice, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BIll)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Payment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Location))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(DateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(paidPrice))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(400, 50, 410, 250);

        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton1.setText("View Order Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(500, 320, 180, 30);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "order ID", "Item Name", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(410, 380, 400, 290);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/bill2.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(-190, 20, 620, 670);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/White.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 860, 710);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        C:\Users\Hanas\OneDrive\Desktop\OnlineRestaurant
String path="C:\\Users\\Hanas\\OneDrive\\Desktop\\OnlineRestaurant\\OrderDetails.txt";

        try {
            BufferedReader br=new BufferedReader(new FileReader(path));
            Object [] tableLine=br.lines().toArray();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            for(int i=0;i<tableLine.length;i++)
            {
                String line=tableLine[i].toString().trim();
                String [] dataRow = line.split("/");
//                for(int j=0;j<dataRow.length;j++)
//                {
                    int id=Integer.parseInt(dataRow[0]);
                    if(id==Orderid)
                    {
                     model.addRow(dataRow);
                    }
//                }
            }
        } catch (FileNotFoundException ex) {
             JOptionPane.showMessageDialog(this, "Error Importing data","error",JOptionPane.CLOSED_OPTION);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(JF_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BIll;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JLabel Location;
    private javax.swing.JLabel Payment;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel paidPrice;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
