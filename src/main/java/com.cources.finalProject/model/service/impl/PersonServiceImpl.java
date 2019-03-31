package com.cources.finalProject.model.service.impl;

import com.cources.finalProject.model.dao.DAOFactory;
import com.cources.finalProject.model.dao.specificdao.PersonDAO;
import com.cources.finalProject.model.entities.Person;
import com.cources.finalProject.model.entities.Role;
import com.cources.finalProject.model.service.PersonService;

import java.util.List;
import java.util.Optional;

public class PersonServiceImpl implements PersonService {
    private PersonDAO personDAO = DAOFactory.getInstance().createPersonDao();

    @Override
    public List<Person> getAll() {
        return personDAO.getAll();
    }

    @Override
    public Optional<Person> getById(long id) {
        return personDAO.getById(id);
    }

    @Override
    public List<Person> getAllByRole(Role role) {
        return personDAO.getAllByRole(role);
    }

    @Override
    public Optional<Person> getByLogin(String login) {
        return personDAO.getByLogin(login);
    }

    @Override
    public Optional<Person> getByEmail(String email) {
        return personDAO.getByEmail(email);
    }

    @Override
    public void create(Person entity) {
        personDAO.create(entity);
    }

    @Override
    public void update(Person entity) {
        personDAO.update(entity);
    }

    @Override
    public void delete(long id) {
        personDAO.delete(id);
    }
}
