package edu.java.example.jdbc.dao;

import edu.java.example.jdbc.domain.Person;

import java.util.List;

public interface UserManagerDao {

    /**
     * Get all persons from database
     *
     * @return list of all persons
     */
    List<Person> getAllUsers();

    /**
     * Find Persons by forename, surname and patronymic
     *
     * @param forename
     * @param surname
     * @param patronymic
     * @return list of persons whose forename, surname, patronymic occur
     */
    List<Person> findUser(String forename, String surname, String patronymic);

    /**
     * Find Persons by city and street
     *
     * @param cityId ID of city
     * @param streetId ID of street
     * @return list of persons whose city and street occur
     */
    List<Person> findUser(Long cityId, Long streetId);
 }
