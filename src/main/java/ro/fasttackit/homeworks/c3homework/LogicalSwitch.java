package ro.fasttackit.homeworks.c3homework;

import java.util.function.Function;
import java.util.function.Predicate;

public class LogicalSwitch {
    public static String switchPerson(Predicate<Person> predicatePerson,Function<Predicate<Person>, String> functionPredicatePerson){
        return functionPredicatePerson.apply(predicatePerson);
    }
}
