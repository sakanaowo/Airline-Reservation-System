/*
Flight chịu trách nhiệm về việc cung cấp chỗ ngồi và quản lý trạng thái các ghế (có thể đặt hoặc đã đặt).
 không cần khởi tạo sẵn đối tượng Reservation bên trong Flight vì Flight chỉ cần biết ghế nào đã được đặt,
  không cần biết ai đặt và khi nào.
*/
package Models;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

public class Flight {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private int flightID;
    private Date DepartureTime, ArrivalTime;
    Plane plane;
    Airport ArrivalAirport, DepartureAirport;

    public Flight(Date DepartureTime, Date ArrivalTime, Plane plane, Airport ArrivalAirport, Airport DepartureAirport) {
        this.DepartureTime = DepartureTime;
        this.ArrivalTime = ArrivalTime;
        this.plane = plane;
        this.ArrivalAirport = ArrivalAirport;
        this.DepartureAirport = DepartureAirport;
    }

    public int getFlightID() {
        return flightID;
    }

    public int getPlaneID() {
        return plane.getPlaneID();
    }

    public String getDepartureTime() {
        return formatter.format(DepartureTime);
    }

    public void setDepartureTime(Date DepartureTime) {
        this.DepartureTime = DepartureTime;
    }

    public String getArrivalTime() {
        return formatter.format(ArrivalTime);
    }

    public void setArrivalTime(Date ArrivalTime) {
        this.ArrivalTime = ArrivalTime;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Airport getArrivalAirport() {
        return ArrivalAirport;
    }

    public void setArrivalAirport(Airport ArrivalAirport) {
        this.ArrivalAirport = ArrivalAirport;
    }

    public Airport getDepartureAirport() {
        return DepartureAirport;
    }

    public void setDepartureAirport(Airport DepartureAirport) {
        this.DepartureAirport = DepartureAirport;
    }

}