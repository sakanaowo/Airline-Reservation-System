package UI;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, String> users;

    public UserManager() {
        users = new HashMap<>();
        loadUsers();
    }

    public boolean isValidUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public void addUser(String username, String password) {
        users.put(username, password);
        saveUsers();
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split(" ");
                users.put(userInfo[0], userInfo[1].trim());
            }
        } catch (IOException e) {
            System.out.println("Could not load users: " + e.getMessage());
        }
    }

    private void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"))) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Could not save users: " + e.getMessage());
        }
    }
}
