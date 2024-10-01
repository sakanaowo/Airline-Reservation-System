/*
Reservation được tạo khi hành khách muốn đặt chỗ.
Đối tượng này sẽ quản lý thông tin hành khách, chuyến bay mà họ muốn đặt, và trạng thái đặt chỗ.
Khi hành khách xác nhận đặt chỗ, Reservation gọi phương thức reserveSeat của Flight để đánh dấu ghế ngồi là đã đặt.
*/

package Models;

import java.time.LocalDateTime;

public class Reservation {
    private static int reservationCounter = 0; // Đếm số lượng đặt chỗ
    private int reservationID;
    private Passenger passenger;
    private Flight flight;
    private Ticket ticket;
    private String status; // CONFIRMED, CANCELLED, PENDING
    private LocalDateTime reservationDate;

    // Constructor để tạo mới một đặt chỗ
    public Reservation(Passenger passenger, Flight flight) {
        this.reservationID = ++reservationCounter;
        this.passenger = passenger;
        this.flight = flight;
        this.status = "PENDING";
        this.reservationDate = LocalDateTime.now();
    }

    // Getter cho reservationID
    public int getReservationID() {
        return reservationID;
    }

    // Getter cho passenger
    public Passenger getPassenger() {
        return passenger;
    }

    // Getter cho flight
    public Flight getFlight() {
        return flight;
    }

    // Getter cho status
    public String getStatus() {
        return status;
    }

    // Getter cho reservationDate
    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    // Phương thức để xác nhận đặt chỗ
    public void confirmReservation(Ticket ticket) {
        this.ticket = ticket;
        this.status = "CONFIRMED";
        System.out.println("Reservation " + reservationID + " has been confirmed.");
    }

    // Phương thức để hủy đặt chỗ
    public void cancelReservation() {
        if ("CONFIRMED".equals(this.status)) {
            this.status = "CANCELLED";
            this.ticket.cancelTicket();  // Hủy vé nếu đã có
            System.out.println("Reservation " + reservationID + " has been cancelled.");
        } else {
            System.out.println("Reservation " + reservationID + " is not confirmed yet or already cancelled.");
        }
    }

    // Hiển thị thông tin đặt chỗ
    @Override
    public String toString() {
        return "Reservation ID: " + reservationID + ", Passenger: " + passenger.getName() +
                ", Flight: " + flight.getFlightID() + ", Status: " + status +
                ", Reservation Date: " + reservationDate;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
