package com.cources.finalProject.model.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T> /*extends AutoCloseable*/ {
    void create(T entity);
    List<T> getAll();
    Optional<T> getById(long id);
    void update(T entity);
    void delete(long id);

    //void close();
}
