package Models;

import java.text.SimpleDateFormat;
import java.util.Date;

// chưa xong
public class Ticket {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private int ticketID;
    private String TicketCode;
    private Passenger passenger;
    private Seat Seat;
    private Flight flight;
    private Date ReservationDate;
    private double Price;
    private boolean Status;

    public Ticket(Passenger passenger, Seat Seat, Flight flight, Date ReservationDate) {
        this.passenger = passenger;
        this.Seat = Seat;
        this.flight = flight;
        this.ReservationDate = ReservationDate;
        this.Price = getSeat().getPrice();
        this.Status = true;
    }

    public String getTicketCode() {
        return TicketCode;
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
        return sdf.format(ReservationDate);
    }

    public void setReservationDate(Date ReservationDate) {
        this.ReservationDate = ReservationDate;
    }

    public double getPrice() {
        return Price;
    }

    // Phương thức hủy vé
    public void cancelTicket() {
        if (Status) {
            this.Status = false;
            System.out.println("Vé số " + ticketID + " đã bị hủy.");
        } else {
            System.out.println("Vé số " + ticketID + " đã bị hủy trước đó.");
        }
    }

    public String getStatus() {
        if (Status) {
            return "Vé đang có hiệu lực";
        } else return "Vé đã hết hiệu lực";
    }
    public boolean isActive() {
        return Status;
    }

    // Hiển thị thông tin vé
    @Override
    public String toString() {
        return "Ticket ID: " + ticketID + ", Passenger: " + passenger.getName() +
                ", Flight: " + flight.getFlightID() + ", Seat: " + getSeat().getPosition() +
                ", Price: $" + Price + ", Status: " + (Status ? "Cancelled" : "Active");
    }
}
