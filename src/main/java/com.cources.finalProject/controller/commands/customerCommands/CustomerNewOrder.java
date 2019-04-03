package com.cources.finalProject.controller.commands.customerCommands;

import com.cources.finalProject.controller.annotations.RequestMapping;
import com.cources.finalProject.controller.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RequestMapping
public class CustomerNewOrder implements Command {
    @Override
    public String execute(HttpServletRequest request) throws ServletException {
        return "/WEB-INF/customer/new-order.jsp";
    }
}
