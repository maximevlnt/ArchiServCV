package fr.insa.soap;

import javax.jws.WebService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "UserService")
public class UserServiceImpl implements UserService {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test_db";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "password"; // replace with your MySQL password

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT id, username, email FROM users");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {po
                users.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("email")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getUserById(int id) {
        User user = null;
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT id, username, email FROM users WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("email"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public String addUser(String username, String email) {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO users (username, email) VALUES (?, ?)")) {
            ps.setString(1, username);
            ps.setString(2, email);
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                return "User added successfully!";
            } else {
                return "Failed to add user.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while adding user.";
        }
    }
}