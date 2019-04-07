package com.cources.finalProject.controller.listeners;

import com.cources.finalProject.model.entities.Person;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;

/**
 * Listen actions with sessions
 */
public class SessionListener implements HttpSessionListener {

//    @Override
//    public void sessionCreated(HttpSessionEvent se) {
//        se.getSession().setAttribute("role", Role.UNKNOWN);
//    }

    /**
     * Do something when session is destroying
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HashSet<String> loggedUsers = (HashSet<String>) se.getSession().getServletContext()
                .getAttribute("loggedUsers");
        Person sessionUser = (Person)se.getSession().getAttribute("sessionUser");
        String sessionLogin = sessionUser.getLogin();
        loggedUsers.remove(sessionLogin);
        se.getSession().getServletContext().setAttribute("loggedUsers", loggedUsers);
    }
}
