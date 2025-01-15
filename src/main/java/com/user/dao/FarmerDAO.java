package com.user.dao;

import com.user.model.Farmer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FarmerDAO {

    private Connection connection;

    // Constructor to initialize the connection
    public FarmerDAO(Connection connection) {
        this.connection = connection;
    }

    // Create a new farmer record in the database
    public boolean addFarmer(Farmer farmer) {
        String query = "INSERT INTO Farmers (name, contact_info) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, farmer.getName());
            statement.setString(2, farmer.getContactInfo());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve a farmer by ID
    public Farmer getFarmerById(int farmerId) {
        String query = "SELECT * FROM Farmers WHERE farmer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, farmerId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Farmer(
                    resultSet.getInt("farmer_id"),
                    resultSet.getString("name"),
                    resultSet.getString("contact_info")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Retrieve all farmers
    public List<Farmer> getAllFarmers() {
        List<Farmer> farmers = new ArrayList<>();
        String query = "SELECT * FROM Farmers";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                farmers.add(new Farmer(
                    resultSet.getInt("farmer_id"),
                    resultSet.getString("name"),
                    resultSet.getString("contact_info")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return farmers;
    }

    // Update an existing farmer's details by ID
    public boolean updateFarmer(Farmer farmer) {
        String query = "UPDATE Farmers SET name = ?, contact_info = ? WHERE farmer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, farmer.getName());
            statement.setString(2, farmer.getContactInfo());
            statement.setInt(3, farmer.getFarmerId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete a farmer record by ID
    public boolean deleteFarmer(int farmerId) {
        String query = "DELETE FROM Farmers WHERE farmer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, farmerId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
