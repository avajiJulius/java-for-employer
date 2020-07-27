package edu.java.example.jdbc.domain;

public class Street {

    private City city;
    private Long streetId;
    private String streetName;

    public Street() {
    }

    public Street(City city, Long streetId, String streetName) {
        this.city = city;
        this.streetId = streetId;
        this.streetName = streetName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public String toString() {
        return city + "," + streetName + "(" + streetId + ")" + ", ";
    }
}
