package ro.fasttackit.homeworks.c3homework;

import java.util.ArrayList;
import java.util.List;

/**
 * LogicalSwitch simuleaza un switch/case
 * acesta primeste un parametru persoana si aplica tot felul de teste pe aceasta persoana, returnand numa rezultatul testelor care au avut succes
 */
public class Test {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Ion", 35, "Arad"));
        people.add(new Person("Vlad", 31, "Otopeni"));
        people.add(new Person("Ioana", 25, "Cluj-Napoca"));

        LogicalSwitch logicalSwitch = new LogicalSwitch();
        logicalSwitch.put(person -> person.getName().length() >= 4,
                predicate -> "Lungimea numelui este mai mare ca si 3 caractere");
        logicalSwitch.put(person -> person.getAge() < 30,
                predicate -> "Varsta persoanei este mai mica de 30");

        List<String> messages = logicalSwitch.process(people.get(0));
        messages.stream()
                .forEach(message -> System.out.println(message));

        messages = logicalSwitch.process(people.get(1));
        messages.stream()
                .forEach(message -> System.out.println(message));

        System.out.println("");

        messages = logicalSwitch.process(people.get(2));
        messages.stream()
                .forEach(message -> System.out.println(message));
    }
}
