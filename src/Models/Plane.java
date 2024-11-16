package Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Plane {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private int planeID;
    private String Model;
    private int Seats;
    private int UpdatedBy;
    private Date UpdatedDate;

    public Plane(String Model, int Seats) {
        this.Model = Model;
        this.Seats = Seats;
    }

    public Plane(String Model, int Seats, int UpdatedBy, Date UpdatedDate) {
        this.Model = Model;
        this.Seats = Seats;
        this.UpdatedBy = UpdatedBy;
        this.UpdatedDate = UpdatedDate;
    }

    public int getPlaneID() {
        return planeID;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public int getSeats() {
        return Seats;
    }

    public void setSeats(int Seats) {
        this.Seats = Seats;
    }

    public int getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(int UpdatedBy) {
        this.UpdatedBy = UpdatedBy;
    }

    public Date getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(Date UpdatedDate) {
        this.UpdatedDate = UpdatedDate;
    }

    public String getFormattedUpdatedDate() {
        return sdf.format(UpdatedDate);
    }
}
