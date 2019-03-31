package com.cources.finalProject.model.dao.specificdao;

import com.cources.finalProject.model.dao.GenericDAO;
import com.cources.finalProject.model.entities.Order;
import com.cources.finalProject.model.entities.Person;

import java.util.List;

public interface OrderDAO extends GenericDAO<Order> {
    List<Order> getAllByMaster(Person master);
}
