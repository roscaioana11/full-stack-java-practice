package ro.fasttackit.homeworks.c3homework;

import java.util.ArrayList;
import java.util.List;

/**
 * LogicalSwitch simuleaza un switch/case in sensul ca acesta verifica daca o anumita conditie este indeplinita pentru a executa o functie
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person("Ioana", 25, "Cluj-Napoca");
        List<Person> people = new ArrayList<>();
        people.add(new Person("Ion", 35, "Arad"));
        people.add(new Person("Vlad", 16, "Otopeni"));

        String message = LogicalSwitch.switchPerson(predicate -> !people.contains(predicate), personPredicate -> {
            if(personPredicate.test(person)){
                people.add(person);
                return "Added Person";
            }
            return "Person already exists";
        });
        System.out.println(message);
        //test if exists
        message = LogicalSwitch.switchPerson(predicate -> !people.contains(predicate), personPredicate -> {
            if(personPredicate.test(person)){
                people.add(person);
                return "Added Person";
            }
            return "Person already exists";
        });
        System.out.println(message);
    }
}
