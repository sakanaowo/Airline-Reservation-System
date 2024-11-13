/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package airline_project;

import static airline_project.MyJDBC.viewFlight;
import static airline_project.MyJDBC.viewPlane;
import java.util.Scanner;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class Airline_project {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter Flight ID: ");
//        int flightID = scanner.nextInt();
//
//        System.out.print("Enter number of Economy seats: ");
//        int numEconomySeats = scanner.nextInt();
//
//        System.out.print("Enter Economy seat price: ");
//        double economyPrice = scanner.nextDouble();
//
//        System.out.print("Enter number of Business seats: ");
//        int numBusinessSeats = scanner.nextInt();
//
//        System.out.print("Enter Business seat price: ");
//        double businessPrice = scanner.nextDouble();
//
//        System.out.print("Enter Admin Name (updatedBy): ");
//        scanner.nextLine(); // Consume newline
//        String updatedBy = scanner.nextLine();
//
//        boolean success = MyJDBC.insertSeats(flightID, numEconomySeats, economyPrice, 
//                numBusinessSeats, businessPrice, updatedBy);
//
//        System.out.println("Insertion " + (success ? "successful" : "failed"));

//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//            System.out.print("Enter departure time (yyyy-MM-dd HH:mm:ss): ");
//            String departureTimeString = scanner.nextLine();
//            Timestamp departureTime = new Timestamp(dateFormat.parse(departureTimeString).getTime());
//
//            System.out.print("Enter arrival time (yyyy-MM-dd HH:mm:ss): ");
//            String arrivalTimeString = scanner.nextLine();
//            Timestamp arrivalTime = new Timestamp(dateFormat.parse(arrivalTimeString).getTime());
//
//            System.out.print("Enter Plane ID: ");
//            int planeID = scanner.nextInt();
//
//            System.out.print("Enter Departure Airport ID: ");
//            int departureAirportID = scanner.nextInt();
//
//            System.out.print("Enter Arrival Airport ID: ");
//            int arrivalAirportID = scanner.nextInt();
//
//            System.out.print("Enter Admin Name (updatedBy): ");
//            scanner.nextLine(); // Consume newline
//            String updatedBy = scanner.nextLine();
//
//            boolean success = MyJDBC.insertFlight(departureTime, arrivalTime, planeID, 
//                    departureAirportID, arrivalAirportID, updatedBy);
//
//            System.out.println("Flight insertion " + (success ? "successful" : "failed"));
//        } catch (Exception e) {
//            System.err.println("Error parsing input: " + e.getMessage());
//            e.printStackTrace();
//        }
        ArrayList<ArrayList<Object>> planes = viewPlane();
    
        for (ArrayList<Object> plane : planes) {
            System.out.println("PlaneID: " + plane.get(0));
            System.out.println("Model: " + plane.get(1));
            System.out.println("Seats: " + plane.get(2));
            System.out.println("----------");
        }
//        System.out.println("Test Case 1: Filter by DepartureTime and ArrivalAirportName");
//        ArrayList<ArrayList<Object>> flights = viewFlight("2024-11-01 10:00:00", "", "", "", "Los Angeles");
//        for (ArrayList<Object> flight : flights) {
//            System.out.println("FlightID: " + flight.get(0) + ", DepartureTime: " + flight.get(1) + 
//                ", ArrivalTime: " + flight.get(2) + ", PlaneID: " + flight.get(3) + 
//                ", DepartureAirportName: " + flight.get(4) + ", ArrivalAirportName: " + flight.get(5));
//        }

//        System.out.println("\nTest Case 2: Filter by PlaneID and DepartureAirportName");
//        ArrayList<ArrayList<Object>> flights2 = viewFlight("", "", "1", "Ha Noi", "");
//        for (ArrayList<Object> flight : flights2) {
//            System.out.println("FlightID: " + flight.get(0) + ", DepartureTime: " + flight.get(1) + 
//                ", ArrivalTime: " + flight.get(2) + ", PlaneID: " + flight.get(3) + 
//                ", DepartureAirportName: " + flight.get(4) + ", ArrivalAirportName: " + flight.get(5));
//        }

//        System.out.println("\nTest Case 3: No filters (view all flights)");
//        ArrayList<ArrayList<Object>> allFlights = viewFlight("", "", "", "", "");
//        for (ArrayList<Object> flight : allFlights) {
//            System.out.println("FlightID: " + flight.get(0) + ", DepartureTime: " + flight.get(1) + 
//                ", ArrivalTime: " + flight.get(2) + ", PlaneID: " + flight.get(3) + 
//                ", DepartureAirportName: " + flight.get(4) + ", ArrivalAirportName: " + flight.get(5));
//        }
//        boolean insertfilght = MyJDBC.insertFlight(Timestamp.valueOf("2024-11-15 08:00:00"), 
//                Timestamp.valueOf("2024-11-15 10:30:00"), 3, "Da Nang", "Phu Quoc", "thinh");
        
    }
}

