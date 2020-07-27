package edu.java.example.jdbc.dao;

import edu.java.example.jdbc.domain.Passport;
import edu.java.example.jdbc.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    private static final String INSERT_USER = "INSERT INTO jdbc_person" +
            "(forename, surname, patronymic, b_day, city_id, street_id, building) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String INSERT_PASSPORT = "INSERT INTO jdbc_passport" +
            "(person_id, seria, number, issue_date, issue_department) " +
            "VALUES (?, ?, ?, ?, ?)";

    private static final String EDIT_USER = "UPDATE jdbc_person " +
            "set forename = ?, " +
            "surname = ?, " +
            "patronymic = ?, " +
            "b_day = ?, " +
            "city_id = ?, " +
            "street_id = ?, " +
            "building = ? " +
            "where person_id = ?";

    private Connection getConnection() throws SQLException {
        return ConnectionBuilder.getConnection();
    }

    @Override
    public Long savePersonalData(Person person) {
        Long id = -1L;

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(INSERT_USER, new String[]{"person_id"})) {

            con.setAutoCommit(false);

            try {
                stmt.setString(1, person.getForename());
                stmt.setString(2, person.getSurname());
                stmt.setString(3, person.getPatronymic());
                stmt.setDate(4, java.sql.Date.valueOf(person.getBirthDay()));
                stmt.setLong(5, person.getCity().getCityId());
                stmt.setLong(6, person.getStreet().getStreetId());
                stmt.setString(7, person.getBuilding());

                stmt.executeUpdate();

                ResultSet result = stmt.getGeneratedKeys();
                while (result.next()) {
                    id = result.getLong(1);
                }
                result.close();

                savePassports(con, person, id);

                con.commit();
            } catch (SQLException ex) {
                con.rollback();
                throw ex;
            }


        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
        return id;
    }


    private void savePassports(Connection con, Person person, Long id) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement(INSERT_PASSPORT)) {
            for (Passport pas : person.getPassports()) {

                stmt.setLong(1, id);
                stmt.setString(2, pas.getSeria());
                stmt.setString(3, pas.getNumber());
                stmt.setDate(4, java.sql.Date.valueOf(pas.getIssueDate()));
                stmt.setString(5, pas.getIssueDepartment());

            }
        }
    }

    @Override
    public Long editPersonalData(Long personId, Person changes) {

        try(Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(EDIT_USER)) {

            con.setAutoCommit(false);

            try {
                stmt.setString(1, changes.getForename());
                stmt.setString(2, changes.getSurname());
                stmt.setString(3, changes.getPatronymic());
                stmt.setDate(4, java.sql.Date.valueOf(changes.getBirthDay()));
                stmt.setLong(5, changes.getCity().getCityId());
                stmt.setLong(6, changes.getStreet().getStreetId());
                stmt.setString(7, changes.getBuilding());
                stmt.setLong(8, personId);

                stmt.executeUpdate();

                con.commit();

            } catch (SQLException ex) {
                con.rollback();
                throw ex;
            }
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
        return personId;
    }


}