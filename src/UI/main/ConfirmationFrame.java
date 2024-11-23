/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.main;


import Models.Flightxtended;
import UI.main.CustomPlugin.ConfirmTemplate;
import UI.main.CustomPlugin.TimeHandle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Sakana
 */
public class ConfirmationFrame extends javax.swing.JFrame {
    private int userID;
    List<ConfirmTemplate> confirmTemplateList = new ArrayList<>();

    private Flightxtended flight;
    private int passengerNumber;
    String seatClass;

    /**
     * Creates new form NewJFrame
     */
    public ConfirmationFrame(Flightxtended flight, int passengerNumber, String seatClass, int userid) {
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Confirmation");
        initComponents();
        this.flight = flight;
        this.userID = userid;
        this.passengerNumber = passengerNumber;
        this.seatClass = seatClass;
        loadInfor();
        loadSCroll();
    }

    private void loadInfor() {
        TimeHandle timeHandle = new TimeHandle();
        String[] hourNmin = timeHandle.getDiffTime(flight.getDepartureTime(), flight.getArrivalTime()).split(" ");
        String hour = hourNmin[0], min = hourNmin[1];

        DepAndArrCity.setText(flight.getDepartureAirport().getCity() + " - " + flight.getArrivalAirport().getCity());

        DateDep.setText("Khởi hành vào " + timeHandle.getTDMY(flight.getDepartureTime()));

        FlightTime.setText("Tổng thời gian " + hour + "h " + min + " phút");

        DepTimeAndCity.setText(timeHandle.getHour(flight.getDepartureTime()) + " " + flight.getDepartureAirport().getCity());

        DEPAirportName.setText(flight.getDepartureAirport().getAirportName());

        ArrTimeAndCity.setText(timeHandle.getHour(flight.getArrivalTime()) + " " + flight.getArrivalAirport().getCity());

        ArrAirportName.setText(flight.getArrivalAirport().getAirportName());

        PlaneCode.setText("VN " + String.format("%03d", flight.getFlightID()));

        PlaneModel.setText(flight.getPlane().getModel());
    }

