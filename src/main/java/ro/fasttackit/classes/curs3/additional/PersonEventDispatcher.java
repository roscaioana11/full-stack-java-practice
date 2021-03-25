package ro.fasttackit.classes.curs3.additional;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

public class PersonEventDispatcher {
    private final Map<Predicate<Person>, Function<Person, String>> logicalSwitch = new HashMap<>();

    public PersonEventDispatcher() {
        logicalSwitch.put(p -> p.getName().length() > 10, Person::getName);
        logicalSwitch.put(person -> nameStartsWith(person, "A"), this::messageForStartsWith);
        logicalSwitch.put(person -> person.getAge() > 18, this::goVote);
        logicalSwitch.put(person -> person.getAddress().equalsIgnoreCase("Oradea"), this::goToUnirii);
    }

    public static void main(String[] args) {
        PersonEventDispatcher dispatcher = new PersonEventDispatcher();
        Person person = new Person("Ana", 22, "Oradea");
        System.out.println(dispatcher.dipatch(person));
    }

    public String dipatch(Person person) {
        return logicalSwitch.entrySet().stream()
                .filter(entry -> entry.getKey().test(person))
                .map(entry -> entry.getValue().apply(person))
                .collect(joining(lineSeparator()));
    }

    private String goToUnirii(Person person) {
        return "I'm going to piata unirii";
    }

    private String goVote(Person person) {
        return "Voted for me";
    }

    private String messageForStartsWith(Person person) {
        return person.getName() + " starts with A";
    }

    private boolean nameStartsWith(Person person, String letter) {
        return person.getName().startsWith(letter);
    }
}
