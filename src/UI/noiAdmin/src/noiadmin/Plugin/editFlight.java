package noiadmin.Plugin;

import javax.swing.*;
import java.util.Date;

public class editFlight extends javax.swing.JFrame {

    /**
     * Creates new form EditFlight
     */
    public editFlight() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {

        // Initialize components
        DepartureField = new javax.swing.JTextField();
        EditButton = new javax.swing.JButton();
        FlightNameField = new javax.swing.JTextField();
        ArrivalField = new javax.swing.JTextField();
        FlightIDField = new javax.swing.JTextField();
        PlaneIDField = new javax.swing.JTextField();

        // Labels
        JLabel titleLabel = new JLabel("Edit Flight");
        JLabel flightIDLabel = new JLabel("FlightID");
        JLabel flightNameLabel = new JLabel("Name");
        JLabel departureLabel = new JLabel("Departure");
        JLabel arrivalLabel = new JLabel("Arrival");
        JLabel dateLabel = new JLabel("Date");
        JLabel departureTimeLabel = new JLabel("Departure Time");
        JLabel arrivalTimeLabel = new JLabel("Arrival Time");
        JLabel planeIDLabel = new JLabel("PlaneID");

        // JSpinners for date and time
        DateSpinner = createSpinner("yyyy-MM-dd");
        DepartureTimeSpinner = createSpinner("yyyy-MM-dd HH:mm");
        ArrivalTimeSpinner = createSpinner("yyyy-MM-dd HH:mm");

        // Button settings
        EditButton.setFont(new java.awt.Font("Segoe UI", 0, 14));
        EditButton.setText("Edit");
        EditButton.addActionListener(evt -> handleEditAction());

        // Frame settings
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Flight");

        // Layout setup
        setupLayout(
                titleLabel, flightIDLabel, flightNameLabel, departureLabel, arrivalLabel,
                dateLabel, departureTimeLabel, arrivalTimeLabel, planeIDLabel
        );

        pack();
    }

    /**
     * Helper method to create formatted JSpinner
     */
    private JSpinner createSpinner(String pattern) {
        JSpinner spinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, pattern);
        spinner.setEditor(editor);
        return spinner;
    }

    /**
     * Setup layout using GroupLayout
     */
    private void setupLayout(JLabel titleLabel, JLabel flightIDLabel, JLabel flightNameLabel,
            JLabel departureLabel, JLabel arrivalLabel, JLabel dateLabel,
            JLabel departureTimeLabel, JLabel arrivalTimeLabel, JLabel planeIDLabel) {
        // Using GroupLayout for proper positioning
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(31)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(flightIDLabel)
                                        .addGap(44)
                                        .addComponent(FlightIDField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(planeIDLabel)
                                        .addGap(44)
                                        .addComponent(PlaneIDField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(flightNameLabel)
                                        .addGap(44)
                                        .addComponent(FlightNameField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
                        .addGap(92)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(departureLabel)
                                .addComponent(arrivalLabel)
                                .addComponent(dateLabel))
                        .addGap(18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(DepartureField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                .addComponent(ArrivalField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                .addComponent(DateSpinner, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
                        .addGap(100)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(departureTimeLabel)
                                .addComponent(arrivalTimeLabel))
                        .addGap(18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(DepartureTimeSpinner, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                .addComponent(ArrivalTimeSpinner, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLabel)
                        .addGap(368))
                .addGroup(layout.createSequentialGroup()
                        .addGap(400)
                        .addComponent(EditButton))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(21)
                .addComponent(titleLabel)
                .addGap(26)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(flightIDLabel)
                        .addComponent(FlightIDField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(departureLabel)
                        .addComponent(DepartureField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(departureTimeLabel)
                        .addComponent(DepartureTimeSpinner, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(planeIDLabel)
                        .addComponent(PlaneIDField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(arrivalLabel)
                        .addComponent(ArrivalField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(arrivalTimeLabel)
                        .addComponent(ArrivalTimeSpinner, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(flightNameLabel)
                        .addComponent(FlightNameField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateLabel)
                        .addComponent(DateSpinner, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(30)
                .addComponent(EditButton)
        );

    }

    /**
     * Handle Edit button action
     */
    private void handleEditAction() {
        try {
            Date date = (Date) DateSpinner.getValue();
            Date departureTime = (Date) DepartureTimeSpinner.getValue();
            Date arrivalTime = (Date) ArrivalTimeSpinner.getValue();
            System.out.println("Date: " + date);
            System.out.println("Departure Time: " + departureTime);
            System.out.println("Arrival Time: " + arrivalTime);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error processing date/time input: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new editFlight().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JTextField ArrivalField;
    private javax.swing.JSpinner ArrivalTimeSpinner;
    private javax.swing.JSpinner DateSpinner;
    private javax.swing.JTextField DepartureField;
    private javax.swing.JSpinner DepartureTimeSpinner;
    private javax.swing.JButton EditButton;
    private javax.swing.JTextField FlightIDField;
    private javax.swing.JTextField FlightNameField;
    private javax.swing.JTextField PlaneIDField;
}
