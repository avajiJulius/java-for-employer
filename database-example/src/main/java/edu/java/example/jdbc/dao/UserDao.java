package edu.java.example.jdbc.dao;

import edu.java.example.jdbc.domain.Person;

public interface UserDao {

    /**
     * Add person into a database
     *
     * @param person person data for insert into database
     * @return person ID
     */
    Long savePersonalData(Person person);

    /**
     * Edit person data in database on changed person data by using person ID
     *
     * @param personId person ID for access to person information
     * @param changes changed person data
     * @return person ID
     */
    Long editPersonalData(Long personId, Person changes);
}
