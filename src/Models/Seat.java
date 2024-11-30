package Models;

public class Seat {
    private int SeatID;
    private String Position;
    private String Class;
    private int Available;
    private double Price;
    Flight flight;

    public Seat() {
    }

    public Seat(String Class, int Available, String Position, double Price, Flight flight) {
        this.Class = Class;
        this.Available = Available;
        this.Position = Position;
        this.Price = Price;
        this.flight = flight;
    }

    public void setSeatID(int SeatID) {
        this.SeatID = SeatID;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getSeatClass() {
        return Class;
    }

    public int getAvailable() {
        return Available;
    }

    public void setAvailable(int available) {
        Available = available;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getFlightID() {
        return flight.getFlightID();
    }

    public void setClass(String seatClass) {
        this.Class = seatClass;
    }
}
