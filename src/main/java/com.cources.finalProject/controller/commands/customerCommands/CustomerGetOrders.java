package com.cources.finalProject.controller.commands.customerCommands;

import com.cources.finalProject.controller.commands.Command;
import com.cources.finalProject.model.dao.DAOFactory;
import com.cources.finalProject.model.dao.specificdao.OrderRequestDAO;
import com.cources.finalProject.model.entities.OrderRequest;
import com.cources.finalProject.model.entities.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CustomerGetOrders implements Command {

    private OrderRequestDAO orderRequestDAO = DAOFactory.getInstance().createOrderRequestDao();

    @Override
    public String execute(HttpServletRequest request) throws ServletException {
        List<OrderRequest> reqs = orderRequestDAO
                .getAllByUser((Person)request.getSession().getAttribute("sessionUser"));
        request.setAttribute("reqs", reqs);
        return "/WEB-INF/customer/get-all.jsp";
    }
}
