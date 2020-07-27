package edu.java.example.jdbc.dao;

import edu.java.example.jdbc.domain.*;
import edu.java.example.jdbc.exception.NullPassportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserManagerDaoImpl implements UserManagerDao{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserManagerDaoImpl.class);

    private static final String GET_USERS = "SELECT p.person_id, p.forename, p.surname, p.patronymic, p.b_day, " +
            "p.city_id, c.city_name, p.street_id, s.street_name, building FROM jdbc_person p " +
            "INNER JOIN jdbc_city c ON c.city_id = p.city_id " +
            "INNER JOIN jdbc_street s ON s.street_id = p.street_id";

    private static final String FIND_USER_BY_NAME = "SELECT p.person_id, p.forename, p.surname, p.patronymic, p.b_day, " +
            "p.city_id, c.city_name, p.street_id, s.street_name, building FROM jdbc_person p " +
            "INNER JOIN jdbc_city c ON c.city_id = p.city_id " +
            "INNER JOIN jdbc_street s ON s.street_id = p.street_id " +
            "WHERE UPPER(forename) LIKE UPPER(?) and UPPER(surname) LIKE UPPER(?) and UPPER(patronymic) LIKE UPPER(?) " +
            "ORDER BY person_id";

    private static final String FIND_USER_BY_ADDRESS = "SELECT p.person_id, p.forename, p.surname, p.patronymic, p.b_day, " +
            "p.city_id, c.city_name, p.street_id, s.street_name, building FROM jdbc_person p " +
            "INNER JOIN jdbc_city c ON c.city_id = p.city_id " +
            "INNER JOIN jdbc_street s ON s.street_id = p.street_id " +
            "WHERE p.city_id = ? and p.street_id = ? " +
            "ORDER BY person_id";

    private static final String GET_PASSPORTS = "SELECT pas.* " +
            "FROM jdbc_passport pas " +
            "WHERE pas.person_id IN ";

    private Connection getConnection() throws SQLException {
        return ConnectionBuilder.getConnection();
    }

    @Override
    public List<Person> getAllUsers() {
        List<Person> persons = new ArrayList<>();

        try(Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(GET_USERS)) {


            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {

                Person person = new Person();
                person.setPersonId(rs.getLong(1));
                person.setForename(rs.getString(2));
                person.setSurname(rs.getString(3));
                person.setPatronymic(rs.getString(4));
                person.setBirthDay(rs.getDate(5).toLocalDate());

                City city = new City(rs.getLong("city_id"), rs.getString("city_name"));
                person.setCity(city);
                Street street = new Street(city, rs.getLong("street_id"),
                        rs.getString("street_name"));
                person.setStreet(street);
                person.setBuilding(rs.getString("building"));

                persons.add(person);
            }
            getPassports(con, persons);

            rs.close();
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (NullPassportException e) {
            LOGGER.error("Паспорт отсутствует");
            System.err.print("Паспорт отсутствует");
        }
        return persons;
    }

    @Override
    public List<Person> findUser(String forename, String surname, String patronymic) {
        List<Person> persons = new ArrayList<>();

        try(Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(FIND_USER_BY_NAME)) {

            stmt.setString(1, "%" + forename + "%");
            stmt.setString(2, "%" + surname + "%");
            stmt.setString(3, "%" + patronymic + "%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Person person = new Person();
                person.setPersonId(rs.getLong("person_id"));
                person.setForename(rs.getString("forename"));
                person.setSurname(rs.getString("surname"));
                person.setPatronymic(rs.getString("patronymic"));
                person.setBirthDay(rs.getDate("b_day").toLocalDate());

                City city = new City(rs.getLong("city_id"), rs.getString("city_name"));
                person.setCity(city);
                Street street = new Street(city, rs.getLong("street_id"),
                        rs.getString("street_name"));
                person.setStreet(street);
                person.setBuilding(rs.getString("building"));

                persons.add(person);
            }
            getPassports(con, persons);

            rs.close();

        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (NullPassportException e) {
            LOGGER.error("Паспорт отсутствует");
            System.err.print("Паспорт отсутствует");
        }
        return persons;
    }


    @Override
    public List<Person> findUser(Long cityId, Long streetId) {
        List<Person> persons = new ArrayList<>();

        try(Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(FIND_USER_BY_ADDRESS)) {

            stmt.setLong(1, cityId);
            stmt.setLong(2, streetId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Person person = new Person();
                person.setPersonId(rs.getLong("person_id"));
                person.setForename(rs.getString("forename"));
                person.setSurname(rs.getString("surname"));
                person.setPatronymic(rs.getString("patronymic"));
                person.setBirthDay(rs.getDate("b_day").toLocalDate());

                City city = new City(rs.getLong("city_id"), rs.getString("city_name"));
                person.setCity(city);
                Street street = new Street(city, rs.getLong("street_id"),
                        rs.getString("street_name"));
                person.setStreet(street);
                person.setBuilding(rs.getString("building"));

                persons.add(person);
            }
            getPassports(con, persons);

            rs.close();

        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (NullPassportException e) {
            LOGGER.error("Паспорт отсутствует");
            System.err.print("Паспорт отсутствует");
        }
        return persons;
    }


    private void getPassports(Connection con, List<Person> persons) throws SQLException, NullPassportException {
        String add = "(" + persons.stream().map(p -> String.valueOf(p.getPersonId()))
                .collect(Collectors.joining(",")) + ")";
        if("()".equals(add)){
            throw new NullPassportException();
        }

        Map<Long, Person> maps = persons.stream()
                .collect(Collectors.toMap(p -> p.getPersonId(), p -> p));

        try(PreparedStatement stmt = con.prepareStatement(GET_PASSPORTS + add)) {

            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Passport pas = new Passport();
                Person p = maps.get(rs.getLong("person_id"));
                pas.setPerson(p);
                pas.setPassportId(rs.getLong("passport_id"));
                pas.setSeria(rs.getString("seria"));
                pas.setNumber(rs.getString("number"));
                pas.setIssueDate(rs.getDate("issue_date").toLocalDate());
                pas.setIssueDepartment(rs.getString("issue_department"));
                p.addPassports(pas);
            }
        }
    }
}
