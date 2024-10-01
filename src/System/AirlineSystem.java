package System;

import Models.*;

import java.util.ArrayList;
import java.util.List;

public class AirlineSystem {
    private List<Flight> flights;
    private List<User> users;
    private List<Reservation> reservations;

    public AirlineSystem() {
        flights = new ArrayList<Flight>();
        users = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
        System.out.println("Flight added: " + flight.getFlightID());
    }

    public void displayFlights() {
        if (flights.isEmpty()) System.out.println("No flights available.");
        else {
            for (Flight flight : flights) System.out.println(flight);
        }
    }

    public User createUser(String account, String password, Passenger passenger) {
        User newUser = new User(account, password, passenger, new ArrayList<>());
        users.add(newUser);
        System.out.println("User created: " + account);
        return newUser;
    }

    public Reservation createReservation(User user, Flight flight, String seat) {
        if (flight.reserveSeat(seat)) {
            Reservation reservation = new Reservation(user.getPassenger(), flight);
            Ticket ticket = new Ticket(user.getPassenger(), flight, seat, flight.getPrice());
            reservation.confirmReservation(ticket);
            user.addTicket(ticket);
            reservations.add(reservation);
            System.out.println("Reservation created for user : " + user);
            return reservation;
        } else {
            System.out.println("Seat" + seat + " already occupied.");
            return null;
        }
    }

    public void cancelReservation(User user, Reservation reservation) {
        if (reservation != null) {
            reservation.cancelReservation();
            user.removeTicket(reservation.getTicket());
            reservations.remove(reservation);
            System.out.println("Reservation cancelled for user : " + user);
        } else {
            System.out.println("No reservation found to cancel.");
        }
    }

    public Flight findFlightByID(String flightID) {
        for (Flight flight : flights) {
            if (flight.getFlightID().equals(flightID)) return flight;
        }
        return null;
    }

    public User findUserByAccount(String account) {
        for (User user : users) {
            if (user.getAccount().equals(account)) return user;
        }
        return null;
    }

    public void MakeReservation(User user, String flightID, String seat) {
        Flight flight = findFlightByID(flightID);
        if (flight != null) {
            createReservation(user, flight, seat);
        } else {
            System.out.println("Flight not found.");
        }
    }
}
