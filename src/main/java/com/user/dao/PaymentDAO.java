package com.user.dao;

import com.user.model.Payment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    private Connection connection;

    // Constructor to initialize the connection
    public PaymentDAO(Connection connection) {
        this.connection = connection;
    }

    // Create a new payment record in the database
    public boolean addPayment(Payment payment) {
        String query = "INSERT INTO Payments (amount, paymentDate, paymentMethod, transactionStatus) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, payment.getAmount());
            statement.setInt(2, payment.getPaymentDate());
            statement.setString(3, payment.getPaymentMethod());
            statement.setString(4, payment.getTransactionStatus());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve a payment by ID
    public Payment getPaymentById(Long paymentId) {
        String query = "SELECT * FROM Payments WHERE paymentId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, paymentId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Payment(
                    resultSet.getLong("paymentId"),
                    resultSet.getDouble("amount"),
                    resultSet.getInt("paymentDate"),
                    resultSet.getString("paymentMethod"),
                    resultSet.getString("transactionStatus")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Retrieve all payments
    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        String query = "SELECT * FROM Payments";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                payments.add(new Payment(
                    resultSet.getLong("paymentId"),
                    resultSet.getDouble("amount"),
                    resultSet.getInt("paymentDate"),
                    resultSet.getString("paymentMethod"),
                    resultSet.getString("transactionStatus")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    // Update an existing payment's details by ID
    public boolean updatePayment(Payment payment) {
        String query = "UPDATE Payments SET amount = ?, paymentDate = ?, paymentMethod = ?, transactionStatus = ? WHERE paymentId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, payment.getAmount());
            statement.setInt(2, payment.getPaymentDate());
            statement.setString(3, payment.getPaymentMethod());
            statement.setString(4, payment.getTransactionStatus());
            statement.setLong(5, payment.getPaymentId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete a payment record by ID
    public boolean deletePayment(Long paymentId) {
        String query = "DELETE FROM Payments WHERE paymentId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, paymentId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
