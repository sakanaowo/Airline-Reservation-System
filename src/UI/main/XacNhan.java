/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.main;

/**
 *
 * @author ADMIN
 */
public class XacNhan extends javax.swing.JFrame {

    /**
     * Creates new form XacNhan
     */
    public XacNhan() {
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

        pnContainer = new javax.swing.JPanel();
        pnTitle = new javax.swing.JPanel();
        lbl_xac_nhan = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_hang_ghe = new javax.swing.JLabel();
        lbl_tong_tien = new javax.swing.JLabel();
        lbl_diem_den = new javax.swing.JLabel();
        lbl_ngay_bay = new javax.swing.JLabel();
        lbl_thoi_gian_bay = new javax.swing.JLabel();
        lbl_so_ghe = new javax.swing.JLabel();
        lbl_diem_khoi_hanh = new javax.swing.JLabel();
        lbl_cmnd = new javax.swing.JLabel();
        lbl_ho_va_ten = new javax.swing.JLabel();
        lbl_so_dien_thoai = new javax.swing.JLabel();
        lbl_gia_ve = new javax.swing.JLabel();
        lbl_thue = new javax.swing.JLabel();
        diem_khoi_hanh_field = new javax.swing.JTextField();
        so_ghe_field = new javax.swing.JTextField();
        diem_den_field = new javax.swing.JTextField();
        ngay_bay_field = new javax.swing.JTextField();
        thoi_gian_bay_field = new javax.swing.JTextField();
        hang_ghe_field = new javax.swing.JTextField();
        cmnd_field = new javax.swing.JTextField();
        thue_field = new javax.swing.JTextField();
        tong_tien_field = new javax.swing.JTextField();
        gia_ve_field = new javax.swing.JTextField();
        so_diem_thoai_field = new javax.swing.JTextField();
        ho_va_ten_field = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnContainer.setBackground(new java.awt.Color(255, 255, 255));
        pnContainer.setMinimumSize(new java.awt.Dimension(1000, 550));
        pnContainer.setPreferredSize(new java.awt.Dimension(1000, 550));

        pnTitle.setBackground(new java.awt.Color(204, 0, 0));

        lbl_xac_nhan.setFont(new java.awt.Font("Segoe UI Black", 0, 30)); // NOI18N
        lbl_xac_nhan.setForeground(new java.awt.Color(255, 255, 255));
        lbl_xac_nhan.setText("XÁC NHẬN");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icon/xacnhan.png.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout pnTitleLayout = new javax.swing.GroupLayout(pnTitle);
        pnTitle.setLayout(pnTitleLayout);
        pnTitleLayout.setHorizontalGroup(
            pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTitleLayout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_xac_nhan)
                .addContainerGap(426, Short.MAX_VALUE))
        );
        pnTitleLayout.setVerticalGroup(
            pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTitleLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(lbl_xac_nhan))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        lbl_hang_ghe.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lbl_hang_ghe.setText("HẠNG GHẾ:");

        lbl_tong_tien.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lbl_tong_tien.setText("TỔNG TIỀN:");

        lbl_diem_den.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lbl_diem_den.setText("ĐIỂM ĐẾN:");

        lbl_ngay_bay.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lbl_ngay_bay.setText("NGÀY BAY:");

        lbl_thoi_gian_bay.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lbl_thoi_gian_bay.setText("THỜI GIAN BAY:");

        lbl_so_ghe.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lbl_so_ghe.setText("SỐ GHẾ:");

        lbl_diem_khoi_hanh.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lbl_diem_khoi_hanh.setText("ĐIỂM KHỞI HÀNH:");

        lbl_cmnd.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lbl_cmnd.setText("CMND:");

        lbl_ho_va_ten.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lbl_ho_va_ten.setText("HỌ VÀ TÊN:");

        lbl_so_dien_thoai.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lbl_so_dien_thoai.setText("SỐ ĐIỆN THOẠI:");

        lbl_gia_ve.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lbl_gia_ve.setText("GIÁ VÉ:");

        lbl_thue.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lbl_thue.setText("THUẾ:");

        diem_khoi_hanh_field.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        so_ghe_field.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        so_ghe_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                so_ghe_fieldActionPerformed(evt);
            }
        });

        diem_den_field.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        ngay_bay_field.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        ngay_bay_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngay_bay_fieldActionPerformed(evt);
            }
        });

        thoi_gian_bay_field.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        thoi_gian_bay_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoi_gian_bay_fieldActionPerformed(evt);
            }
        });

        hang_ghe_field.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        hang_ghe_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hang_ghe_fieldActionPerformed(evt);
            }
        });

        cmnd_field.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        thue_field.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        thue_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thue_fieldActionPerformed(evt);
            }
        });

        tong_tien_field.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        gia_ve_field.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        so_diem_thoai_field.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        ho_va_ten_field.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton3.setText("XÁC NHẬN");

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton2.setText("ĐÓNG");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnContainerLayout = new javax.swing.GroupLayout(pnContainer);
        pnContainer.setLayout(pnContainerLayout);
        pnContainerLayout.setHorizontalGroup(
            pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnContainerLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnContainerLayout.createSequentialGroup()
                            .addComponent(lbl_diem_khoi_hanh, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)
                            .addComponent(diem_khoi_hanh_field, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnContainerLayout.createSequentialGroup()
                            .addComponent(lbl_diem_den, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(98, 98, 98)
                            .addComponent(diem_den_field))
                        .addGroup(pnContainerLayout.createSequentialGroup()
                            .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_so_ghe)
                                .addComponent(lbl_hang_ghe)
                                .addComponent(lbl_thoi_gian_bay))
                            .addGap(59, 59, 59)
                            .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(thoi_gian_bay_field)
                                .addComponent(so_ghe_field)
                                .addComponent(hang_ghe_field)))
                        .addGroup(pnContainerLayout.createSequentialGroup()
                            .addComponent(lbl_ngay_bay)
                            .addGap(95, 95, 95)
                            .addComponent(ngay_bay_field)))
                    .addComponent(jButton3))
                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnContainerLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnContainerLayout.createSequentialGroup()
                                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_cmnd)
                                    .addComponent(lbl_ho_va_ten)
                                    .addComponent(lbl_so_dien_thoai, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_gia_ve)
                                    .addComponent(lbl_tong_tien, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(pnContainerLayout.createSequentialGroup()
                                .addComponent(lbl_thue)
                                .addGap(93, 93, 93)))
                        .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tong_tien_field, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(gia_ve_field)
                            .addComponent(so_diem_thoai_field)
                            .addComponent(cmnd_field)
                            .addComponent(ho_va_ten_field)
                            .addComponent(thue_field)))
                    .addGroup(pnContainerLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pnContainerLayout.setVerticalGroup(
            pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContainerLayout.createSequentialGroup()
                .addComponent(pnTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(diem_khoi_hanh_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_diem_khoi_hanh)
                    .addComponent(lbl_cmnd)
                    .addComponent(cmnd_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(diem_den_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ho_va_ten_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_diem_den)
                    .addComponent(lbl_ho_va_ten))
                .addGap(30, 30, 30)
                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnContainerLayout.createSequentialGroup()
                        .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ngay_bay_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_so_dien_thoai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_ngay_bay, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(so_diem_thoai_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(thoi_gian_bay_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_thoi_gian_bay, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(gia_ve_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_gia_ve, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tong_tien_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(so_ghe_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_so_ghe)
                    .addComponent(lbl_tong_tien))
                .addGap(30, 30, 30)
                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_thue, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_hang_ghe, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hang_ghe_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thue_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void so_ghe_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_so_ghe_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_so_ghe_fieldActionPerformed

    private void ngay_bay_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngay_bay_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ngay_bay_fieldActionPerformed

    private void thoi_gian_bay_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thoi_gian_bay_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thoi_gian_bay_fieldActionPerformed

    private void hang_ghe_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hang_ghe_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hang_ghe_fieldActionPerformed

    private void thue_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thue_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thue_fieldActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void setDiemKhoiHanh(String diemKhoiHanh) {
    diem_khoi_hanh_field.setText(diemKhoiHanh);
    }
    
    public void setDiemDen(String diemDen) {
    diem_den_field.setText(diemDen);
    }
    public void setNgayBay(String ngayBay) {
    ngay_bay_field.setText(ngayBay);
    }
    public void setThoiGianBay(String thoiGianBay) {
    thoi_gian_bay_field.setText(thoiGianBay);
    }
    
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
            java.util.logging.Logger.getLogger(XacNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XacNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XacNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XacNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XacNhan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cmnd_field;
    private javax.swing.JTextField diem_den_field;
    private javax.swing.JTextField diem_khoi_hanh_field;
    private javax.swing.JTextField gia_ve_field;
    private javax.swing.JTextField hang_ghe_field;
    private javax.swing.JTextField ho_va_ten_field;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_cmnd;
    private javax.swing.JLabel lbl_diem_den;
    private javax.swing.JLabel lbl_diem_khoi_hanh;
    private javax.swing.JLabel lbl_gia_ve;
    private javax.swing.JLabel lbl_hang_ghe;
    private javax.swing.JLabel lbl_ho_va_ten;
    private javax.swing.JLabel lbl_ngay_bay;
    private javax.swing.JLabel lbl_so_dien_thoai;
    private javax.swing.JLabel lbl_so_ghe;
    private javax.swing.JLabel lbl_thoi_gian_bay;
    private javax.swing.JLabel lbl_thue;
    private javax.swing.JLabel lbl_tong_tien;
    private javax.swing.JLabel lbl_xac_nhan;
    private javax.swing.JTextField ngay_bay_field;
    private javax.swing.JPanel pnContainer;
    private javax.swing.JPanel pnTitle;
    private javax.swing.JTextField so_diem_thoai_field;
    private javax.swing.JTextField so_ghe_field;
    private javax.swing.JTextField thoi_gian_bay_field;
    private javax.swing.JTextField thue_field;
    private javax.swing.JTextField tong_tien_field;
    // End of variables declaration//GEN-END:variables
}
