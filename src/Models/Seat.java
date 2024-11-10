package Models;

public class Seat {
    private int SeatID;
    private String Class;
    private int Available;
    private double Price;
    Flight flight;

    public Seat(String Class, int Available, double Price, Flight flight) {
        this.Class = Class;
        this.Available = Available;
        this.Price = Price;
        this.flight = flight;
    }

    public int getSeatID() {
        return SeatID;
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
}
