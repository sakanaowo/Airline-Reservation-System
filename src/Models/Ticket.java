package Models;

public class Ticket {
    private static int ticketCounter = 0;  // Đếm số vé được tạo
    private int ticketID;
    private Passenger passenger;
    private Flight flight;
    private String seat;
    private double price;
    private boolean isCancelled;  // Trạng thái của vé: true nếu vé đã bị hủy, false nếu chưa

    // Constructor để khởi tạo Ticket
    public Ticket(Passenger passenger, Flight flight, String seat, double price) {
        this.ticketID = ++ticketCounter;
        this.passenger = passenger;
        this.flight = flight;
        this.seat = seat;
        this.price = price;
        this.isCancelled = false;  // Khi vé được tạo, mặc định là chưa bị hủy
    }

    // Getter cho ticketID
    public int getTicketID() {
        return ticketID;
    }

    // Getter cho passenger
    public Passenger getPassenger() {
        return passenger;
    }

    // Getter cho flight
    public Flight getFlight() {
        return flight;
    }

    // Getter cho seat
    public String getSeat() {
        return seat;
    }

    // Getter cho price
    public double getPrice() {
        return price;
    }

    // Phương thức hủy vé
    public void cancelTicket() {
        if (!isCancelled) {
            this.isCancelled = true;
            System.out.println("Vé số " + ticketID + " đã bị hủy.");
        } else {
            System.out.println("Vé số " + ticketID + " đã bị hủy trước đó.");
        }
    }

    // Kiểm tra xem vé đã bị hủy hay chưa
    public boolean isCancelled() {
        return isCancelled;
    }

    // Hiển thị thông tin vé
    @Override
    public String toString() {
        return "Ticket ID: " + ticketID + ", Passenger: " + passenger.getName() +
                ", Flight: " + flight.getFlightID() + ", Seat: " + seat +
                ", Price: $" + price + ", Status: " + (isCancelled ? "Cancelled" : "Active");
    }
}
