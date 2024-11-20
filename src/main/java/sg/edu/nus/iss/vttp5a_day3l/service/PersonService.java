package sg.edu.nus.iss.vttp5a_day3l.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_day3l.model.Person;
import sg.edu.nus.iss.vttp5a_day3l.repo.PersonRepo;

@Service
public class PersonService {
    @Autowired
    PersonRepo personRepo;

    public List<Person> findAll() {
        return personRepo.findAll();
    }

    public Boolean create(Person person) {
        return personRepo.create(person);
    }

    public Boolean delete(Person person) {
        return personRepo.delete(person);
    }

    public Boolean update(Person person) {
        return personRepo.update(person);
    }
}
