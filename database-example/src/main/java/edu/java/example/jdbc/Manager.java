package edu.java.example.jdbc;

import edu.java.example.jdbc.dao.UserManagerDao;
import edu.java.example.jdbc.dao.UserManagerDaoImpl;
import edu.java.example.jdbc.domain.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Manager {

    public static void main(String[] args) {
        process();
    }

    public static void process() {
        UserManagerDao dao = new UserManagerDaoImpl();
        List<Person> allUsers = dao.getAllUsers();
        for(Person p : allUsers) {
            System.out.println(p);
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Введите ФИО: \n (Фамилия Имя Отчество)\n");
        List<String> s = Arrays.asList(in.nextLine().split(" "));
        List<Person> user = dao.findUser(s.get(1), s.get(0), s.get(2));
        for (Person p : user) {
            System.out.println(p);
        }

    }
}
