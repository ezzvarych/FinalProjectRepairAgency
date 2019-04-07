package com.cources.finalProject.controller;

import com.cources.finalProject.controller.commands.adminCommands.AdminMain;
import com.cources.finalProject.controller.commands.authCommands.*;
import com.cources.finalProject.controller.commands.Command;
import com.cources.finalProject.controller.commands.customerCommands.CustomerGetOrders;
import com.cources.finalProject.controller.commands.customerCommands.CustomerMain;
import com.cources.finalProject.controller.commands.customerCommands.CustomerNewOrder;
import com.cources.finalProject.controller.commands.customerCommands.CustomerSendRequest;
import com.cources.finalProject.controller.commands.exceptionCommands.NotUniqueExceptionCommand;
import com.cources.finalProject.model.service.PersonService;
import com.cources.finalProject.model.service.impl.PersonServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Front controller, handle all user requests and redirect them
 * to specific commands according to request URL
 */
public class Servlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(Servlet.class);

    private Map<String, Command> commandMap = new HashMap<>();
    private PersonService personService = new PersonServiceImpl();

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        logger.info("Servlet is loaded in container");

        servletConfig.getServletContext().setAttribute("loggedUsers",
                new HashSet<String>());

        commandMap.put("/registration", new RegistrationCommand());
        commandMap.put("/check-register", new CheckRegisterCommand(personService));
        commandMap.put("/login", new LoginCommand());
        commandMap.put("/check-login", new CheckLoginCommand(personService));
        commandMap.put("/logout", new LogoutCommand());

        commandMap.put("/not-unique", new NotUniqueExceptionCommand());

        commandMap.put("/admin/main", new AdminMain());

        commandMap.put("/customer/main", new CustomerMain());
        commandMap.put("/customer/new-order", new CustomerNewOrder());
        commandMap.put("/customer/send-request", new CustomerSendRequest());
        commandMap.put("/customer/get-orders", new CustomerGetOrders());
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
