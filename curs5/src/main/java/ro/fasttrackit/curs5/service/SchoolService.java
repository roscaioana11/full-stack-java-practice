package ro.fasttrackit.curs5.service;

import org.springframework.stereotype.Service;

@Service
public class SchoolService {
    private final PersonService personService;

    public SchoolService(PersonService personService) {
        this.personService = personService;
        System.out.println("in school" + personService);
        personService.setName("this is school service persons");

    }

    public void doSomething() {
        System.out.println("school service : " + this.personService.getName());
    }
}
