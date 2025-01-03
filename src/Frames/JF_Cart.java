/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import static MyConnection.MenuOperation.CheckCart;
import static MyConnection.MenuOperation.FillCart;
import static MyConnection.MenuOperation.ItemPrice;
import static MyConnection.MenuOperation.OrderCart;
import static MyConnection.MenuOperation.UpdatePrice;
import static MyConnection.MenuOperation.deleteOrder;
import static MyConnection.MenuOperation.getItemID;
import static MyConnection.MenuOperation.getPrice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hanas
 */
public class JF_Cart extends javax.swing.JFrame {
    Connection conn;
    Statement st;
    ResultSet rs;
    ResultSet result;
    int orderID;
    int ITEMID;
    double sum=0;
    double priceAndQua=0;
    /**
     * Creates new form JF_Cart
     */
    public JF_Cart() {
        initComponents();
//        FillCartTable();
    }
    public JF_Cart(int orderid)
    {
        orderID=orderid;
        initComponents();
        FillCartTable();
      
    }
    private void FillCartTable(){
        DefaultTableModel Tablemodel=(DefaultTableModel) jTable1.getModel();
          result=FillCart(orderID);
        try {
            while(result.next())
            {
                int itemID=result.getInt(2);
                int quantity=result.getInt(3);
                String Quantity=String.valueOf(quantity);
                String itemName=getItemName(itemID);
                String []row={itemName,Quantity};
                Tablemodel.addRow(row);
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(JF_Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String getItemName(int itemID)
    {
        String ItemName="";
        try {
            conn=DriverManager.getConnection("jdbc:derby://localhost:1527/OnlineRestaurant","groupone","groupone");
            st=conn.createStatement();
            rs=st.executeQuery("select NAME from ITEMS where ITEMID="+itemID);
            rs.next();
            ItemName=rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(JF_Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ItemName;
    }
    
     private void ClearTable(){
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        UpdatedTotal = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(970, 770));
        setResizable(false);
        setSize(new java.awt.Dimension(970, 770));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setText("Cart");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 92, 72));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel2.setText("Delete Any Unwanted Item");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, -1, -1));

        jTable1.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 380, 290));

        jButton1.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, -1, -1));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("Updated Total");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 540, -1, -1));

        UpdatedTotal.setText("\"\"");
        getContentPane().add(UpdatedTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 540, -1, -1));

        jButton3.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jButton3.setText("Next");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 670, 80, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Cart.jpeg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 160, 740, 520));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/White.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -30, 1000, 780));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
        int answer=JOptionPane.showConfirmDialog(null, "Are you sure yout want to delete this Item?","Delete An Item",JOptionPane.YES_NO_OPTION);
        if(answer==JOptionPane.YES_OPTION)
        {
           String sql="Delete from ORDERITEM where ITEM_ID="+ITEMID;
            int rows=st.executeUpdate(sql);
            if(rows==1)
            {
              JOptionPane.showMessageDialog(null, "Deleted...");
            }
            ClearTable();
            FillCartTable();
        }
        }
        catch(SQLException s)
        {
            JOptionPane.showMessageDialog(null, s.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try{
            int row=jTable1.getSelectedRow();
            String Item=jTable1.getModel().getValueAt(row,0).toString();
            ResultSet Result=getItemID(Item);
            try {
                Result.next();
                ITEMID=Result.getInt(1);
            } catch (SQLException ex) {
                Logger.getLogger(JF_Cart.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            sum=0;
            ResultSet rss=OrderCart(orderID);
            while(rss.next())
            {
                int ITID=rss.getInt(1);
                int qua=rss.getInt(2);
                ResultSet rss2=ItemPrice(ITID);
                rss2.next();
                double ItemPrice=rss2.getDouble(1);
                priceAndQua=ItemPrice*qua;
                sum+=priceAndQua;
            }
            String summ=String.valueOf(sum);
            UpdatedTotal.setText(summ);
            UpdatePrice(orderID,sum);
        } catch (SQLException ex) {
            Logger.getLogger(JF_Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        double totalPrice=0.0;
        boolean check=CheckCart(orderID);
        if(check==false)
        {
            JOptionPane.showMessageDialog(null, "Your Cart Is Empty! Thank you for visiting.");
            deleteOrder(orderID);
            System.exit(0);
        }
        else
        {
        try {
            // TODO add your handling code here:
            ResultSet rs=getPrice(orderID);
            rs.next();
             totalPrice=rs.getDouble(1);
        } catch (SQLException ex) {
            Logger.getLogger(JF_Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(false);
        new JF_Payments(orderID,totalPrice).setVisible(true);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(JF_Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Cart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UpdatedTotal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
