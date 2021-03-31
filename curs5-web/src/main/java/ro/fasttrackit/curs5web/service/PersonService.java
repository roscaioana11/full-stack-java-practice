package ro.fasttrackit.curs5web.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs5web.domain.Person;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final List<Person> persons = List.of(
            new Person(1, "Ana", 29),
            new Person(2, "Ioana", 32),
            new Person(3, "George", 59),
            new Person(4, "Paul", 19),
            new Person(5, "Victor", 22)
    );

    public List<Person> getAll(String name) {
        if (name == null) {
            return persons;
        } else {
            return persons.stream()
                    .filter(p -> p.getName().contains(name))
                    .collect(Collectors.toList());
        }
    }

    public Optional<Person> getPerson(int personId) {
        return persons.stream()
                .filter(p -> p.getId() == personId)
                .findFirst();
    }
}
