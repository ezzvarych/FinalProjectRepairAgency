package com.cources.finalProject.controller.commands.authCommands;

import com.cources.finalProject.controller.commands.Command;
import com.cources.finalProject.model.dao.DAOFactory;
import com.cources.finalProject.model.dao.specificdao.PersonDAO;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/registration.jsp";
    }
}
