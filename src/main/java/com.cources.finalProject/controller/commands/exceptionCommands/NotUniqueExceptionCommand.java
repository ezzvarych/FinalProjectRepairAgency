package com.cources.finalProject.controller.commands.exceptionCommands;

import com.cources.finalProject.controller.annotations.RequestMapping;
import com.cources.finalProject.controller.commands.Command;
import com.cources.finalProject.exceptions.NotUniqueRegisterException;
import com.cources.finalProject.model.entities.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RequestMapping
public class NotUniqueExceptionCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws ServletException {
        NotUniqueRegisterException exception = (NotUniqueRegisterException) request.getAttribute("javax.servlet.error.exception");
        request.setAttribute("exception", exception);
        return "/registration.jsp";
    }
}
