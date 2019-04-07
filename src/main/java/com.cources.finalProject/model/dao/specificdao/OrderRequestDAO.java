package com.cources.finalProject.model.dao.specificdao;

import com.cources.finalProject.model.dao.GenericDAO;
import com.cources.finalProject.model.entities.OrderRequest;
import com.cources.finalProject.model.entities.Person;

import java.util.List;

public interface OrderRequestDAO extends GenericDAO<OrderRequest> {
    List<OrderRequest> getAllByManager(Person manager);
    List<OrderRequest> getAllByUser(Person user);
    List<OrderRequest> getAllAccepted();
    List<OrderRequest> getAllDenied();
    List<OrderRequest> getAllUnhandled();
}
