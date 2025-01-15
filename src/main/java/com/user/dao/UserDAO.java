package com.user.dao;

import com.user.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/Agricart"; 
    private final String jdbcUsername = "root"; 
    private final String jdbcPassword = "YES";

  
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Create a new user record in the database
    public boolean addUser(User user) {
        String query = "INSERT INTO Users (name, email, password, address, phone_no) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getPhoneNo());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

  
    public User getUserById(int id) {
        String query = "SELECT * FROM Users WHERE user_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getLong("user_id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("address"),
                        resultSet.getString("phone_no"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM Users";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getLong("user_id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("address"),
                        resultSet.getString("phone_no"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

 
    public boolean updateUser(User user) {
        String query = "UPDATE Users SET name = ?, email = ?, password = ?, address = ?, phone_no = ?, updated_at = CURRENT_TIMESTAMP WHERE user_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getPhoneNo());
            statement.setLong(6, user.getUserId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean deleteUser(Long userId) {
        String query = "DELETE FROM Users WHERE user_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, userId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
