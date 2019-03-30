package com.cources.finalProject.models.dao.specificdao;

import com.cources.finalProject.models.dao.GenericDAO;
import com.cources.finalProject.models.entities.Order;
import com.cources.finalProject.models.entities.OrderRequest;
import com.cources.finalProject.models.entities.Person;

import java.util.List;

public interface OrderRequestDAO extends GenericDAO<OrderRequest> {
    List<OrderRequest> getAllByManager(Person manager);
    List<OrderRequest> getAllByUser(Person user);
    List<OrderRequest> getAllAccepted();
    List<OrderRequest> getAllDenied();
}
