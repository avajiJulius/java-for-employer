package edu.java.example.jdbc.dao;

import edu.java.example.jdbc.domain.City;
import edu.java.example.jdbc.domain.Street;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DictionaryDaoTest {
    private DictionaryDao dao = new DictionaryDaoImpl();


    @Test
    public void showAllCities() {
        List<City> cities = dao.showAllCities();
        Assert.assertTrue(cities.size() == 3);
    }

    @Test
    public void findCity() {
        List<City> city = dao.findCity("мо");
        Assert.assertTrue(city.size() == 1);
    }

    @Test
    public void findStreet() {
        City city = new City(812L, "Санкт-Петербург");
        List<Street> streets = dao.findStreet(city, "Бер");
        Assert.assertTrue(streets.size() == 3);
    }

    @Test
    public void showAllStreets() {
        City city = new City(495L, "Москва");
        List<Street> streets = dao.showAllStreets(city);
        Assert.assertTrue(streets.size() == 10);
    }
}