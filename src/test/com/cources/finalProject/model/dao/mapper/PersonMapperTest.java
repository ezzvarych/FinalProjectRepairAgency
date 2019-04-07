package com.cources.finalProject.model.dao.mapper;

import com.cources.finalProject.model.entities.Person;
import com.cources.finalProject.model.entities.Role;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class PersonMapperTest {

    @Test
    public void extractFromResultSetTest() throws SQLException {
        ResultSet rs = mock(ResultSet.class);
        PersonMapper personMapper = new PersonMapper();

        when(rs.getLong("person_id")).thenReturn((long)1);
        when(rs.getString("login")).thenReturn("admin");
        when(rs.getString("password")).thenReturn("admin");
        when(rs.getInt("role_id")).thenReturn(4);

        Person person = new Person.PersonBuilder()
                .setPersonId((long)1).setLogin("admin")
                .setPassword("admin").setRole(Role.valueOf(4))
                .build();

        assertEquals(person, personMapper.extractFromResultSet(rs));
    }
}