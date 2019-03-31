package com.cources.finalProject.model.dao.impl;

import com.cources.finalProject.model.dao.DAOFactory;
import com.cources.finalProject.model.dao.specificdao.PersonDAO;
import com.cources.finalProject.model.entities.Person;
import com.cources.finalProject.model.entities.Role;
import entitySamples.SampleEntitiesCreator;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class JDBCPersonDAOTest {

    private static PersonDAO personDAO;

    @BeforeClass
    public static void init() {
        personDAO = DAOFactory.getInstance().createPersonDao();
    }

    @Test
    public void getAllByRoleTest() {
        Person stubMaster = new Person.PersonBuilder()
                .setLogin("master1").setRole(Role.MASTER).build();
        List<Person> lst = personDAO.getAllByRole(Role.MASTER);
        assertEquals(lst.size(), 5);
        assertTrue(lst.contains(stubMaster));
    }

    @Test
    public void getByLoginTest() {
        Person stub = new Person.PersonBuilder().setLogin("admin").setRole(Role.ADMIN).build();
        Optional<Person> fromDb = personDAO.getByLogin("admin");
        assertTrue(fromDb.isPresent());
        assertEquals(stub, fromDb.get());
    }

    /**
     * Should work same as login search, no sense to test
     */
    @Test
    @Ignore
    public void getByEmail() {
    }

    @Test
    public void createDeleteTest() {
        Person person = SampleEntitiesCreator.createUser();
        personDAO.create(person);
        Optional<Person> fromDb = personDAO.getByLogin(person.getLogin());
        assertTrue(fromDb.isPresent());
        assertEquals(person, fromDb.get());

        Person toDelete = fromDb.get();
        personDAO.delete(toDelete.getPersonId());
        assertFalse(personDAO.getAll().contains(person));
    }

    @Test
    public void getAllTest() {
        List<Person> lst = personDAO.getAll();
        assertEquals(lst.size(), 11);
    }

    @Test
    public void getByIdTest() {
        Optional<Person> person = personDAO.getById(1);
        assertTrue(person.isPresent());
        assertEquals(person.get().getLogin(), "admin");
    }

    @Test
    public void updateTest() {
        Person person = personDAO.getByLogin("user").get();
        person.setRole(Role.ADMIN);
        personDAO.update(person);
        Person fromDb1 = personDAO.getByLogin("user").get();
        assertEquals(person.getRole(), fromDb1.getRole());
        fromDb1.setRole(Role.CUSTOMER);
        personDAO.update(fromDb1);
    }
}