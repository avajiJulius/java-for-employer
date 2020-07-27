package edu.java.example.jdbc.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private Long personId;
    private String forename;
    private String surname;
    private String patronymic;
    private LocalDate birthDay;
    private City city;
    private Street street;
    private String building;
    private List<Passport> passports;

    public Person() {
    }

    public Person(Long personId, String forename, String surname, String patronymic, LocalDate birthDay,
                  City city, Street street, String building, List<Passport> passports) {
        this.personId = personId;
        this.forename = forename;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
        this.city = city;
        this.street = street;
        this.building = building;
        this.passports = passports;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public List<Passport> getPassports() {
        return passports;
    }

    public void addPassports(Passport passport) {
        if(passports == null)
            passports = new ArrayList<>(4);
        passports.add(passport);

    }



    @Override
    public String toString() {
        return "Персональный ID: " + personId
                + "\nИмя: " + forename
                + "\nФамилия: " + surname
                + "\nОтчество: " + patronymic
                + "\nДата рождения: " + birthDay
                + "\nАдрес: " + street + building
                + "\nПаспорта: \n" + passports.stream().map(Passport::toString).collect(Collectors.toList())
                + "\n\n>>>>>>>>>>>>>>>>>>>>>>\n\n";
    }
}
