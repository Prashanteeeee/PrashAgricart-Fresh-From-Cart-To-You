package com.user.dao;

import com.user.model.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    private Connection connection;

    // Constructor to initialize the connection
    public OrderDAO(Connection connection) {
        this.connection = connection;
    }

    // Create a new order record in the database
    public boolean addOrder(Order order) {
        String query = "INSERT INTO Orders (totalPrice, orderDate, deliveryStatus) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, order.getTotalPrice());
            statement.setInt(2, order.getOrderDate());
            statement.setString(3, order.getDeliveryStatus());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve an order by ID
    public Order getOrderById(Long orderId) {
        String query = "SELECT * FROM Orders WHERE orderId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, orderId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Order(
                    resultSet.getLong("orderId"),
                    resultSet.getDouble("totalPrice"),
                    resultSet.getInt("orderDate"),
                    resultSet.getString("deliveryStatus")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Retrieve all orders
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM Orders";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                orders.add(new Order(
                    resultSet.getLong("orderId"),
                    resultSet.getDouble("totalPrice"),
                    resultSet.getInt("orderDate"),
                    resultSet.getString("deliveryStatus")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    // Update an existing order's details by ID
    public boolean updateOrder(Order order) {
        String query = "UPDATE Orders SET totalPrice = ?, orderDate = ?, deliveryStatus = ? WHERE orderId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, order.getTotalPrice());
            statement.setInt(2, order.getOrderDate());
            statement.setString(3, order.getDeliveryStatus());
            statement.setLong(4, order.getOrderId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete an order record by ID
    public boolean deleteOrder(Long orderId) {
        String query = "DELETE FROM Orders WHERE orderId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, orderId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
