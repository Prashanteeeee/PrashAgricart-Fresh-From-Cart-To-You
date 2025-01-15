package com.user;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.user.dao.UserDAO;
import com.user.model.User;

class UserDAOTest {

    UserDAO userDAO = new UserDAO();

   
    @Test
    void selectUser_testcase1() {
        User user = userDAO.getUserById(1);
        assertNotNull(user, "User should not be null.");
    }

   
    @Test
    void selectUser_testcase2() {
        User user = userDAO.getUserById(1);
        assertNotNull(user, "User with ID 1 should be present.");
        assertEquals("john@example.com", user.getEmail(), "Email should match the expected value.");
    }

   
    @Test
    void addUser_testcase1() {
        User newUser = new User(null, "Alice", "alice@example.com", "password123", "1234 Elm St.", "9876543210", null, null);
        boolean isAdded = userDAO.addUser(newUser);
        assertTrue(isAdded, "User should be added successfully.");
    }

    
    @Test
    void addUser_testcase2() {
        User newUser = new User(null, "Alice", "john@example.com", "password123", "1234 Elm St.", "9876543210", null, null);
        boolean isAdded = userDAO.addUser(newUser);
        assertFalse(isAdded, "User with an existing email should not be added.");
    }

   
    @Test
    void updateUser_testcase1() {
        User user = userDAO.getUserById(1);
        assertNotNull(user, "User should exist before updating.");
        
        user.setName("John Updated");
        user.setPhoneNo("1234567890");
        
        boolean isUpdated = userDAO.updateUser(user);
        assertTrue(isUpdated, "User should be updated successfully.");
        
        // Verify the update
        User updatedUser = userDAO.getUserById(1);
        assertEquals("John Updated", updatedUser.getName(), "Name should be updated.");
        assertEquals("1234567890", updatedUser.getPhoneNo(), "Phone number should be updated.");
    }

   
    @Test
    void deleteUser_testcase1() {
        boolean isDeleted = userDAO.deleteUser(1L);
        assertTrue(isDeleted, "User should be deleted successfully.");
        
        // Verify deletion
        User deletedUser = userDAO.getUserById(1);
        assertNull(deletedUser, "Deleted user should not be found.");
    }

   
    @Test
    void getAllUsers_testcase1() {
        List<User> users = userDAO.getAllUsers();
        assertNotNull(users, "Users list should not be null.");
        assertTrue(users.size() > 0, "There should be at least one user in the list.");
    }

    
    @Test
    void selectUser_testcase3() {
        User user = userDAO.getUserById(999);  // Assuming user with ID 999 doesn't exist
        assertNull(user, "User should be null if the ID does not exist.");
    }

}
