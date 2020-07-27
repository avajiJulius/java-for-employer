package edu.java.example.jdbc.dao;

import edu.java.example.jdbc.domain.City;
import edu.java.example.jdbc.domain.Passport;
import edu.java.example.jdbc.domain.Person;
import edu.java.example.jdbc.domain.Street;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    private DictionaryDao dao = new DictionaryDaoImpl();
    private UserManagerDao managerDao = new UserManagerDaoImpl();

    @Test
    public void savePersonalData() {
        Person person = new Person();
        person.setForename("Александр");
        person.setSurname("Матушкин");
        person.setPatronymic("Эдуардович");
        person.setBirthDay(LocalDate.of(2000, 2, 12));
        City city = dao.findCity("Санкт-Петербург").get(0);
        Street street = dao.findStreet(city, "Улица Рубинштейна").get(0);
        person.setCity(city);
        person.setStreet(street);
        person.setBuilding("12A");

        Passport passport = new Passport();
        passport.setPerson(person);
        passport.setSeria("1234");
        passport.setNumber("567890");
        passport.setIssueDate(LocalDate.of(2014, 7,9));
        passport.setIssueDepartment(null);
        person.addPassports(passport);


        UserDao user = new UserDaoImpl();
        Long userId = user.savePersonalData(person);
        int currentId = managerDao.getAllUsers().size();
        Assert.assertTrue(userId == currentId);
    }

    @Test
    public void editPersonalData() {
        Person person = new Person();
        person.setForename("Полина");
        person.setSurname("Кузнецова");
        person.setPatronymic("Петровна");
        person.setBirthDay(LocalDate.of(2000, 2, 16));
        City city = dao.findCity("Калининград").get(0);
        Street street = dao.findStreet(city, "Улица Янтарная").get(0);
        person.setCity(city);
        person.setStreet(street);
        person.setBuilding("17Б");

        Passport passport = new Passport();
        passport.setPerson(person);
        passport.setSeria("1234");
        passport.setNumber("567890");
        passport.setIssueDate(LocalDate.of(2014, 7,9));
        passport.setIssueDepartment("J");
        person.addPassports(passport);


        UserDao user = new UserDaoImpl();
        Long id = user.editPersonalData(7L, person);

    }
}