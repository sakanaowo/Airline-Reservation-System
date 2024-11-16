package Models;

public class Airport {
    private String AirportName, City, Country;
    private int AirportID;

    public Airport(String AirportName, String City, String Country) {
        this.AirportName = AirportName;
        this.City = City;
        this.Country = Country;
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

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public int getAirportID() {
        return AirportID;
    }

    public void setAirportID(int airportID) {
        this.AirportID = airportID;
    }
}
