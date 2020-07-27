package edu.java.example.jdbc.dao;

import edu.java.example.jdbc.domain.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserManagerDaoImplTest {

    private UserManagerDao dao = new UserManagerDaoImpl();

    @Test
    public void getAllUsers() {
        List<Person> allUsers = dao.getAllUsers();
        Assert.assertTrue(allUsers.size() == 9);
    }

    @Test
    public void findUser() {
        List<Person> usersName = dao.findUser("Полина", "Кузнецова", "Петровна");
        List<Person> usersAddress = dao.findUser(4012L, 32L);
        Assert.assertTrue(usersName.size() == 1);
        Assert.assertTrue(usersAddress.size() == 1);
    }


}