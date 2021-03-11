package ro.fasttackit.homeworks.c2homework.inheritance;

import ro.fasttackit.homeworks.c2homework.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FilePersonReportGenerator extends PersonReportGenerator{ //citire din fisier
    private final String sourceFile;

    public FilePersonReportGenerator(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    @Override
    protected List<Person> readPeople() {
        try {
            //clasa Files din Java ajuta sa citesti un fisier, Files.lines - inseamna ca citeste cate o linie deodata
            return Files.lines(Path.of(sourceFile))
                    .map(line -> readPerson(line))
                    .collect(toList());
        } catch (IOException e) {
            System.err.println("Could not read from file " + sourceFile);
        }
        return List.of();
    }

    private Person readPerson(String line){
        //transforma o linie de text intr-o persoana (citeste un String si il face Person)
        String[] personInfo = line.split(",");
        return new Person(
                personInfo[1],
                personInfo[0],
                Integer.parseInt(personInfo[2])
        );
    }
}
