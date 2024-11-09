/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

/**
 *
 * @author ADMIN
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
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

        background = new javax.swing.JPanel();
        login_button = new javax.swing.JButton();
        signup_button = new javax.swing.JButton();
        logo_login = new javax.swing.JLabel();
        khung_tim_chuyen_bay = new javax.swing.JPanel();
        mot_chieu = new javax.swing.JRadioButton();
        khu_hoi = new javax.swing.JRadioButton();
        tien_te = new javax.swing.JLabel();
        diem_den = new javax.swing.JComboBox<>();
        nut_tim_chuyen_bay = new javax.swing.JButton();
        diem_khoi_hanh = new javax.swing.JComboBox<>();
        label_ngay_di = new javax.swing.JLabel();
        label_khoi_hanh = new javax.swing.JLabel();
        label_diem_den = new javax.swing.JLabel();
        chon_ngay_di = new com.toedter.calendar.JDateChooser();
        anh_may_hong = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HOME\n");

        background.setLayout(null);

        login_button.setBackground(new java.awt.Color(204, 0, 0));
        login_button.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        login_button.setForeground(new java.awt.Color(255, 255, 255));
        login_button.setText("Login");
        login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_buttonActionPerformed(evt);
            }
        });
        background.add(login_button);
        login_button.setBounds(640, 20, 80, 30);

        signup_button.setBackground(new java.awt.Color(204, 0, 0));
        signup_button.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        signup_button.setForeground(new java.awt.Color(255, 255, 255));
        signup_button.setText("Sign Up");
        signup_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_buttonActionPerformed(evt);
            }
        });
        background.add(signup_button);
        signup_button.setBounds(730, 20, 80, 30);

        logo_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/login.png"))); // NOI18N
        background.add(logo_login);
        logo_login.setBounds(600, 20, 30, 30);

        khung_tim_chuyen_bay.setBackground(new java.awt.Color(204, 0, 0));

        mot_chieu.setBackground(new java.awt.Color(204, 0, 0));
        mot_chieu.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        mot_chieu.setForeground(new java.awt.Color(255, 255, 255));
        mot_chieu.setText("Một chiều");
        mot_chieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mot_chieuActionPerformed(evt);
            }
        });

        khu_hoi.setBackground(new java.awt.Color(204, 0, 0));
        khu_hoi.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        khu_hoi.setForeground(new java.awt.Color(255, 255, 255));
        khu_hoi.setText("Khứ hồi");

        tien_te.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        tien_te.setForeground(new java.awt.Color(255, 255, 255));
        tien_te.setText("VND");

        diem_den.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        diem_den.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hà Nội (HAN), Việt Nam", "Tp. Hồ Chí Minh (SGN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Cà Mau (CAH), Việt Nam", "Cần Thơ (VCA), Việt Nam", "Chu Lai (VCL), Việt Nam", "Côn Đảo (VCS), Việt Nam", "Đà Lạt (DLI), Việt Nam", "Điện Biên (DIN), Việt Nam", "Đồng Hới (VDH), Việt Nam", "Hải Phòng (HPH), Việt Nam", "Huế (HUI), Việt Nam", "Pleiku (PXU), Việt Nam", "Quy Nhơn (UIH), Việt Nam", "Rạch Giá (VKG), Việt Nam", "Thanh Hóa (THD), Việt Nam", "Tuy Hòa (TBB), Việt Nam", "Vân Đồn (VDO), Việt Nam", "Vinh (VII), Việt Nam", " " }));

        nut_tim_chuyen_bay.setBackground(new java.awt.Color(255, 255, 0));
        nut_tim_chuyen_bay.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        nut_tim_chuyen_bay.setText("Tìm chuyến bay");

        diem_khoi_hanh.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        diem_khoi_hanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hà Nội (HAN), Việt Nam", "Tp. Hồ Chí Minh (SGN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Cà Mau (CAH), Việt Nam", "Cần Thơ (VCA), Việt Nam", "Chu Lai (VCL), Việt Nam", "Côn Đảo (VCS), Việt Nam", "Đà Lạt (DLI), Việt Nam", "Điện Biên (DIN), Việt Nam", "Đồng Hới (VDH), Việt Nam", "Hải Phòng (HPH), Việt Nam", "Huế (HUI), Việt Nam", "Pleiku (PXU), Việt Nam", "Quy Nhơn (UIH), Việt Nam", "Rạch Giá (VKG), Việt Nam", "Thanh Hóa (THD), Việt Nam", "Tuy Hòa (TBB), Việt Nam", "Vân Đồn (VDO), Việt Nam", "Vinh (VII), Việt Nam", " " }));
        diem_khoi_hanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diem_khoi_hanhActionPerformed(evt);
            }
        });

        label_ngay_di.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        label_ngay_di.setForeground(new java.awt.Color(255, 255, 255));
        label_ngay_di.setText("Ngày đi:");

        label_khoi_hanh.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        label_khoi_hanh.setForeground(new java.awt.Color(255, 255, 255));
        label_khoi_hanh.setText("Điểm khởi hành:");

        label_diem_den.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        label_diem_den.setForeground(new java.awt.Color(255, 255, 255));
        label_diem_den.setText("Điểm đến:");

        chon_ngay_di.setDateFormatString("dd/MM/yyyy");
        chon_ngay_di.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N

        javax.swing.GroupLayout khung_tim_chuyen_bayLayout = new javax.swing.GroupLayout(khung_tim_chuyen_bay);
        khung_tim_chuyen_bay.setLayout(khung_tim_chuyen_bayLayout);
        khung_tim_chuyen_bayLayout.setHorizontalGroup(
            khung_tim_chuyen_bayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khung_tim_chuyen_bayLayout.createSequentialGroup()
                .addGroup(khung_tim_chuyen_bayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(khung_tim_chuyen_bayLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(nut_tim_chuyen_bay))
                    .addGroup(khung_tim_chuyen_bayLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_diem_den))
                    .addGroup(khung_tim_chuyen_bayLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_ngay_di))
                    .addGroup(khung_tim_chuyen_bayLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_khoi_hanh)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, khung_tim_chuyen_bayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(khung_tim_chuyen_bayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chon_ngay_di, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(diem_khoi_hanh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(diem_den, javax.swing.GroupLayout.Alignment.LEADING, 0, 285, Short.MAX_VALUE)
                    .addGroup(khung_tim_chuyen_bayLayout.createSequentialGroup()
                        .addComponent(mot_chieu)
                        .addGap(33, 33, 33)
                        .addComponent(khu_hoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tien_te)))
                .addGap(19, 19, 19))
        );
        khung_tim_chuyen_bayLayout.setVerticalGroup(
            khung_tim_chuyen_bayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khung_tim_chuyen_bayLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(khung_tim_chuyen_bayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mot_chieu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(khu_hoi)
                    .addComponent(tien_te))
                .addGap(18, 18, 18)
                .addComponent(label_khoi_hanh, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(diem_khoi_hanh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_diem_den)
                .addGap(11, 11, 11)
                .addComponent(diem_den, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_ngay_di)
                .addGap(18, 18, 18)
                .addComponent(chon_ngay_di, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(nut_tim_chuyen_bay, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        background.add(khung_tim_chuyen_bay);
        khung_tim_chuyen_bay.setBounds(560, 70, 310, 390);

        anh_may_hong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/bg.jpg"))); // NOI18N
        anh_may_hong.setText("jLabel6");
        background.add(anh_may_hong);
        anh_may_hong.setBounds(0, 0, 900, 506);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 897, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGap(0, 506, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void diem_khoi_hanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diem_khoi_hanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diem_khoi_hanhActionPerformed

    private void mot_chieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mot_chieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mot_chieuActionPerformed

    private void signup_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_buttonActionPerformed
        SignUp SignUpFrame = new SignUp();
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_signup_buttonActionPerformed

    private void login_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_buttonActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_login_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anh_may_hong;
    private javax.swing.JPanel background;
    private com.toedter.calendar.JDateChooser chon_ngay_di;
    private javax.swing.JComboBox<String> diem_den;
    private javax.swing.JComboBox<String> diem_khoi_hanh;
    private javax.swing.JRadioButton khu_hoi;
    private javax.swing.JPanel khung_tim_chuyen_bay;
    private javax.swing.JLabel label_diem_den;
    private javax.swing.JLabel label_khoi_hanh;
    private javax.swing.JLabel label_ngay_di;
    private javax.swing.JButton login_button;
    private javax.swing.JLabel logo_login;
    private javax.swing.JRadioButton mot_chieu;
    private javax.swing.JButton nut_tim_chuyen_bay;
    private javax.swing.JButton signup_button;
    private javax.swing.JLabel tien_te;
    // End of variables declaration//GEN-END:variables
}
