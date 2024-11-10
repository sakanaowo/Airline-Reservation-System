/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

/**
 *
 * @author ADMIN
 */
public class SignUp extends javax.swing.JFrame {

    /**
     * Creates new form SignUp
     */
    public SignUp() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        BrandName = new javax.swing.JLabel();
        CopyRight = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        SignUpLabel = new javax.swing.JLabel();
        Fullname = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        FullnameField = new javax.swing.JTextField();
        Email = new javax.swing.JLabel();
        EmailField = new javax.swing.JTextField();
        LoginButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        SignUpButton = new javax.swing.JButton();
        PasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIGNUP");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        Right.setBackground(new java.awt.Color(0, 102, 102));
        Right.setMinimumSize(new java.awt.Dimension(400, 500));

        BrandName.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
        BrandName.setForeground(new java.awt.Color(255, 255, 255));
        BrandName.setText("CLC04 Airlines");

        CopyRight.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        CopyRight.setForeground(new java.awt.Color(255, 255, 255));
        CopyRight.setText("copyright (c) CLC04 AIRLINES All rights reserved");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo.png"))); // NOI18N

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(485, 485, 485)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CopyRight)
                    .addComponent(BrandName, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel1))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(BrandName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(CopyRight)
                .addGap(78, 78, 78))
        );

        jPanel1.add(Right);
        Right.setBounds(0, 0, 400, 500);

        SignUpLabel.setBackground(new java.awt.Color(255, 255, 255));
        SignUpLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        SignUpLabel.setForeground(new java.awt.Color(0, 102, 102));
        SignUpLabel.setText("Sign Up");
        jPanel1.add(SignUpLabel);
        SignUpLabel.setBounds(520, 40, 140, 50);

        Fullname.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Fullname.setText("Full name");
        jPanel1.add(Fullname);
        Fullname.setBounds(440, 120, 70, 22);

        Password.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Password.setText("Password");
        jPanel1.add(Password);
        Password.setBounds(440, 280, 67, 16);

        FullnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FullnameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(FullnameField);
        FullnameField.setBounds(440, 150, 300, 30);

        Email.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Email.setText("Email");
        jPanel1.add(Email);
        Email.setBounds(440, 200, 50, 16);

        EmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailFieldActionPerformed(evt);
            }
        });
        jPanel1.add(EmailField);
        EmailField.setBounds(440, 230, 300, 30);

        LoginButton.setBackground(new java.awt.Color(204, 204, 204));
        LoginButton.setForeground(new java.awt.Color(255, 51, 0));
        LoginButton.setText("Login");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        jPanel1.add(LoginButton);
        LoginButton.setBounds(550, 403, 72, 30);

        jLabel5.setText("I've an account");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(440, 410, 90, 16);

        SignUpButton.setBackground(new java.awt.Color(0, 102, 102));
        SignUpButton.setForeground(new java.awt.Color(255, 255, 255));
        SignUpButton.setText("Sign Up");
        SignUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpButtonActionPerformed(evt);
            }
        });
        jPanel1.add(SignUpButton);
        SignUpButton.setBounds(440, 360, 80, 30);
        jPanel1.add(PasswordField);
        PasswordField.setBounds(440, 310, 300, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FullnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FullnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FullnameFieldActionPerformed

    private void EmailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailFieldActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void SignUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SignUpButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BrandName;
    private javax.swing.JLabel CopyRight;
    private javax.swing.JLabel Email;
    private javax.swing.JTextField EmailField;
    private javax.swing.JLabel Fullname;
    private javax.swing.JTextField FullnameField;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Password;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JPanel Right;
    private javax.swing.JButton SignUpButton;
    private javax.swing.JLabel SignUpLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
