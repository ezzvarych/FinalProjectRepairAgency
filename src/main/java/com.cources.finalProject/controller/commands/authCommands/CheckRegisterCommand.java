package com.cources.finalProject.controller.commands.authCommands;

import com.cources.finalProject.controller.commands.Command;
import com.cources.finalProject.models.dto.UserDTO;
import com.cources.finalProject.validation.RegExpConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class CheckRegisterCommand implements Command {

    String existedLogin = "admin";

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println(request.getRequestURI());
        UserDTO userDTO = (UserDTO) request.getAttribute("userDTO");
        if (!isValidUser(userDTO)) {
            request.setAttribute("badRegister", "Input valid params in form");
            return "/app/registration";
        }
        if (!userDTO.getLogin().equals(existedLogin)) {
            System.out.println("User is registered");
            return "redirect:/app/login";
        } else {
            request.setAttribute("badRegister", "User with this login is already existing");
            return "/app/registration";
        }
    }

    private boolean isValidUser(UserDTO user) {
        return user.getLogin().matches(RegExpConstants.LOGIN_VALID_REGEXP) &&
                (user.getEmailOrPhone().matches(RegExpConstants.EMAIL_VALID_REGEXP) ||
                        user.getEmailOrPhone().matches(RegExpConstants.PHONE_VALID_REGEXP));
    }
}
