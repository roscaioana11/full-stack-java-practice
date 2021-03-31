package ro.fasttrackit.curs5web.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs5web.domain.Person;
import ro.fasttrackit.curs5web.service.PersonService;

import java.util.List;

//Layers: controller - service - repository
@RestController
@RequestMapping("persons") // localhost:8080/persons
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    List<Person> getAllPersons(@RequestParam(required = false) String name) {
        return service.getAll(name);
    }

    @GetMapping("{personId}")
    Person getPerson(@PathVariable int personId) {
        return service.getPerson(personId)
                .orElseThrow(() -> new RuntimeException("Could not find person with id " + personId));
    }
}
