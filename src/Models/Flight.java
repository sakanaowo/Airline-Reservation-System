/*
Flight chịu trách nhiệm về việc cung cấp chỗ ngồi và quản lý trạng thái các ghế (có thể đặt hoặc đã đặt).
 không cần khởi tạo sẵn đối tượng Reservation bên trong Flight vì Flight chỉ cần biết ghế nào đã được đặt,
  không cần biết ai đặt và khi nào.
*/
package Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Flight {
    private String flightID;
    private String origin;
    private String destination;
    private String departureTime;// dd/MM/yyyy format
    private String arrivalTime;// dd/MM/yyyy format
    private String[][] seatMap; // Ma trận chỗ ngồi
    private double price = 103.58;//default price (dollar unit)
    private int rows = 6;
    private int columns = 30;
    private String status;
 
    // Constructor để khởi tạo chuyến bay
    public Flight(String flightID, String origin, String destination, String departureTime, String arrivalTime) {
        this.flightID = flightID;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.rows = rows;
        this.columns = columns;
        this.seatMap = new String[rows][columns];

        // Khởi tạo ma trận chỗ ngồi với tất cả ghế là trống (ví dụ: "A", "B", "C"... theo thứ tự ký tự)
        char seatRow = 'A';
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seatMap[i][j] = String.valueOf(seatRow) + (j + 1);
            }
            seatRow++;
        }
    }

    // Getter cho flightID
    public String getFlightID() {
        return flightID;
    }

    // Hiển thị ma trận chỗ ngồi
    public void displaySeatMap() {
        System.out.println("Seat map for flight " + flightID + ":");
        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(seatMap[i]));
        }
    }

    // Phương thức để đặt chỗ ngồi
    public boolean reserveSeat(String seat) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (seatMap[i][j].equals(seat)) {
                    seatMap[i][j] = "X"; // Đánh dấu ghế là đã đặt
                    System.out.println("Seat " + seat + " has been reserved on flight " + flightID);
                    return true;
                }
            }
        }
        System.out.println("Seat " + seat + " is not available on flight " + flightID);
        return false;
    }

    // Phương thức để giải phóng chỗ ngồi (khi hủy đặt chỗ)
    public boolean releaseSeat(String seat) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (seatMap[i][j].equals("X") && seat.equals(String.valueOf((char) ('A' + i)) + (j + 1))) {
                    seatMap[i][j] = seat; // Khôi phục ghế trở lại trạng thái ban đầu
                    System.out.println("Seat " + seat + " has been released on flight " + flightID);
                    return true;
                }
            }
        }
        System.out.println("Seat " + seat + " was not reserved or does not exist on flight " + flightID);
        return false;
    }

    // Hiển thị thông tin chuyến bay
    @Override
    public String toString() {
        return "Flight ID: " + flightID + ", Origin: " + origin + ", Destination: " + destination +
                ", Departure: " + departureTime + ", Arrival: " + arrivalTime;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getDepartureTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDateTime.parse(departureTime, formatter);
    }

    public String getDestination() {
        return destination;
    }

    public void showSeatMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println(seatMap[i][j] + " ");
            }
        }
    }

    public void setStatus(boolean status) {
         if(status) this.status = "May bay da cat canh";
         else this.status = "May bay dang o duong bang";
    }
}
