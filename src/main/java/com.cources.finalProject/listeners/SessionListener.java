package com.cources.finalProject.listeners;

import com.cources.finalProject.model.entities.Role;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.AbstractMap;
import java.util.HashSet;

/**
 * Listen actions with sessions
 */
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute("role", Role.UNKNOWN);
    }

    /**
     * Do something when session is destroying
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HashSet<String> loggedUsers = (HashSet<String>) se.getSession().getServletContext()
                .getAttribute("loggedUsers");
        String sessionLogin = (String)se.getSession().getAttribute("login");
        loggedUsers.remove(sessionLogin);
        se.getSession().getServletContext().setAttribute("loggedUsers", loggedUsers);
    }
}
