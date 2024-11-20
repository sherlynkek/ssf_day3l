package sg.edu.nus.iss.vttp5a_day3l.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
        model.addAttribute("persons",persons);
        return "personlist";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("person", new Person());
        return "personcreate";
    }

    @PostMapping("/create")
    public String postPerson(@Valid Person person, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return "personcreate";
        }
        Person p = new Person(person.getFirstName(), person.getLastName(), person.getSalary(), person.getEmail(), person.getDob(), person.getTelephone(), person.getPostalCode());
        personService.create(p);
        return "redirect:/persons";
    }

    @GetMapping("/delete/{person-id}")
    public String deletePerson(@PathVariable("person-id") String personId){
        Person p = personService.findById(personId);
        personService.delete(p);
        return "redirect:/persons";
    }

    @GetMapping("/edit/{person-id}")
    public String editPerson(@PathVariable("person-id") String personId, Model model){
        Person p = personService.findById(personId);
        model.addAttribute("person", p);
        return "personupdate";
    }

    @PostMapping("/edit")
    public String postUpdateForm(@Valid Person person, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "personupdate";
        } 
        personService.update(person);
        return "redirect:/persons";
    }

    @GetMapping("/savelist")
    public String saveList() throws IOException{
        boolean success = personService.saveFile();
        return "redirect:/persons";
    }
}
