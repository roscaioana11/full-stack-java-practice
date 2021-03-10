package ro.fasttackit.classes.curs1;

import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

public class Student {
    private final String name;
    private final List<Integer> grades;

    public Student(String name, List<Integer> grades) {
        this.name = name;
        this.grades = ofNullable(grades)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
        this.grades.add(10);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }
}
