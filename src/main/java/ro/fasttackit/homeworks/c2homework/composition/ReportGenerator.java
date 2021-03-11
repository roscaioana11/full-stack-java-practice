package ro.fasttackit.homeworks.c2homework.composition;

import ro.fasttackit.homeworks.c2homework.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportGenerator {
    private final PersonProvider peopleProvider;

    public ReportGenerator(PersonProvider peopleProvider) {
        this.peopleProvider = peopleProvider;
    }

    public void generatePersonReport(String outputFile) throws IOException{
        List<Person> people = peopleProvider.readPeople();
        writeReport(people, outputFile);
    }

    private void writeReport(List<Person> people,String outputFile) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            writeToFile(writer,"1-30: ", false);
            people.stream()
                    .filter(person -> person.getAge() <= 30)
                    .map(person -> person.getLastName() + " " + person.getFirstName() + ",")
                    .forEach(line -> writeToFile(writer, line, false));
            writeToFile(writer,"30-50: ", true);
            people.stream()
                    .filter(person -> person.getAge() > 30 && person.getAge() <= 50)
                    .map(person -> person.getLastName() + " " + person.getFirstName() + ",")
                    .forEach(line -> writeToFile(writer, line, false));
            writeToFile(writer,"50+: ", true);
            people.stream()
                    .filter(person -> person.getAge() > 50)
                    .map(person -> person.getLastName() + " " + person.getFirstName() + ",")
                    .forEach(line -> writeToFile(writer, line, false));
        }
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
