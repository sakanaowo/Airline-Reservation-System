package Models;

import java.util.Date;

public class Flightxtended extends Flight {
    private int economySeatAvailable, businessSeatAvailable;

    public Flightxtended(Date DepartureTime, Date ArrivalTime, Plane plane, Airport ArrivalAirport, Airport DepartureAirport, int economySeat, int businessSeat) {
        super(DepartureTime, ArrivalTime, plane, ArrivalAirport, DepartureAirport);
        this.economySeatAvailable = economySeat;
        this.businessSeatAvailable = businessSeat;
    }

    public int getEconomySeatAvailable() {
        return economySeatAvailable;
    }

    public int getBusinessSeatAvailable() {
        return businessSeatAvailable;
    }

    @Override
    public String toString() {
        return super.toString() + economySeatAvailable + " "
                + businessSeatAvailable;
    }
}
