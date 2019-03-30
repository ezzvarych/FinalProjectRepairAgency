package com.cources.finalProject.models.dao;

import java.util.List;

public interface GenericDAO<T> extends AutoCloseable {
    void create(T entity);
    List<T> getAll();
    T getById(int id);
    void update(T entity);
    void delete(int id);

    //void close();
}
