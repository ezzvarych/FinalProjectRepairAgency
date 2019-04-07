package com.cources.finalProject.model.service.impl;

import com.cources.finalProject.model.entities.OrderRequest;
import com.cources.finalProject.model.entities.Person;
import com.cources.finalProject.model.service.OrderRequestService;

import java.util.List;
import java.util.Optional;

public class OrderRequestImpl implements OrderRequestService {


    @Override
    public void create(OrderRequest entity) {

    }

    @Override
    public List<OrderRequest> getAll() {
        return null;
    }

    @Override
    public Optional<OrderRequest> getById(long id) {
        return Optional.empty();
    }

    @Override
    public void update(OrderRequest entity) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<OrderRequest> getAllByManager(Person manager) {
        return null;
    }

    @Override
    public List<OrderRequest> getAllByUser(Person user) {
        return null;
    }

    @Override
    public List<OrderRequest> getAllAccepted() {
        return null;
    }

    @Override
    public List<OrderRequest> getAllDenied() {
        return null;
    }
}
