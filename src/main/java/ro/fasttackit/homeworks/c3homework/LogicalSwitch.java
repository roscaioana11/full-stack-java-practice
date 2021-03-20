package ro.fasttackit.homeworks.c3homework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class LogicalSwitch {
    private Map<Predicate<Person>, Function<Predicate<Person>, String>> switchMap;

    public LogicalSwitch() {
        this.switchMap = new HashMap<>();
    }

    public void put(Predicate<Person> predicate, Function<Predicate<Person>, String> function){
        switchMap.put(predicate, function);
    }

    public List<String> process(Person person){
        return switchMap.keySet().stream()
                .filter(predicate -> predicate.test(person))
                .map(predicate -> switchMap.get(predicate).apply(predicate))
                .collect(toList());
        //return switchMap.get(predicate).apply(predicate);
    }
}