    public ConfirmationFrame() {
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Confirmation");
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

        BackGroundPane = new javax.swing.JPanel();
        InformationCard = new javax.swing.JPanel();
        InforPane = new javax.swing.JPanel();
        DepAndArrCity = new javax.swing.JLabel();
        DateDep = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        FlightTime = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ArrTimeAndCity = new javax.swing.JLabel();
        DepTimeAndCity = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        DEPAirportName = new javax.swing.JLabel();
        ArrAirportName = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        PlaneCode = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        PlaneModel = new javax.swing.JLabel();
        CancelButton = new javax.swing.JButton();
        ConfirmButton = new javax.swing.JButton();
        ConfirmCard = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ConfirmScrollPane = new javax.swing.JScrollPane();
        ConfirmBGPane = new javax.swing.JPanel();
        ConfirmInfoButton = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        DoneCard = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackGroundPane.setLayout(new java.awt.CardLayout());

        InformationCard.setBackground(new java.awt.Color(219, 243, 250));

        InforPane.setBackground(new java.awt.Color(245, 252, 255));
        InforPane.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        DepAndArrCity.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        DepAndArrCity.setForeground(new java.awt.Color(0, 95, 110));
        DepAndArrCity.setText("Hà Nội - Đà Nẵng ");

        DateDep.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        DateDep.setText("Khởi hành vào Chủ Nhật, 24 tháng 11, 2024");

        jPanel2.setBackground(new java.awt.Color(178, 178, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đang Chờ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        FlightTime.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        FlightTime.setText("Tổng thời gian 1h 25 phút");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Từ:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Đến");

        ArrTimeAndCity.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ArrTimeAndCity.setForeground(new java.awt.Color(0, 95, 110));
        ArrTimeAndCity.setText("07:25 Đà Nẵng");

        DepTimeAndCity.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DepTimeAndCity.setForeground(new java.awt.Color(0, 95, 110));
        DepTimeAndCity.setText("06:00 Hà Nội");

        DEPAirportName.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        DEPAirportName.setText("Sân Bay Nội Bài, Việt Nam");

        ArrAirportName.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        ArrAirportName.setText("Sân bay Đà Nẵng, Việt Nam");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Số hiệu chuyến bay");

        PlaneCode.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PlaneCode.setText("VN 157");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Bởi CLC04AIRLINE ");

        PlaneModel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PlaneModel.setText("AIRBUS A321");

        javax.swing.GroupLayout InforPaneLayout = new javax.swing.GroupLayout(InforPane);
        InforPane.setLayout(InforPaneLayout);
        InforPaneLayout.setHorizontalGroup(
                InforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(InforPaneLayout.createSequentialGroup()
                                .addGroup(InforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(InforPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(InforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(DepAndArrCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(DateDep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(InforPaneLayout.createSequentialGroup()
                                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(FlightTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(InforPaneLayout.createSequentialGroup()
                                                .addGroup(InforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(InforPaneLayout.createSequentialGroup()
                                                                .addGap(86, 86, 86)
                                                                .addGroup(InforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(InforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jSeparator1)
                                                                                .addGroup(InforPaneLayout.createSequentialGroup()
                                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGap(18, 18, 18)
                                                                                        .addGroup(InforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(DEPAirportName, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(DepTimeAndCity, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGap(15, 15, 15)))
                                                                        .addGroup(InforPaneLayout.createSequentialGroup()
                                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(InforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(ArrAirportName, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(ArrTimeAndCity, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                        .addGroup(InforPaneLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(InforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(InforPaneLayout.createSequentialGroup()
                                                                                .addComponent(jLabel9)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(PlaneCode, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(0, 92, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(InforPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(PlaneModel, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InforPaneLayout.setVerticalGroup(
                InforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(InforPaneLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(DepAndArrCity, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DateDep, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FlightTime, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addGroup(InforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DepTimeAndCity, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DEPAirportName)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(InforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ArrTimeAndCity, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ArrAirportName)
                                .addGap(18, 18, 18)
                                .addGroup(InforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(PlaneCode))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PlaneModel)
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        CancelButton.setBackground(new java.awt.Color(255, 101, 101));
        CancelButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CancelButton.setText("Hủy");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        ConfirmButton.setBackground(new java.awt.Color(146, 223, 243));
        ConfirmButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ConfirmButton.setText("Tiếp Tục");
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InformationCardLayout = new javax.swing.GroupLayout(InformationCard);
        InformationCard.setLayout(InformationCardLayout);
        InformationCardLayout.setHorizontalGroup(
                InformationCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(InformationCardLayout.createSequentialGroup()
                                .addContainerGap(122, Short.MAX_VALUE)
                                .addGroup(InformationCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InformationCardLayout.createSequentialGroup()
                                                .addComponent(ConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(156, 156, 156)
                                                .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(143, 143, 143))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InformationCardLayout.createSequentialGroup()
                                                .addComponent(InforPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(98, 98, 98))))
        );
        InformationCardLayout.setVerticalGroup(
                InformationCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InformationCardLayout.createSequentialGroup()
                                .addContainerGap(44, Short.MAX_VALUE)
                                .addComponent(InforPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(InformationCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17))
        );

        BackGroundPane.add(InformationCard, "card2");

        ConfirmCard.setBackground(new java.awt.Color(245, 252, 255));

        jPanel3.setBackground(new java.awt.Color(183, 233, 246));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Xác Nhận Thông Tin Hành Khách");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
        );

        for (int i = 0; i < 5; i++) {
            ConfirmTemplate tmp = new ConfirmTemplate();
            tmp.setMaximumSize(new Dimension(550, 500));
            tmp.setAlignmentX(Component.CENTER_ALIGNMENT);
            ConfirmBGPane.add(tmp);
        }

        javax.swing.GroupLayout ConfirmBGPaneLayout = new javax.swing.GroupLayout(ConfirmBGPane);
        ConfirmBGPane.setLayout(ConfirmBGPaneLayout);
        ConfirmBGPaneLayout.setHorizontalGroup(
                ConfirmBGPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 740, Short.MAX_VALUE)
        );
        ConfirmBGPaneLayout.setVerticalGroup(
                ConfirmBGPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 547, Short.MAX_VALUE)
        );

        ConfirmScrollPane.setViewportView(ConfirmBGPane);

        ConfirmInfoButton.setBackground(new java.awt.Color(146, 223, 243));
        ConfirmInfoButton.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        ConfirmInfoButton.setText("Xác Nhận");
        ConfirmInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmInfoButtonActionPerformed(evt);
            }
        });

        Cancel.setBackground(new java.awt.Color(255, 101, 101));
        Cancel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        Cancel.setText("Hủy");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConfirmCardLayout = new javax.swing.GroupLayout(ConfirmCard);
        ConfirmCard.setLayout(ConfirmCardLayout);
        ConfirmCardLayout.setHorizontalGroup(
                ConfirmCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ConfirmScrollPane)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConfirmCardLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ConfirmInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        ConfirmCardLayout.setVerticalGroup(
                ConfirmCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ConfirmCardLayout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ConfirmScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ConfirmCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ConfirmInfoButton)
                                        .addComponent(Cancel))
                                .addContainerGap())
        );

        BackGroundPane.add(ConfirmCard, "card2");

        DoneCard.setBackground(new java.awt.Color(183, 233, 246));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icon/yatta.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Đặt Vé Thành Công");

        jButton1.setText("Yatta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DoneCardLayout = new javax.swing.GroupLayout(DoneCard);
        DoneCard.setLayout(DoneCardLayout);
        DoneCardLayout.setHorizontalGroup(
                DoneCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DoneCardLayout.createSequentialGroup()
                                .addGroup(DoneCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(DoneCardLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(DoneCardLayout.createSequentialGroup()
                                                .addGap(153, 153, 153)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 155, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(DoneCardLayout.createSequentialGroup()
                                .addGap(322, 322, 322)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DoneCardLayout.setVerticalGroup(
                DoneCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DoneCardLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
        );

        BackGroundPane.add(DoneCard, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(BackGroundPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(BackGroundPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
        // TODO add your handling code here:
        InformationCard.setVisible(false);
        ConfirmCard.setVisible(true);
//        loadSCroll();
    }//GEN-LAST:event_ConfirmButtonActionPerformed

    private void loadSCroll() {
        ConfirmBGPane.setLayout(new BoxLayout(ConfirmBGPane, BoxLayout.Y_AXIS));
        for (int i = 0; i < this.passengerNumber; i++) {
            ConfirmTemplate tmp = new ConfirmTemplate(i + 1);
            tmp.setMaximumSize(new Dimension(550, 500));
            tmp.setPreferredSize(new Dimension(550, 500));
            tmp.setAlignmentX(Component.CENTER_ALIGNMENT);
            ConfirmBGPane.add(tmp);
            confirmTemplateList.add(tmp);
        }
        ConfirmScrollPane.setViewportView(ConfirmBGPane);
        ConfirmScrollPane.getVerticalScrollBar().setUnitIncrement(15);
        ConfirmBGPane.revalidate();
        ConfirmBGPane.repaint();
    }

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        ConfirmCard.setVisible(false);
        InformationCard.setVisible(true);
    }//GEN-LAST:event_CancelActionPerformed

    private void ConfirmInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmInfoButtonActionPerformed
        // TODO add your handling code here:
        if (check()) {
            // logic needed here

            // and yatta
            ConfirmCard.setVisible(false);
            DoneCard.setVisible(true);
        }
    }//GEN-LAST:event_ConfirmInfoButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private boolean check() {
        for (ConfirmTemplate tmp : confirmTemplateList) {
            if (!tmp.isFullFill()) {
                JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin", "Alert!!!", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        return true;
    }

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
            java.util.logging.Logger.getLogger(ConfirmationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfirmationFrame c = new ConfirmationFrame();
                c.setVisible(true);
                c.pack();
                c.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ArrAirportName;
    private javax.swing.JLabel ArrTimeAndCity;
    private javax.swing.JPanel BackGroundPane;
    private javax.swing.JButton Cancel;
    private javax.swing.JButton CancelButton;
    private javax.swing.JPanel ConfirmBGPane;
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JPanel ConfirmCard;
    private javax.swing.JButton ConfirmInfoButton;
    private javax.swing.JScrollPane ConfirmScrollPane;
    private javax.swing.JLabel DEPAirportName;
    private javax.swing.JLabel DateDep;
    private javax.swing.JLabel DepAndArrCity;
    private javax.swing.JLabel DepTimeAndCity;
    private javax.swing.JPanel DoneCard;
    private javax.swing.JLabel FlightTime;
    private javax.swing.JPanel InforPane;
    private javax.swing.JPanel InformationCard;
    private javax.swing.JLabel PlaneCode;
    private javax.swing.JLabel PlaneModel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
