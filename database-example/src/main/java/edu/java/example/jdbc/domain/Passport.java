package edu.java.example.jdbc.domain;

import java.time.LocalDate;

public class Passport {
    private Long passportId;
    private Person person;
    private String seria;
    private String number;
    private LocalDate issueDate;
    private String issueDepartment;

    public Passport() {
    }

    public Passport(Long passportId, Person person, String seria, String number, LocalDate issueDate, String issueDepartment) {
        this.passportId = passportId;
        this.person = person;
        this.seria = seria;
        this.number = number;
        this.issueDate = issueDate;
        this.issueDepartment = issueDepartment;
    }

    public Long getPassportId() {
        return passportId;
    }

    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getSeria() {
        return seria;
    }

    public void setSeria(String seria) {
        this.seria = seria;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(String issueDepartment) {
        this.issueDepartment = issueDepartment;
    }

    @Override
    public String toString() {
        return "\nСерия: " + seria
                + "\nНомер: " + number
                + "\nДата выдачи: " + issueDate
                + "\nОтдел выдачи: " + issueDepartment;
    }
}
