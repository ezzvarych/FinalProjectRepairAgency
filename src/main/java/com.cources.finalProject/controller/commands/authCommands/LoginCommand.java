package com.cources.finalProject.controller.commands.authCommands;

import com.cources.finalProject.controller.commands.Command;
import com.cources.finalProject.controller.mapper.PersonMapper;
import com.cources.finalProject.model.dto.PersonDTO;
import com.cources.finalProject.model.entities.Person;
import com.cources.finalProject.model.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


public class LoginCommand implements Command {
    /**
     * @param request
     * @return login page
     * @throws ServletException
     */
    @Override
    public String execute(HttpServletRequest request) throws ServletException {
        return "/login.jsp";
    }
}
