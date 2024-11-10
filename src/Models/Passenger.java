package Models;

public class Passenger {
    private int PassengerID;
    private String LastName, FirstName;
    int UserID;
    private String PhoneNumber, CitizenIdentificationNumber;

    public Passenger(String FirstName, String LastName, int UserID, String PhoneNumber, String CitizenIdentificationNumber) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.UserID = UserID;
        this.PhoneNumber = PhoneNumber;
        this.CitizenIdentificationNumber = CitizenIdentificationNumber;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getCitizenID() {
        return CitizenIdentificationNumber;
    }

    public void setCitizenID(String PassengerID) {
        this.CitizenIdentificationNumber = PassengerID;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getName() {
        return FirstName + " " + LastName;
    }
}