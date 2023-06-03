package org.itacademy.homework3.models;

public class Address {
    private String street;
    private String building;

    public Address(String street, String building) {
        this.street = street;
        this.building = building;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
}
