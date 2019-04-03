package com.cources.finalProject.controller.commands.adminCommands;

import com.cources.finalProject.controller.annotations.RequestMapping;
import com.cources.finalProject.controller.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RequestMapping
public class AdminMain implements Command {
    @Override
    public String execute(HttpServletRequest request) throws ServletException {
        return "/WEB-INF/admin/admin-main.jsp";
    }
}
