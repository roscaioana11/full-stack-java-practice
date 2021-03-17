package ro.fasttackit.homeworks.c2homework.composition;

import ro.fasttackit.homeworks.c2homework.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ReportGenerator { //separat pt composition
    private final PersonProvider peopleProvider;

    public ReportGenerator(PersonProvider peopleProvider) {
        this.peopleProvider = peopleProvider;
    }

    public void generatePersonReport(String outputFile, List<Integer> ageRanges) throws IOException{
        List<Person> people = peopleProvider.readPeople();
        writeReport(people, outputFile, ageRanges);
    }

    private void writeReport(List<Person> people,String outputFile, List<Integer> ageRanges) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            writeAgeRange(people, ageRanges,writer);
        }
    }

    public void writeAgeRange(List<Person> people, List<Integer> ageRanges, BufferedWriter writer){
        people.stream()
                .collect(Collectors.groupingBy(person -> person.getAgeRange(ageRanges),LinkedHashMap::new, Collectors.toList()))
                .forEach((keyAgeRange, valuePeople) -> {
                    writeToFile(writer, keyAgeRange + ": ", false);
                    valuePeople.stream()
                            .map(person -> person.getLastName() + " " + person.getFirstName() + ",")
                            .forEach(line -> writeToFile(writer, line, false));
                    writeToFile(writer, "", true);
                });
    }

    private void writeToFile(BufferedWriter writer,String line, boolean isNewLine) {
        try {
            if(isNewLine){
                writer.newLine();
            }
            writer.write(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
