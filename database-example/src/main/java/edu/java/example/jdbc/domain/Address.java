package edu.java.example.jdbc.domain;

public class Address {
    private Long addressId;
    private City city;
    private Street street;
    private String building;


    public Address() {
    }

    public Address(Long addressId, City city, Street street, String building) {
        this.addressId = addressId;
        this.city = city;
        this.street = street;
        this.building = building;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
}
