package edu.java.example.jdbc.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private Long personId;
    private String forename;
    private String surname;
    private String patronymic;
    private LocalDate birthDay;
    private List<Passport> passports;
    private Address address;

    public Person() {
    }

    public Person(Long personId, String forename, String surname, String patronymic,
                  LocalDate birthDay, List<Passport> passports, Address address) {
        this.personId = personId;
        this.forename = forename;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
        this.passports = passports;
        this.address = address;
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

    public List<Passport> getPassports() {
        return passports;
    }

    public void addPassports(Passport passport) {
        if(passports == null)
            passports = new ArrayList<>(4);
        passports.add(passport);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
