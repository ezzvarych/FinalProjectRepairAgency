package com.cources.finalProject.controller.commands.authCommands;

import com.cources.finalProject.model.entities.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

class CommandUtility {

    static void saveUser(HttpServletRequest request, Person person) {
        HashSet<String> loggedUsers = (HashSet<String>) request.getServletContext().getAttribute("loggedUsers");
        HttpSession session = request.getSession();

        loggedUsers.add(person.getLogin());
        request.getServletContext().setAttribute("loggedUsers", loggedUsers);

        session.setAttribute("sessionUser", person);
        //session.setAttribute("role", role);
    }

    static boolean isUserLogged(HttpServletRequest request, String login) {
        HashSet<String> loggedUsers = (HashSet<String>) request.getServletContext().getAttribute("loggedUsers");
        return loggedUsers.contains(login);
    }
}
