package com.cources.finalProject.models.dao.specificdao;

import com.cources.finalProject.models.dao.GenericDAO;
import com.cources.finalProject.models.entities.Order;
import com.cources.finalProject.models.entities.Person;

import java.util.List;

public interface OrderDAO extends GenericDAO<Order> {
    List<Order> getAllByMaster(Person master);
}
