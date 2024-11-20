package sg.edu.nus.iss.vttp5a_day3l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.vttp5a_day3l.model.Person;
import sg.edu.nus.iss.vttp5a_day3l.service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    PersonService personService;
    
    @GetMapping()
    public String personListing(Model model) {

        List<Person> persons = personService.findAll();
        model.addAttribute("persons", persons);
        return "personlist";
        
    }

    @GetMapping(path = "/create")
    public String createForm(Model model) {
        Person p = new Person();
        model.addAttribute("person", p);
        return "personcreate";
    }

}
