/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import static MyConnection.CustomerOperation.Adminlogin;
import static MyConnection.CustomerOperation.Adminsave;
import static MyConnection.CustomerOperation.login;
import javax.swing.JOptionPane;
import onlinerestaurant.Admin;

/**
 *
 * @author Hanas
 */
public class JF_Login extends javax.swing.JFrame {

    /**
     * Creates new form JF_Login
     */
    public JF_Login() {
        initComponents();
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
        jLabel3 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        LogIn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        SighUp = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1020, 625));
        setSize(new java.awt.Dimension(1020, 625));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setText("Welcome Back!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 80, 270, 90);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Username: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(480, 300, 120, 29);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Password: ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(480, 350, 120, 29);

        jTextFieldUsername.setText(" ");
        jTextFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsernameActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUsername);
        jTextFieldUsername.setBounds(610, 300, 147, 22);

        jPasswordFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordFieldPassword);
        jPasswordFieldPassword.setBounds(610, 350, 147, 22);

        LogIn.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        LogIn.setText("Log in");
        LogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInActionPerformed(evt);
            }
        });
        getContentPane().add(LogIn);
        LogIn.setBounds(620, 400, 110, 36);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setText("You Don't Have An Account? ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 210, 330, 30);

        SighUp.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        SighUp.setText("Sign Up");
        SighUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SighUpActionPerformed(evt);
            }
        });
        getContentPane().add(SighUp);
        SighUp.setBounds(110, 310, 150, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/user1.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(840, 450, 170, 120);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel7.setText("Log In");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(620, 20, 130, 60);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Logo.jpg"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(530, 30, 370, 340);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/White.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(380, 0, 620, 570);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel9.setText("Sign Up Here");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(110, 240, 170, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ba.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 380, 570);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsernameActionPerformed

    private void jPasswordFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldPasswordActionPerformed

    private void LogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInActionPerformed
        // TODO add your handling code here:
        
        String username= jTextFieldUsername.getText();
        String password=jPasswordFieldPassword.getText();
        //determine if it is a cutsomer or admin
        if(password.contains("admin"))
        {
            int a=Adminlogin(username,password);
            if(a==0)//admin does not exits
            {
                Admin admin=new Admin(username,password);
                Adminsave(admin);
            }
            
             setVisible(false);
             new JF_Modifyitem(username).setVisible(true);
           
        }
        else//it is a customer 
        {
        int n=login(username,password);
        if(n==1)
        {
             setVisible(false);
             new JF_menu(username).setVisible(true);
        }
        else
            {
            if(n==0)//Handling the null Exception
                JOptionPane.showMessageDialog(null, "The entered user does not exist, please Sigh up !", "User not Found", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_LogInActionPerformed

    private void SighUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SighUpActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new JF_SighUp().setVisible(true);
    }//GEN-LAST:event_SighUpActionPerformed

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
            java.util.logging.Logger.getLogger(JF_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogIn;
    private javax.swing.JButton SighUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
