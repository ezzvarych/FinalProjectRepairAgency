package com.cources.finalProject.controller.commands.authCommands;

import com.cources.finalProject.controller.annotations.RequestMapping;
import com.cources.finalProject.controller.commands.Command;
import com.cources.finalProject.controller.mapper.PersonMapper;
import com.cources.finalProject.model.entities.Person;
import com.cources.finalProject.model.service.PersonService;
import com.cources.finalProject.validation.RegExpConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * Handle user register
 */
@RequestMapping
public class CheckRegisterCommand implements Command {

    private PersonService personService;

    public CheckRegisterCommand(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Person requestPerson = PersonMapper.registrationExtractFromRequest(request);
        if (!isValidUser(requestPerson)) {
            request.setAttribute("badRegister", "Input valid params in form");
            return "/registration.jsp";
        }
        personService.create(requestPerson);
        return "redirect:/login";
    }

    private boolean isValidUser(Person user) {
        return user.getLogin().matches(RegExpConstants.LOGIN_VALID_REGEXP) &&
                user.getEmail().matches(RegExpConstants.EMAIL_VALID_REGEXP);
    }
}
