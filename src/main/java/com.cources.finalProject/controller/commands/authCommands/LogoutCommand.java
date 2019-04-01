package com.cources.finalProject.controller.commands.authCommands;

import com.cources.finalProject.controller.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Handle logout
 */
public class LogoutCommand implements Command {
    /**
     * Finish session
     * @param request
     * @return
     * @throws ServletException
     */
    @Override
    public String execute(HttpServletRequest request) throws ServletException {
        request.getSession().invalidate();
        return "redirect:/";
    }
}
