/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package airline_project;

import java.util.Scanner;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            System.out.print("Enter departure time (yyyy-MM-dd HH:mm:ss): ");
            String departureTimeString = scanner.nextLine();
            Timestamp departureTime = new Timestamp(dateFormat.parse(departureTimeString).getTime());

            System.out.print("Enter arrival time (yyyy-MM-dd HH:mm:ss): ");
            String arrivalTimeString = scanner.nextLine();
            Timestamp arrivalTime = new Timestamp(dateFormat.parse(arrivalTimeString).getTime());

            System.out.print("Enter Plane ID: ");
            int planeID = scanner.nextInt();

            System.out.print("Enter Departure Airport ID: ");
            int departureAirportID = scanner.nextInt();

            System.out.print("Enter Arrival Airport ID: ");
            int arrivalAirportID = scanner.nextInt();

            System.out.print("Enter Admin Name (updatedBy): ");
            scanner.nextLine(); // Consume newline
            String updatedBy = scanner.nextLine();

            boolean success = MyJDBC.insertFlight(departureTime, arrivalTime, planeID, 
                    departureAirportID, arrivalAirportID, updatedBy);

            System.out.println("Flight insertion " + (success ? "successful" : "failed"));
        } catch (Exception e) {
            System.err.println("Error parsing input: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

