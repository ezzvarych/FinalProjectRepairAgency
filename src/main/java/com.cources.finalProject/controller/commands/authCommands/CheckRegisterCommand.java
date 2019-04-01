package com.cources.finalProject.controller.commands.authCommands;

import com.cources.finalProject.controller.commands.Command;
import com.cources.finalProject.controller.mapper.PersonMapper;
import com.cources.finalProject.model.dto.PersonDTO;
import com.cources.finalProject.model.entities.Person;
import com.cources.finalProject.model.service.PersonService;
import com.cources.finalProject.validation.RegExpConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class CheckRegisterCommand implements Command {

    private PersonService personService;

    public CheckRegisterCommand(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        PersonDTO requestPerson = PersonMapper.registrationExtractFromRequest(request);
        System.out.println(requestPerson);
        if (!isValidUser(requestPerson)) {
            request.setAttribute("badRegister", "Input valid params in form");
            return "/registration.jsp";
        }
        Optional<Person> checkLogin = personService.getByLogin(requestPerson.getLogin());
        if (checkLogin.isPresent()) {
            request.setAttribute("badRegister", "User with this login is already existing");
            return "/registration.jsp";
        }
        personService.create(PersonDTO.getPersonFromDto(requestPerson));
        return "redirect:/login";
    }

    private boolean isValidUser(PersonDTO user) {
        return user.getLogin().matches(RegExpConstants.LOGIN_VALID_REGEXP) &&
                user.getEmail().matches(RegExpConstants.EMAIL_VALID_REGEXP);
    }
}
