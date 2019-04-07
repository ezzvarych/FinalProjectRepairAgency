package com.cources.finalProject.controller.mapper;

import com.cources.finalProject.model.entities.OrderRequest;
import com.cources.finalProject.model.entities.Person;

import javax.servlet.http.HttpServletRequest;

/**
 * Getting OrderRequest from HttpRequest
 */
//TODO: To test
public class OrderRequestMapper {
    public static OrderRequest extractOrderRequest(HttpServletRequest request) {
        OrderRequest orderRequest = new OrderRequest.OrderRequestBuilder()
                .setRequestDescr(request.getParameter("descr"))
                .setUser((Person) request.getSession().getAttribute("sessionUser"))
                .build();
        return orderRequest;
    }
}
