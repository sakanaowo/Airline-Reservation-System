package System;

import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationManager {
    private List<Reservation> reservations;

    // Constructor
    public ReservationManager() {
        reservations = new ArrayList<>();// sẽ có chỉnh sửa
    }

    // tạo chỗ mới
    public Reservation createReservation(Passenger passenger, Flight flight) {
        Reservation reservation = new Reservation(passenger, flight);
        reservations.add(reservation);
        System.out.println("Reservation created " + reservation.getReservationID());
        return reservation;
    }

    // tìm kiếm đặt chỗ theo ID
    public Optional<Reservation> getReservationByID(int reservationID) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationID() == reservationID) return Optional.of(reservation);
        }
        return Optional.empty();
    }

    // xác nhận đặt chỗ
    public boolean confirmReservation(int ReservationID, Ticket ticket) {
        Optional<Reservation> reservationOPT = getReservationByID(ReservationID);
        if (reservationOPT.isPresent()) {
            Reservation reservation = reservationOPT.get();
            reservation.confirmReservation(ticket);
            System.out.println("Reservation " + reservation.getReservationID() + " confirmed");
            return true;
        } else {
            System.out.println("Reservation not found");
            return false;
        }
    }

    // hủy đặt chỗ
    public boolean cancelReservation(int ReservationID) {
        Optional<Reservation> reservationOPT = getReservationByID(ReservationID);
        if (reservationOPT.isPresent()) {
            Reservation reservation = reservationOPT.get();
            reservation.cancelReservation();
            System.out.println("Reservation " + reservation.getReservationID() + " cancelled");
            return true;
        } else {
            System.out.println("Reservation not found");
            return false;
        }
    }

    // hiển thị tất cả chỗ đặt (admin only)
    public void showAllReservations() {
        if (reservations.isEmpty()) System.out.println("No reservations found");
        else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }

    // hiển thị đặt chỗ (client)
    public void showReservationForPassenger(Passenger passenger) {
        boolean found = false;
        for (Reservation reservation : reservations) {
            if (reservation.getPassenger().equals(passenger)) {
                System.out.println(reservation);
                found = true;
            }
        }
        if (!found) System.out.println("No reservations found");
    }
}