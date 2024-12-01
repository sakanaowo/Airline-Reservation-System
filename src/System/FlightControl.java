package System;

import DataHandle.Data.Flights;
import DataHandle.Data.Seats;
import Models.Airport;
import Models.Flightxtended;
import Models.Plane;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static DataHandle.Data.Airports.*;
import static DataHandle.Data.Planes.getPlaneById;


public class FlightControl {
    // Method to view flights based on filters
    // 1 way
    public ArrayList<Flightxtended> UserFindFlight(Date depTime, String departureCity, String arrivalCity, int seatNumber) {
        ArrayList<Flightxtended> flightList = new ArrayList<>();
        String departureTime = new SimpleDateFormat("yyyy-MM-dd").format(depTime);

        // Retrieve data from Flights (Data Layer)
        ArrayList<ArrayList<Object>> flightData = Seats.viewSeatAvailableForPassenger(
                departureTime, departureCity, arrivalCity, seatNumber
        );

        if (flightData.isEmpty()) {
            System.out.println("Empty");
            return null;
        }
        System.out.println("not empty");

        // Convert data into Flight objects
        for (ArrayList<Object> row : flightData) {
            // Extract data from row
            int flightID = (int) row.get(0);
            Date departureTimeObj = new Date(((Timestamp) row.get(1)).getTime());
            Date arrivalTimeObj = new Date(((Timestamp) row.get(2)).getTime());
            int planeId = (int) row.get(3);
            String departureAirportName = (String) row.get(4);
            String arrivalAirportName = (String) row.get(5);
            String departureCityName = (String) row.get(6);
            String arrivalCityName = (String) row.get(7);
            int businessAvailableSeats = (int) row.get(8);
            int economyAvailableSeats = (int) row.get(9);

            // Check seat availability
            if (seatNumber > (businessAvailableSeats + economyAvailableSeats)) {
                continue; // Skip if there are not enough seats
            }

            // Create Plane and Airport objects
            Plane plane = getPlaneById(planeId);
            Airport departureAirport = getAirportByName(departureAirportName);
            Airport arrivalAirport = getAirportByName(arrivalAirportName);

            // Create Flight object
            Flightxtended flight = new Flightxtended(departureTimeObj, arrivalTimeObj, plane, arrivalAirport, departureAirport, economyAvailableSeats, businessAvailableSeats);
            flight.setFlightID(flightID);
            flightList.add(flight);
        }
        return flightList;
    }

    // Method to delete a flight by ID
    public boolean deleteFlight(int flightID) {
        return Flights.deleteFlight(flightID);
    }

}
