package com.cources.finalProject.models.dao.mapper;

import com.cources.finalProject.models.entities.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class PersonMapper implements ObjectMapper<Person> {


    @Override
    public Person extractFromResultSet(ResultSet rs) throws SQLException {
        Person person = new Person.PersonBuilder()
                .setPersonId(rs.getLong("person_id"))
                .setLogin(rs.getString("login"))
                .setEmail(rs.getString("email"))
                .setPassword(rs.getString("password"))
                .build();
        return person;
    }

    @Override
    public Person makeUnique(Map<Long, Person> cache, Person entity) {
        cache.putIfAbsent(entity.getPersonId(), entity);
        return cache.get(entity.getPersonId());
    }
}
