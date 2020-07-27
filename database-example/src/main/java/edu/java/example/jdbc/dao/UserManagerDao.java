package edu.java.example.jdbc.dao;

import edu.java.example.jdbc.domain.Passport;
import edu.java.example.jdbc.domain.Person;
import edu.java.example.jdbc.domain.UserFilter;

import java.util.List;

public interface UserManagerDao {
    List<Person> showAllUsers();
    List<Person> findUser(UserFilter filter);
    List<Passport> showUserPassports(Long personId);
 }
