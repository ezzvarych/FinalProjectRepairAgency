package com.cources.finalProject.controller;

import com.cources.finalProject.controller.commands.authCommands.CheckRegisterCommand;
import com.cources.finalProject.controller.commands.Command;
import com.cources.finalProject.controller.commands.authCommands.RegistrationCommand;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Servlet extends HttpServlet {

    private Map<String, Command> commandMap = new HashMap<>();

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        servletConfig.getServletContext().setAttribute("loggedUsers",
                new HashSet<String>());

        commandMap.put("registration", new RegistrationCommand());
        commandMap.put("register", new CheckRegisterCommand());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getRequestURI().replaceAll(".*/app/", "");
        Command command = commandMap.getOrDefault(path, r -> "/index.jsp");
        String page = command.execute(req);
        if (page.contains("redirect")) {
            resp.sendRedirect(page.replaceAll("redirect:", "/app"));
        } else {
            req.getRequestDispatcher(page).forward(req, resp);
        }
    }
}
