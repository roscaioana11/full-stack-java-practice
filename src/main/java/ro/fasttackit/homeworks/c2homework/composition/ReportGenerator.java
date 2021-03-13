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

    public void generatePersonReport(String outputFile, List<Integer> ageRanges) throws IOException{
        List<Person> people = peopleProvider.readPeople();
        writeReport(people, outputFile, ageRanges);
    }

    private void writeReport(List<Person> people,String outputFile, List<Integer> ageRanges) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            for(int i = 0; i < ageRanges.size(); i++){
                int min = 0;
                int max = 0;
                if(i - 1 >= 0){
                    min = ageRanges.get(i - 1);
                }
                max = ageRanges.get(i);
                writeAgeRange(people, min, max, writer);
                writeToFile(writer, "", true);
            }
        }
    }

    public void writeAgeRange(List<Person> people, int min, int max, BufferedWriter writer){
        writeToFile(writer,min + "-" + max + ": ", false);
        people.stream()
                .filter(person -> person.getAge() > min)
                .filter(person -> person.getAge() <= max)
                .map(person -> person.getLastName() + " " + person.getFirstName() + ",")
                .forEach(line -> writeToFile(writer, line, false));
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
