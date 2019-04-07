package com.cources.finalProject.controller.commands.customerCommands;

import com.cources.finalProject.controller.annotations.RequestMapping;
import com.cources.finalProject.controller.commands.Command;
import com.cources.finalProject.controller.mapper.OrderRequestMapper;
import com.cources.finalProject.model.dao.DAOFactory;
import com.cources.finalProject.model.dao.specificdao.OrderRequestDAO;
import com.cources.finalProject.model.entities.OrderRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RequestMapping
public class CustomerSendRequest implements Command {
    private OrderRequestDAO orderRequestDAO = DAOFactory.getInstance().createOrderRequestDao();

    @Override
    public String execute(HttpServletRequest request) throws ServletException {
        OrderRequest orderRequest = OrderRequestMapper.extractOrderRequest(request);
        orderRequestDAO.create(orderRequest);
        return "redirect:/customer/get-orders";
    }
}
