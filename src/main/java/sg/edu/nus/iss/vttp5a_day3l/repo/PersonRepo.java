package sg.edu.nus.iss.vttp5a_day3l.repo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_day3l.model.Person;

@Repository
public class PersonRepo {
    private List<Person> persons;

    public PersonRepo() throws ParseException, IOException{
        this.persons = readFile();
        // String birthDate = "1998-02-01";
        // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // persons.add(new Person("Jack", "Daniel", 12000, "jackdaniel@gmail.com",formatter.parse(birthDate), "96557822", 668557));
    }

    private List<Person> readFile() throws ParseException, IOException{
        List<Person> listOfPerson = new ArrayList<>();
        File fileToRead = new File("data/output.txt");
        BufferedReader br = new BufferedReader(new FileReader(fileToRead));
        String line = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        while((line = br.readLine()) != null){
            String[] lineSplit = line.split(",");
            Map<String, String> personMap = new HashMap<>();
            for(String attribute:lineSplit){
                String[] attributeSplit = attribute.split(":");
                personMap.put(attributeSplit[0].trim(), attributeSplit[1].trim());
            }
            listOfPerson.add(new Person(personMap.get("firstName"), personMap.get("lastName"), Integer.parseInt(personMap.get("Salary")), personMap.get("Email"), formatter.parse(personMap.get("Date of Birth")), personMap.get("Telephone"), Integer.parseInt(personMap.get("Postal Code"))));
        }
        br.close();
        return listOfPerson;

    }

    public boolean saveFile() throws IOException{
        File fileToEdit = new File("data/output.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileToEdit));
        for(Person person: persons){
            bw.write(person.toString());
            bw.newLine();
        }
        bw.close();
        return true;
    }

    public List<Person> listAll(){
        return this.persons;
    }

    public boolean create(Person person){
        return persons.add(person);
    }

    public boolean delete(Person person){
        if(persons.contains(person)){
            persons.remove(persons.indexOf(person));
            return true;
        } else {
            return false;
        }
    }

    public Person findById(String personId){
        return persons.stream().filter(p -> p.getId().equals(personId)).findFirst().get();
    }

    public boolean update(Person person){
        Person filteredPersons = findById(person.getId());
        if(filteredPersons != null){
            delete(filteredPersons);
            create(person);
            return true;
        }
        return false;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
    
}
