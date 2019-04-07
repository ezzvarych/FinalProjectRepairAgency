package com.cources.finalProject.controller.mapper;

import com.cources.finalProject.model.entities.Person;
import com.cources.finalProject.model.entities.Role;

import javax.servlet.http.HttpServletRequest;

public class PersonMapper {
    public static Person registrationExtractFromRequest(HttpServletRequest request) {
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Role role = Role.valueOf((request.getParameter("role")).toUpperCase());
        return new Person.PersonBuilder()
                .setLogin(login).setEmail(email).setPassword(password).setRole(role).build();
    }

    public static Person loginExtractFromRequest(HttpServletRequest request) {
        String loginOrEmail = request.getParameter("loginOrEmail");
        String password = request.getParameter("password");
        return new Person.PersonBuilder()
                .setLogin(loginOrEmail).setEmail(loginOrEmail).setPassword(password).build();
    }
}
