package edu.java.example.jdbc.dao;

import edu.java.example.jdbc.domain.Person;


public interface UserDao {
    Long savePersonalData(Person person);
    Long editPersonalData(Long personId, Person changes);
}
