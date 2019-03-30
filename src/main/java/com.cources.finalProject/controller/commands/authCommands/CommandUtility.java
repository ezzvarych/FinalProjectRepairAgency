package com.cources.finalProject.controller.commands.authCommands;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

class CommandUtility {
    static boolean isUserLogged(HttpServletRequest request, String login) {
        HashSet<String> loggedUsers = (HashSet<String>) request.getServletContext().getAttribute("loggedUsers");

        if (loggedUsers.contains(login)) {
            return true;
        }
        loggedUsers.add(login);
        request.getServletContext().setAttribute("loggedUsers", loggedUsers);
        return false;
    }
}
