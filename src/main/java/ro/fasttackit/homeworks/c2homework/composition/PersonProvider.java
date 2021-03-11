package ro.fasttackit.homeworks.c2homework.composition;

import ro.fasttackit.homeworks.c2homework.Person;

import java.util.List;

public interface PersonProvider {
    List<Person> readPeople();
}
