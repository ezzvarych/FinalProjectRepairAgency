package com.cources.finalProject.controller;

import com.cources.finalProject.controller.commands.adminCommands.AdminMain;
import com.cources.finalProject.controller.commands.authCommands.*;
import com.cources.finalProject.controller.commands.Command;
import com.cources.finalProject.controller.commands.customerCommands.CustomerMain;
import com.cources.finalProject.controller.commands.customerCommands.CustomerNewOrder;
import com.cources.finalProject.controller.commands.exceptionCommands.NotUniqueExceptionCommand;
import com.cources.finalProject.model.service.PersonService;
import com.cources.finalProject.model.service.impl.PersonServiceImpl;

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
    private PersonService personService = new PersonServiceImpl();

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        servletConfig.getServletContext().setAttribute("loggedUsers",
                new HashSet<String>());

        commandMap.put("/registration", new RegistrationCommand());
        commandMap.put("/check-register", new CheckRegisterCommand(personService));
        commandMap.put("/login", new LoginCommand());
        commandMap.put("/check-login", new CheckLoginCommand(personService));
        commandMap.put("/logout", new LogoutCommand());

        commandMap.put("/not-unique", new NotUniqueExceptionCommand());

        commandMap.put("/admin/main", new AdminMain());

        commandMap.put("/customer", new CustomerMain());
        commandMap.put("/customer/new-order", new CustomerNewOrder());
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
        String path = req.getRequestURI().replaceAll(".*/app", "");
        Command command = commandMap.getOrDefault(path, r -> "/index.jsp");
        String page = command.execute(req);
        if (page.contains("redirect")) {
            resp.sendRedirect(page.replaceAll("redirect:", "/app"));
        } else {
            req.getRequestDispatcher(page).forward(req, resp);
        }
    }
}
