package ro.fasttackit.homeworks.c4homework;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

public class StudentEventDispatcher {
    private final Map<Predicate<Integer>, Function<Integer, String>> logicalSwitch = new HashMap<>();

    public StudentEventDispatcher() {
        logicalSwitch.put(number -> number < 3, number -> concatGrade("1st"));
        logicalSwitch.put(number -> number == 3, number -> concatGrade("5th"));
        logicalSwitch.put(number -> number > 3, number -> concatGrade("7th"));
    }

    public String concatGrade(String grade){
        return grade + " grade";
    }

    public String dispatch (int studentIndex){
        return logicalSwitch.entrySet().stream()
                .filter(entry -> entry.getKey().test(studentIndex))
                .map(entry -> entry.getValue().apply(studentIndex))
                .collect(joining(lineSeparator()));
    }
}
