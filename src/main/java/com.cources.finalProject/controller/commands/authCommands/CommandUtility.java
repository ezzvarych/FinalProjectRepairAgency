package com.cources.finalProject.controller.commands.authCommands;

import com.cources.finalProject.model.entities.Role;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;

class CommandUtility {

    static void saveUser(HttpServletRequest request, String login, Role role) {
        HashSet<String> loggedUsers = (HashSet<String>) request.getServletContext().getAttribute("loggedUsers");
        HttpSession session = request.getSession();

        loggedUsers.add(login);
        request.getServletContext().setAttribute("loggedUsers", loggedUsers);

        session.setAttribute("login", login);
        session.setAttribute("role", role);
    }

    static boolean isUserLogged(HttpServletRequest request, String login) {
        HashSet<String> loggedUsers = (HashSet<String>) request.getServletContext().getAttribute("loggedUsers");
        return loggedUsers.contains(login);
    }
}
