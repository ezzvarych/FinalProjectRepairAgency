package com.cources.finalProject.model.dao.specificdao;

import com.cources.finalProject.model.dao.GenericDAO;
import com.cources.finalProject.model.entities.Person;
import com.cources.finalProject.model.entities.Role;

import java.util.List;
import java.util.Optional;

public interface PersonDAO extends GenericDAO<Person> {
    List<Person> getAllByRole(Role role);
    Optional<Person> getByLogin(String login);
    Optional<Person> getByEmail(String email);
}
