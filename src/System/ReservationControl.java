package System;

import DataHandle.Data.*;
import Models.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationControl {
    public static int createPassenger(Passenger passenger, int userID) {
        return Passengers.insertPassenger(passenger.getFirstName(), passenger.getLastName(), passenger.getPhoneNumber(), passenger.getCitizenID(), userID);
    }

    public static void makeTicket(String seatClass, Passenger passenger, Flightxtended flight) {
        int seatID = Seats.getMinAvailableSeatIDByClass(seatClass, flight.getFlightID());
        String ticketCode = seatClass.substring(0,1).toUpperCase()+flight.getFlightID() + "-" + seatID;
        System.out.println(
                "PassID: " + passenger.getPassengerID() + '\n' +
                        "SeatID: " + seatID + '\n' +
                        "TicketCode: " + ticketCode + '\n' +
                        "FlightID: " + flight.getFlightID()
        );

        Tickets.insertTicket(passenger.getPassengerID(), seatID, ticketCode);

    }

    public static Ticket getTicketByPassID(int passengerID) {

        ArrayList<Object> tmp = Tickets.viewTicket(passengerID);
        int ticketID = (int) tmp.get(0);
        int seatID = (int) tmp.get(1);
        String ticketCode = (String) tmp.get(2);
        Date reservationDate = (Date) tmp.get(3);

        System.out.println("TicketID " + ticketID + '\n' + "SeatID " + seatID + '\n' + "TicketCode " + ticketCode);

        List<Object> seatTmp = Seats.getSeatById(seatID);
        int flightID = (int) seatTmp.get(1);
        String seatClass = (String) seatTmp.get(2);
        String position = (String) seatTmp.get(3);
        double seatprice = (double) seatTmp.get(5);

        // keo Seat
        Seat seat = new Seat();
        seat.setSeatID(seatID);
        seat.setPosition(position);
        seat.setPrice(seatprice);
        seat.setClass(seatClass);

        // keo Flight
        List<Object> flightTmp = Flights.getFlightById(flightID);
        Flight flight = new Flight();
        flight.setFlightID((int) flightTmp.get(0));
        flight.setDepartureTime((Date) flightTmp.get(1));
        flight.setArrivalTime((Date) flightTmp.get(2));

        int planeID = (int) flightTmp.get(3);
        Plane plane = Planes.getPlaneById(planeID);
        flight.setPlane(plane);

        int departureAirportID = (int) flightTmp.get(4);
        Airport DepartureAirport = Airports.getAirportByID(departureAirportID);
        flight.setDepartureAirport(DepartureAirport);

        int arrivalAirportID = (int) flightTmp.get(5);
        Airport ArrivalAirport = Airports.getAirportByID(arrivalAirportID);
        flight.setArrivalAirport(ArrivalAirport);

        Passenger passenger = Passengers.getPassengerByID(passengerID);
        Ticket t = new Ticket(passenger, seat, flight, reservationDate);
        t.setTicketCode(ticketCode);
        t.setTicketID(ticketID);

        return t;
    }

    public static ArrayList<Integer> getPassIDs(int userID) {
        return Passengers.getPassengerIdsByUserId(userID);
    }

    public static boolean CancelTicket(int passengerID) {
        return Tickets.deleteTicket(passengerID);
    }
}