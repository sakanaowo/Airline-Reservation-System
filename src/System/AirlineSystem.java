package System;

public class AirlineSystem {
    public FlightControl flightControl;
    public UserControl userControl;
    public ReservationControl reservationControl;
    public AirlineSystem() {
        flightControl = new FlightControl();
        userControl = new UserControl();
        reservationControl = new ReservationControl();
    }
}