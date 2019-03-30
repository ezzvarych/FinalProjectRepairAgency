package com.cources.finalProject.controller.commands.authCommands;

import com.cources.finalProject.controller.commands.Command;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/views/registration.jsp";
    }
}
