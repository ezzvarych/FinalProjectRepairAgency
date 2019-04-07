package com.cources.finalProject.model.service;

import com.cources.finalProject.model.entities.OrderRequest;
import com.cources.finalProject.model.entities.Person;

import java.util.List;
import java.util.Optional;

public interface OrderRequestService {
    void create(OrderRequest entity);
    List<OrderRequest> getAll();
    Optional<OrderRequest> getById(long id);
    void update(OrderRequest entity);
    void delete(long id);
    List<OrderRequest> getAllByManager(Person manager);
    List<OrderRequest> getAllByUser(Person user);
    List<OrderRequest> getAllAccepted();
    List<OrderRequest> getAllDenied();
}
