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


public class FlightManager {

    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    // Method to add a new flight
    public boolean addFlight(String departureTime, String arrivalTime, int planeID,
                             String departureCity, String arrivalCity, String updatedBy) {
        try {
            Date depTime = formatter.parse(departureTime);
            Date arrTime = formatter.parse(arrivalTime);

            return Flights.insertFlight(
                    new Timestamp(depTime.getTime()),
                    new Timestamp(arrTime.getTime()),
                    planeID,
                    departureCity,
                    arrivalCity,
                    updatedBy
            );
        } catch (ParseException e) {
            System.err.println("Invalid date format. Please use 'dd/MM/yyyy HH:mm'.");
            return false;
        }
    }

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
            String flightID = (String) row.get(0);
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
            flightList.add(flight);
        }
        return flightList;
    }

//    public static void main(String[] a) {
//        ArrayList<ArrayList<Object>> flightData = Seats
//                .viewSeatAvailableForPassenger("2024-11-26", "Quang Nam",
//                        "Thanh Hoa", 2);
//        System.out.println(flightData.size());
//        for (ArrayList<Object> row : flightData) {
//            System.out.println(row.get(0));
//            System.out.println(row.get(1));
//            System.out.println(row.get(2));
//            System.out.println(row.get(3));
//            System.out.println(row.get(4));
//            System.out.println(row.get(5));
//            System.out.println(row.get(6));
//            System.out.println(row.get(7));
//            System.out.println(row.get(8));
//        }
//    }


    // Method to delete a flight by ID
    public boolean deleteFlight(int flightID) {
        return Flights.deleteFlight(flightID);
    }

    public boolean updateFlight(int flightID, String newDepartureTime, String newArrivalTime, int newPlaneID,
                                String newDepartureCity, String newArrivalCity, String updatedBy) {
        try {
            Date newDepTime = formatter.parse(newDepartureTime);
            Date newArrTime = formatter.parse(newArrivalTime);

            return Flights.modifyFlight(
                    flightID,
                    new Timestamp(newDepTime.getTime()),
                    new Timestamp(newArrTime.getTime()),
                    newPlaneID,
                    newDepartureCity,
                    newArrivalCity,
                    updatedBy
            );
        } catch (ParseException e) {
            System.err.println("Invalid date format. Please use 'yyyy-MM-dd HH:mm'.");
            return false;
        }
    }
}
