package com.cources.finalProject.controller.commands.authCommands;

import com.cources.finalProject.controller.annotations.RequestMapping;
import com.cources.finalProject.controller.commands.Command;
import com.cources.finalProject.controller.mapper.PersonMapper;
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
@RequestMapping
public class CheckLoginCommand implements Command {

    private PersonService personService;
    /**
     * Mapping, which will be returned according to logged user role
     */
    private Map<Role, String> rolesMapping = new HashMap<>();

    public CheckLoginCommand(PersonService personService) {
        this.personService = personService;

        rolesMapping.put(Role.UNKNOWN, "/index.jsp");
        rolesMapping.put(Role.CUSTOMER, "redirect:/customer/main");
        rolesMapping.put(Role.MASTER, "redirect:/master/main");
        rolesMapping.put(Role.MANAGER, "redirect:/manager/main");
        rolesMapping.put(Role.ADMIN, "redirect:/admin/main");
    }

    @Override
    public String execute(HttpServletRequest request) throws ServletException {
        //GET USER FROM FORM
        Person person = PersonMapper.loginExtractFromRequest(request);
        //IF USER IS ALREADY LOGGED, RETURN MAIN PAGE
        if (CommandUtility.isUserLogged(request, person.getLogin())) {
            Person sessionUser = (Person) request.getSession().getAttribute("sessionUser");
            return rolesMapping.get(sessionUser.getRole());
        }
        //COMPARING DATA FROM REQUEST WITH DATA FROM DB
        Optional<Person> optionalPerson = personService.getByLoginOrEmail(person.getLogin());
        if (optionalPerson.isPresent() && optionalPerson.get().getPassword().equals(person.getPassword())) {
            Person p = optionalPerson.get();
            CommandUtility.saveUser(request, p);
            return rolesMapping.get(p.getRole());
        }
        return rolesMapping.get(Role.UNKNOWN);
    }
}
