package medilinker;

import java.sql.*;
import javax.swing.JOptionPane;

public class UserRegistration {
    private String username;
    private String password;
    private Connection conn;

    public UserRegistration() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/tellymedic360", "root", "Sinix@004");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void registerUser(String username, String password) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "User registered successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error registering user: " + e.getMessage());
        }
    }

    public boolean login(String username, String password) {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet result = stmt.executeQuery();
            return result.next(); //  This will Return true if login is successful, false otherwise
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error logging in: " + e.getMessage());
            return false;
        }
    }
}
//Class is responsible for managing the user registration and login processes
//it provides methods to register a new user by storing the username and password into the users table in the MySQL database
//The login method checks the provided username and password against the stored records n the users table to authenticate the user