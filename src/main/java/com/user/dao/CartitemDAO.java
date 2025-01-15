package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.model.Cartitem;

public class CartitemDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/agricart";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";

    private static final String INSERT_CARTITEM_SQL = "INSERT INTO CartItem (quantity) VALUES (?);";
    private static final String SELECT_CARTITEM_BY_ID = "SELECT * FROM CartItem WHERE cartItemId = ?;";
    private static final String SELECT_ALL_CARTITEMS = "SELECT * FROM CartItem;";
    private static final String UPDATE_CARTITEM_SQL = "UPDATE CartItem SET quantity = ? WHERE cartItemId = ?;";
    private static final String DELETE_CARTITEM_SQL = "DELETE FROM CartItem WHERE cartItemId = ?;";

    public CartitemDAO() {}

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Insert a new cart item
    public void insertCartitem(Cartitem cartitem) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CARTITEM_SQL)) {
            preparedStatement.setInt(1, cartitem.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select a cart item by ID
    public Cartitem selectCartitem(Long cartItemId) {
        Cartitem cartitem = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CARTITEM_BY_ID)) {
            preparedStatement.setLong(1, cartItemId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                cartitem = new Cartitem();
                cartitem.setCartItemId(rs.getLong("cartItemId"));
                cartitem.setQuantity(rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartitem;
    }

    // Select all cart items
    public List<Cartitem> selectAllCartitems() {
        List<Cartitem> cartitems = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CARTITEMS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Cartitem cartitem = new Cartitem();
                cartitem.setCartItemId(rs.getLong("cartItemId"));
                cartitem.setQuantity(rs.getInt("quantity"));
                cartitems.add(cartitem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartitems;
    }

    // Update a cart item
    public boolean updateCartitem(Cartitem cartitem) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CARTITEM_SQL)) {
            preparedStatement.setInt(1, cartitem.getQuantity());
            preparedStatement.setLong(2, cartitem.getCartItemId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    // Delete a cart item by ID
    public boolean deleteCartitem(Long cartItemId) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CARTITEM_SQL)) {
            preparedStatement.setLong(1, cartItemId);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
