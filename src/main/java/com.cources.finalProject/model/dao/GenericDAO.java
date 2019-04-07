package com.cources.finalProject.model.dao;

import java.util.List;
import java.util.Optional;

/**
 * Typical CRUD DAO methods
 * @param <T>
 */
public interface GenericDAO<T> {
    void create(T entity);
    List<T> getAll();
    Optional<T> getById(long id);
    void update(T entity);
    void delete(long id);
}
