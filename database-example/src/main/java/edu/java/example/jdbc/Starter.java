package edu.java.example.jdbc;

import edu.java.example.jdbc.dao.DictionaryDao;
import edu.java.example.jdbc.dao.DictionaryDaoImpl;
import edu.java.example.jdbc.domain.City;
import edu.java.example.jdbc.domain.Street;

import java.util.List;

public class Starter {
    public static void main(String[] args) {
        DictionaryDao dao = new DictionaryDaoImpl();
        List<City> cities = dao.showAllCities();
        for(City city : cities) {
            System.out.println(city);
            List<Street> a = dao.findStreet(city, "Бер");
            for(Street b: a) {
                System.out.println(b);
            }
        }
        List<Street> streets = dao.showAllStreets(cities.get(0));
        for(Street street:streets) {
            System.out.println(street);
        }


        List<City> m = dao.findCity("м");
        for(City c: m) {
            System.out.println(c);
        }

    }
}
