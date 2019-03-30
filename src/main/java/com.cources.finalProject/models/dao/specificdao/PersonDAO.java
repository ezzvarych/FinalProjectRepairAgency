package com.cources.finalProject.models.dao.specificdao;

import com.cources.finalProject.models.dao.GenericDAO;
import com.cources.finalProject.models.entities.Person;
import com.cources.finalProject.models.entities.Role;

import java.util.List;

public interface PersonDAO extends GenericDAO<Person> {
    List<Person> getAllByRole(Role role);
    Person getByLogin(String login);
    Person getByEmail(String email);
}
