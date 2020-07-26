package edu.java.example.jdbc.dao;

import edu.java.example.jdbc.domain.City;
import edu.java.example.jdbc.domain.Street;

import java.util.List;

public interface DictionaryDao {
    List<City> showAllCities();
    List<City> findCity(String cityName);
    List<Street> findStreet(City city, String streetName);
    List<Street> showAllStreets(City city);
}
