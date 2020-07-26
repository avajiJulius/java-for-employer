package edu.java.example.jdbc.dao;

import edu.java.example.jdbc.domain.City;
import edu.java.example.jdbc.domain.Street;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao{

    private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryDaoImpl.class);

    private static final String SHOW_CITIES = "SELECT * FROM jdbc_city";

    private static final String SHOW_STREETS = "SELECT street_id, street_name FROM jdbc_street " +
            "WHERE city_id = ? ";

    private static final String GET_CITY = "SELECT city_id, city_name FROM jdbc_city " +
            "WHERE UPPER(city_name) LIKE UPPER(?)";

    private static final String GET_STREET = "SELECT street_id, street_name FROM jdbc_street " +
            "WHERE city_id = ? AND UPPER(street_name) LIKE UPPER(?)";

    private Connection getConnection() throws SQLException {
        return ConnectionBuilder.getConnection();
    }

    @Override
    public List<City> showAllCities() {
        List<City> allCities = new ArrayList<>();

        try (Connection con = getConnection();
            Statement stmt = con.createStatement()) {

            ResultSet rs = stmt.executeQuery(SHOW_CITIES);
            while(rs.next()) {
                City city = new City();
                city.setCityId(rs.getLong("city_id"));
                city.setCityName(rs.getString("city_name"));
                allCities.add(city);
            }


        } catch (SQLException ex) {
            LOGGER.error("303", ex.getMessage());
            ex.printStackTrace();
        }
        return allCities;
    }

    @Override
    public List<City> findCity(String cityName) {
        List<City> cities = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(GET_CITY)) {

            stmt.setString(1, "%" + cityName + "%");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                City city = new City();
                city.setCityId(rs.getLong("city_id"));
                city.setCityName(rs.getString("city_name"));
                cities.add(city);
            }


        } catch (SQLException ex) {
            LOGGER.error("303", ex.getMessage());
            ex.printStackTrace();
        }
        return cities;
    }

    @Override
    public List<Street> findStreet(City city, String streetName) {
        List<Street> streets = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(GET_STREET)) {

            Long cityId = city.getCityId();
            stmt.setLong(1, cityId);
            stmt.setString(2, "%" + streetName + "%");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Street street = new Street();
                street.setCity(city);
                street.setStreetId(rs.getLong("street_id"));
                street.setStreetName(rs.getString("street_name"));
                streets.add(street);
            }
        } catch (SQLException ex) {
            LOGGER.error("303", ex.getMessage());
            ex.printStackTrace();
        }
        return streets;
    }

    @Override
    public List<Street> showAllStreets(City city) {
        List<Street> allStreets = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(SHOW_STREETS)) {

            Long cityId = city.getCityId();
            stmt.setLong(1, cityId);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Street street = new Street();
                street.setCity(city);
                street.setStreetId(rs.getLong("street_id"));
                street.setStreetName(rs.getString("street_name"));
                allStreets.add(street);
            }
        } catch (SQLException ex) {
            LOGGER.error("303", ex.getMessage());
            ex.printStackTrace();
        }
        return allStreets;
    }
}
