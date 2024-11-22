package Models;
// chưa xong

import java.util.ArrayList;
import java.util.List;

public class User {
    private int UserID;
    private String account, password, email;

    public User(String account, String password, String email) {
        this.account = account;
        this.password = password;
        this.email = email;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public List<Passenger> getPassengers() {
//        return passengers;
//    }
//
//    public void addPassenger(Passenger passenger) {
//        this.passengers.add(passenger);
//    }
//
//    public void removePassenger(Passenger passenger) {
//        this.passengers.remove(passenger);
//    }
}
