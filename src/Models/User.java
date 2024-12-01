package Models;

public class User {
    private int UserID;
    private String account, password, email;

    public User(String account, String password, String email) {
        this.account = account;
        this.password = password;
        this.email = email;
    }
    public User(String account, String password, String email, int UserID) {
        this.account = account;
        this.password = password;
        this.email = email;
        this.UserID = UserID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

}
