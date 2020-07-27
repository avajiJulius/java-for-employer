package edu.java.example.jdbc.dao;

import edu.java.example.jdbc.domain.City;
import edu.java.example.jdbc.domain.Street;

import java.util.List;

public interface DictionaryDao {

    /**
     * Show all cities which are in database
     *
     * @return List of all cities
     */
    List<City> showAllCities();

    /**
     * Find city by input of city name
     *
     * @param cityName name of the desired city
     * @return list with possible city names
     */
    List<City> findCity(String cityName);

    /**
     * Find street by input of city and street name
     *
     * @param city the city in which the streets will be searched
     * @param streetName name of the desired street
     * @return list with possible street names in required city
     */
    List<Street> findStreet(City city, String streetName);

    /**
     * Show all streets which are in database
     *
     * @param city the city in which the streets will be searched
     * @return list of all streets in required city
     */
    List<Street> showAllStreets(City city);
}
