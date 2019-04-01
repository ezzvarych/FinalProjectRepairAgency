package com.cources.finalProject.controller.mapper;

import com.cources.finalProject.model.dto.PersonDTO;
import com.cources.finalProject.model.entities.Person;
import com.cources.finalProject.model.entities.Role;

import javax.servlet.http.HttpServletRequest;

public class PersonMapper {
    public static PersonDTO registrationExtractFromRequest(HttpServletRequest request) {
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Role role = Role.valueOf((request.getParameter("role")).toUpperCase());
        return new PersonDTO.PersonDTOBuilder()
                .setLogin(login).setEmail(email).setPassword(password).setRole(role).build();
    }

    public static PersonDTO loginExtractFromRequest(HttpServletRequest request) {
        String loginOrEmail = request.getParameter("loginOrEmail");
        String password = request.getParameter("password");
        return new PersonDTO.PersonDTOBuilder()
                .setLogin(loginOrEmail).setEmail(loginOrEmail).setPassword(password).build();
    }
}
