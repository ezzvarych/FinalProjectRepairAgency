package com.cources.finalProject.model.service;

import com.cources.finalProject.model.entities.Person;
import com.cources.finalProject.model.entities.Role;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getAll();
    Optional<Person> getById(long id);
    List<Person> getAllByRole(Role role);
    Optional<Person> getByLogin(String login);
    Optional<Person> getByEmail(String email);
    void create(Person entity);
    void update(Person entity);
    void delete(long id);
}
