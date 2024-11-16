package System;

import DataHandle.Data.Flights;
import Models.Flight;
import Models.Airport;
import Models.Plane;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static DataHandle.Data.Planes.getPlaneById;

public class FlightManager {

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

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
    public ArrayList<Flight> getFlights(String departureTime, String arrivalTime, String planeID,
                                        String departureCity, String arrivalCity) {
        ArrayList<Flight> flightList = new ArrayList<>();

        // Retrieve data from Flights (Data Layer)
        ArrayList<ArrayList<Object>> flightData = Flights.viewFlight(
                departureTime, arrivalTime, planeID, departureCity, arrivalCity
        );

        // Convert data into Flight objects
        for (ArrayList<Object> row : flightData) {
            try {
                int flightID = (int) row.get(0);
                Date depTime = new Date(((Timestamp) row.get(1)).getTime());
                Date arrTime = new Date(((Timestamp) row.get(2)).getTime());
                int planeId = (int) row.get(3);
                String departureAirportName = (String) row.get(4);
                String arrivalAirportName = (String) row.get(5);
                String departureCityName = (String) row.get(6);
                String arrivalCityName = (String) row.get(7);

                // Create Plane and Airport objects (you may need to fetch more details if necessary)
                Plane plane = getPlaneById(planeId);
                Airport departureAirport = new Airport(-1, departureAirportName, departureCityName);
                Airport arrivalAirport = new Airport(-1, arrivalAirportName, arrivalCityName);

                // Create Flight object
                Flight flight = new Flight(depTime, arrTime, plane, arrivalAirport, departureAirport);
                flightList.add(flight);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return flightList;
    }

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
            System.err.println("Invalid date format. Please use 'dd/MM/yyyy HH:mm'.");
            return false;
        }
    }
}
