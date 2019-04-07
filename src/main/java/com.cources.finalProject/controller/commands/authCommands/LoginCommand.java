package com.cources.finalProject.controller.commands.authCommands;

import com.cources.finalProject.controller.annotations.RequestMapping;
import com.cources.finalProject.controller.commands.Command;
import com.cources.finalProject.model.entities.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RequestMapping
public class LoginCommand implements Command {
    /**
     * @param request
     * @return login page
     * @throws ServletException
     */
    @Override
    public String execute(HttpServletRequest request) throws ServletException {
        Person p = (Person) request.getSession().getAttribute("sessionUser");
        if (p != null) {
            return "/index.jsp";
        }
        return "/login.jsp";
    }
}
