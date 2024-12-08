package sg.edu.nus.iss.vttp5a_day3l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.vttp5a_day3l.model.Person;
import sg.edu.nus.iss.vttp5a_day3l.service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
    
    @Autowired
    PersonService personService;

    @GetMapping()
    public String personListing(Model model){
        List<Person> persons = personService.findAll();
        model.addAttribute("persons", persons);
        return "personList";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        Person p = new Person();
        model.addAttribute("person", p);
        return "createPerson";
    }

    @PostMapping("/create")
    public String postCreateForm(@Valid Person person, BindingResult result, Model model){
        if (result.hasErrors()){
            return "createPerson";
        }
        Person p = new Person(person.getFirstName(), person.getLastName(), person.getSalary(),
        person.getEmail(), person.getDateOfBirth(), person.getTelephone(), person.getPostalCode());
        personService.create(p);
        return "redirect:/persons";
    }

    @GetMapping("/delete/{personId}")
    public String deletePerson(@PathVariable("personId") String personId){
        Person p = personService.findById(personId);
        personService.delete(p);

        return "redirect:/persons";
    }

    @GetMapping("/edit/{personId}")
    public String editPerson(@PathVariable("personId") String personId, Model model){
        Person pToUpdate = personService.findById(personId);
        model.addAttribute("person", pToUpdate);

        return "editPerson";
    }

    @PostMapping("/edit")
    public String postUpdatedPerson(@Valid @ModelAttribute Person person, BindingResult result, Model model){
        // System.out.println("Controller: " + person.getLastName());
        if (result.hasErrors()){
            return "editPerson";
        }
        personService.update(person);

        return "redirect:/persons";
    }

}
