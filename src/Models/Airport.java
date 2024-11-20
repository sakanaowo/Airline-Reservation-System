package Models;

public class Airport {
    private String AirportName, City, AirportCode;
    private int AirportID;

    public Airport(String AirportName, String City, String APC) {
        this.AirportName = AirportName;
        this.City = City;
        this.AirportCode = APC;
    }

    public Airport() {}

    public String getAirportName() {
        return AirportName;
    }

    public void setAirportName(String AirportName) {
        this.AirportName = AirportName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getAirportCode() {
        return AirportCode;
    }

    public void setAirportCode(String Country) {
        this.AirportCode = Country;
    }

    public int getAirportID() {
        return AirportID;
    }

    public void setAirportID(int airportID) {
        this.AirportID = airportID;
    }
}
