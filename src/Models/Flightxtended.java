package Models;

import java.util.Date;

public class Flightxtended extends Flight {
    private int economySeat, businessSeat;

    public Flightxtended(Date DepartureTime, Date ArrivalTime, Plane plane, Airport ArrivalAirport, Airport DepartureAirport, int economySeat, int businessSeat) {
        super(DepartureTime, ArrivalTime, plane, ArrivalAirport, DepartureAirport);
        this.economySeat = economySeat;
        this.businessSeat = businessSeat;
    }

    public int getEconomySeat() {
        return economySeat;
    }

    public int getBusinessSeat() {
        return businessSeat;
    }

    @Override
    public String toString() {
        return super.toString() + economySeat + " "
                + businessSeat;
    }
}
