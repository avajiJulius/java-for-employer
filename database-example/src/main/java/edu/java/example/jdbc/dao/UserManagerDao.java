package edu.java.example.jdbc.dao;

import edu.java.example.jdbc.domain.Person;

import java.util.List;

public interface UserManagerDao {
    List<Person> getAllUsers();
    List<Person> findUser(String forename, String surname, String patronymic);
    List<Person> findUser(Long cityId, Long streetId);
 }
