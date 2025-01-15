package com.user.model;

public class Farmer {

    private int farmerId;  // Corresponds to farmer_id in the table
    private String name;   // Corresponds to name in the table
    private String contactInfo; // Corresponds to contact_info in the table

    // Default constructor
    public Farmer() {
    }

    // Parameterized constructor
    public Farmer(int farmerId, String name, String contactInfo) {
        this.farmerId = farmerId;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    // Getter and Setter for farmerId
    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for contactInfo
    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    // Override toString() method for displaying Farmer's details
    @Override
    public String toString() {
        return "Farmer [farmerId=" + farmerId + ", name=" + name + ", contactInfo=" + contactInfo + "]";
    }
}
