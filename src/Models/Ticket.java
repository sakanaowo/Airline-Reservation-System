package Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
    private int ticketID;
    private String TicketCode;
    private Passenger passenger;
    private Seat Seat;
    private Flight flight;
    private Date ReservationDate;
    private double Price;

    public Ticket(Passenger passenger, Seat Seat, Flight flight, Date ReservationDate) {
        this.passenger = passenger;
        this.Seat = Seat;
        this.flight = flight;
        this.ReservationDate = ReservationDate;
        this.Price = getSeat().getPrice();
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketCode() {
        return TicketCode;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setTicketCode(String TicketCode) {
        this.TicketCode = TicketCode;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Seat getSeat() {
        return Seat;
    }

    public void setSeat(Seat Seat) {
        this.Seat = Seat;
    }

    public String getReservationDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(ReservationDate);
    }

    public void setReservationDate(Date ReservationDate) {
        this.ReservationDate = ReservationDate;
    }

    public double getPrice() {
        return Price;
    }

    public String getReservationTime() {
        return new SimpleDateFormat("HH:mm").format(ReservationDate);
    }

    @Override
    public String toString() {
        return "TicketID: " + getTicketCode() + '\n' +
                "TicketCode" + getTicketCode() + "\n" +
                "Passenger: " + getPassenger().getName() + '\n' +
                "SeatID: " + getSeat().getPosition() + '\n' +
                "FlightID: " + getFlight().getFlightID() + '\n' +
                "Date: " + getReservationDate() + '\n';
    }
}
