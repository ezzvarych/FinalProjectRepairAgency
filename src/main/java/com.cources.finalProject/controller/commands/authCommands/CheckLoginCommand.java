package com.cources.finalProject.controller.commands.authCommands;

import com.cources.finalProject.controller.commands.Command;
import com.cources.finalProject.controller.mapper.PersonMapper;
import com.cources.finalProject.model.dto.PersonDTO;
import com.cources.finalProject.model.entities.Person;
import com.cources.finalProject.model.entities.Role;
import com.cources.finalProject.model.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Handle user logging process
 */
public class CheckLoginCommand implements Command {

    private PersonService personService;
    /**
     * Mapping, which will be returned according to logged user role
     */
    private Map<Role, String> rolesMapping = new HashMap<>();

    public CheckLoginCommand(PersonService personService) {
        this.personService = personService;

        rolesMapping.put(Role.UNKNOWN, "/index.jsp");
        rolesMapping.put(Role.CUSTOMER, "redirect:/customer");
        rolesMapping.put(Role.MASTER, "redirect:/master");
        rolesMapping.put(Role.MANAGER, "redirect:/manager");
        rolesMapping.put(Role.ADMIN, "redirect:/admin");
    }

    @Override
    public String execute(HttpServletRequest request) throws ServletException {
        //GET USER FROM FROM
        PersonDTO dto = PersonMapper.loginExtractFromRequest(request);
        //IF USER IS ALREADY LOGGED, RETURN APPROPRIATE PAGE
        if (CommandUtility.isUserLogged(request, dto.getLogin())) {
            Role userRole = CommandUtility.getSessionUser(request, dto.getLogin()).getValue();
            return rolesMapping.get(userRole);
        }
        //COMPARING DATA FROM REQUEST WITH DATA FROM DB
        Optional<Person> optionalPerson = personService.getByLoginOrEmail(dto.getLogin());
        if (optionalPerson.isPresent() && optionalPerson.get().getPassword().equals(dto.getPassword())) {
            Person p = optionalPerson.get();
            CommandUtility.saveUser(request, p.getLogin(), p.getRole());
            return rolesMapping.get(p.getRole());
        }
        return rolesMapping.get(Role.UNKNOWN);
    }
}
