package ro.fasttackit.homeworks.c2homework.inheritance;

import ro.fasttackit.homeworks.c2homework.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

abstract class PersonReportGenerator { //in acelasi loc, metodele nu le mai scrie din nou unde au fost mostenite pt ca deja exista aici

    public void generateReport(String outputFile, List<Integer> ageRanges) throws IOException{
        List<Person> people = readPeople();
        writeReport(people, outputFile, ageRanges);
    }

    public void writeReport(List<Person> people,String outputFile, List<Integer> ageRanges) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writeAgeRange(people,ageRanges,writer);
        }
    }

    public void writeAgeRange(List<Person> people, List<Integer> ageRanges, BufferedWriter writer){
        people.stream()
                .collect(groupingBy(person -> person.getAgeRange(ageRanges), LinkedHashMap::new, toList())) //HashMap nu ordoneaza lista, LinkedHashMap ordoneaza lista
                .forEach((keyAgeRange, valuePeople) -> writePeopleToFile(writer, valuePeople, keyAgeRange));
    }

    private void writePeopleToFile(BufferedWriter writer, List<Person> people, String groupName){
        writeToFile(writer, groupName + ": ", false);
        people.stream()
                .map(person -> person.getLastName() + " " + person.getFirstName() + ",")
                .forEach(line -> writeToFile(writer, line, false));
        writeToFile(writer, "", true);
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

    protected abstract List<Person> readPeople();
}
