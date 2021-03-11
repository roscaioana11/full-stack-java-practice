package ro.fasttackit.homeworks.c2homework;

import ro.fasttackit.homeworks.c2homework.composition.FilePersonProvider;
import ro.fasttackit.homeworks.c2homework.composition.InMemoryPersonProvider;
import ro.fasttackit.homeworks.c2homework.composition.PersonProvider;
import ro.fasttackit.homeworks.c2homework.composition.ReportGenerator;
import ro.fasttackit.homeworks.c2homework.inheritance.FilePersonReportGenerator;
import ro.fasttackit.homeworks.c2homework.inheritance.InMemoryPersonReportGenerator;

import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        //First exercise
//        Scanner scan = new Scanner(System.in);
//        System.out.println("If my weight on Earth is: ");
//        double weight = scan.nextDouble();
//        System.out.println("Then my weight on another planet is: " + Planet.PLUTO.getWeightOnAnotherPlanet(weight));

        //Second exercise - Inheritance
        var inheritanceFilePeopleGenerator = new FilePersonReportGenerator("src/main/resources/people.txt");
        inheritanceFilePeopleGenerator.generateReport("output1.txt");
        var inheritanceInMemoryPeopleGenerator = new InMemoryPersonReportGenerator();
        inheritanceInMemoryPeopleGenerator.generateReport("output2.txt");

        //Second exercise - Composition
        PersonProvider fileProvider = new FilePersonProvider("src/main/resources/people.txt");
        var fileGenerator = new ReportGenerator(fileProvider);
        fileGenerator.generatePersonReport("output3.txt");
        PersonProvider inMemoryProvider = new InMemoryPersonProvider();
        var inMemoryGenerator = new ReportGenerator(inMemoryProvider);
        inMemoryGenerator.generatePersonReport("output4.txt");
    }
}
