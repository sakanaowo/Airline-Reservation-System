package System;

import Models.Flight;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightManager {
    private List<Flight> flights;

    // Constructor khởi tạo danh sách chuyến bay
    public FlightManager() {
        this.flights = new ArrayList<>();
    }

    // Thêm chuyến bay mới vào danh sách
    public void addFlight(Flight flight) {
        flights.add(flight);
        System.out.println("Flight added: " + flight.getFlightID());
    }

    // Tìm kiếm chuyến bay theo flightID
    public Optional<Flight> getFlightByID(int flightID) {
        for (Flight flight : flights) {
            if (flight.getFlightID().equals(flightID)) {
                return Optional.of(flight);
            }
        }
        return Optional.empty(); // Không tìm thấy chuyến bay
    }

    // Tìm kiếm chuyến bay theo tiêu chí: thời gian và địa điểm (tùy chỉnh thêm tiêu chí khác)
    public List<Flight> searchFlights(LocalDateTime departureTime, String destination) {
        List<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDepartureTime().equals(departureTime) && flight.getDestination().equals(destination)) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }

    // Hiển thị tất cả chuyến bay hiện có
    public void showAllFlights() {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            for (Flight flight : flights) {
                System.out.println(flight);
            }
        }
    }

    // Cập nhật trạng thái chuyến bay (ví dụ: DELAYED, ON-TIME, CANCELLED)
//    public boolean updateFlightStatus(String flightID, String status) {
//        Optional<Flight> flightOpt = getFlightByID(flightID);
//        if (flightOpt.isPresent()) {
//            Flight flight = flightOpt.get();
//            flight.setStatus(status);
//            System.out.println("Flight " + flightID + " status updated to " + status);
//            return true;
//        } else {
//            System.out.println("Flight " + flightID + " not found.");
//            return false;
//        }
//    }

    // Hủy chuyến bay và loại bỏ khỏi danh sách
    public boolean cancelFlight(String flightID) {
        Optional<Flight> flightOpt = getFlightByID(flightID);
        if (flightOpt.isPresent()) {
            flights.remove(flightOpt.get());
            System.out.println("Flight " + flightID + " has been cancelled.");
            return true;
        } else {
            System.out.println("Flight " + flightID + " not found.");
            return false;
        }
    }

    // Kiểm tra tình trạng ghế ngồi cho một chuyến bay
    public void checkSeatAvailability(String flightID) {
        Optional<Flight> flightOpt = getFlightByID(flightID);
        if (flightOpt.isPresent()) {
            Flight flight = flightOpt.get();
            flight.showSeatMatrix();
        } else {
            System.out.println("Flight " + flightID + " not found.");
        }
    }
}
