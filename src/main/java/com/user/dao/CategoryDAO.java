package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.model.Category;

public class CategoryDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/agricart";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";

    private static final String INSERT_CATEGORY_SQL = "INSERT INTO Category (categoryName) VALUES (?);";
    private static final String SELECT_CATEGORY_BY_ID = "SELECT * FROM Category WHERE categoryId = ?;";
    private static final String SELECT_ALL_CATEGORIES = "SELECT * FROM Category;";
    private static final String DELETE_CATEGORY_SQL = "DELETE FROM Category WHERE categoryId = ?;";
    private static final String UPDATE_CATEGORY_SQL = "UPDATE Category SET categoryName = ? WHERE categoryId = ?;";

    public CategoryDAO() {}

    // Get database connection
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return connection;
    }

    // Insert a category
    public void insertCategory(Category category) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY_SQL)) {
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insert error: " + e.getMessage());
        }
    }

    // Select a category by ID
    public Category selectCategory(Long categoryId) {
        Category category = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID)) {
            preparedStatement.setLong(1, categoryId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setCategoryId(rs.getLong("categoryId"));
                category.setCategoryName(rs.getString("categoryName"));
            }
        } catch (SQLException e) {
            System.err.println("Select error: " + e.getMessage());
        }
        return category;
    }

    // Select all categories
    public List<Category> selectAllCategories() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryId(rs.getLong("categoryId"));
                category.setCategoryName(rs.getString("categoryName"));
                categories.add(category);
            }
        } catch (SQLException e) {
            System.err.println("Select all error: " + e.getMessage());
        }
        return categories;
    }

    // Update a category
    public boolean updateCategory(Category category) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORY_SQL)) {
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.setLong(2, category.getCategoryId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Update error: " + e.getMessage());
        }
        return rowUpdated;
    }

    // Delete a category
    public boolean deleteCategory(Long categoryId) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORY_SQL)) {
            preparedStatement.setLong(1, categoryId);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Delete error: " + e.getMessage());
        }
        return rowDeleted;
    }
}
