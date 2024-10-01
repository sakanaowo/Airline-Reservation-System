package Models;

public class Passenger {
    private String name, birthDate, ethnicity, ID;

    public Passenger(String name, String birthDate, String ethnicity, String ID) {
        this.name = name;
        this.birthDate = birthDate;
        this.ethnicity = ethnicity;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEthnicity() {
        return ethnicity;
    }
}
