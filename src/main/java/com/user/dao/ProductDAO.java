package com.user.dao;

import com.user.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private Connection connection;

    // Constructor to initialize the connection
    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    // Create a new product record in the database
    public boolean addProduct(Product product) {
        String query = "INSERT INTO Products (name, description, price, stockQuantity) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getStockQuantity());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve a product by ID
    public Product getProductById(Long productId) {
        String query = "SELECT * FROM Products WHERE productId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, productId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Product(
                    resultSet.getLong("productId"),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getDouble("price"),
                    resultSet.getInt("stockQuantity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Retrieve all products
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Products";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                products.add(new Product(
                    resultSet.getLong("productId"),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getDouble("price"),
                    resultSet.getInt("stockQuantity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // Update an existing product's details by ID
    public boolean updateProduct(Product product) {
        String query = "UPDATE Products SET name = ?, description = ?, price = ?, stockQuantity = ? WHERE productId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getStockQuantity());
            statement.setLong(5, product.getProductId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete a product record by ID
    public boolean deleteProduct(Long productId) {
        String query = "DELETE FROM Products WHERE productId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, productId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
