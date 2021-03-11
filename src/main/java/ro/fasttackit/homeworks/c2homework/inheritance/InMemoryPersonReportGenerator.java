package ro.fasttackit.homeworks.c2homework.inheritance;

import ro.fasttackit.homeworks.c2homework.Person;

import java.util.List;

public class InMemoryPersonReportGenerator extends PersonReportGenerator{
    @Override
    protected List<Person> readPeople() { //incarcare in memorie
        return List.of(
                new Person("Spitler","Delena",23),
                new Person("Shull","Kia",33),
                new Person("Malm","Meta",42),
                new Person("Cavalieri","Arnulfo",12),
                new Person("Halterman","Shaunte",56),
                new Person("Rasmussen","Gil",23),
                new Person("Gildersleeve","Janine",53),
                new Person("Paschal","Leo",33),
                new Person("Weimar","Azalee",24),
                new Person("Saint","Taina",64),
                new Person("Gautier","Tempie",22),
                new Person("Pinkham","Mack",54),
                new Person("Sensabaugh","Phyllis",63),
                new Person("Stach","Reena",12),
                new Person("Zucco","Bernardina",65),
                new Person("Fielden","Vinita",63),
                new Person("Ragland","Shannan",23),
                new Person("Cypher","Chanel",74),
                new Person("Renfrew","Cristine",21),
                new Person("Lennox","Shari",63)
        );
    }
}
