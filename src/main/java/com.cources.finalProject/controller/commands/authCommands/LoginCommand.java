package com.cources.finalProject.controller.commands.authCommands;

import com.cources.finalProject.controller.annotations.RequestMapping;
import com.cources.finalProject.controller.commands.Command;
import com.cources.finalProject.controller.mapper.PersonMapper;
import com.cources.finalProject.model.dto.PersonDTO;
import com.cources.finalProject.model.entities.Person;
import com.cources.finalProject.model.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RequestMapping
public class LoginCommand implements Command {
    /**
     * @param request
     * @return login page
     * @throws ServletException
     */
    @Override
    public String execute(HttpServletRequest request) throws ServletException {
        System.out.println(request.getServletContext().getAttribute("commandMap"));
        if (request.getSession().getAttribute("login") != null) {
            return "/index.jsp";
        }
        return "/login.jsp";
    }
}
