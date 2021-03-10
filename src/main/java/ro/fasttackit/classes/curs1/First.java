package ro.fasttackit.classes.curs1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class First {

    public static void main(String[] args) { //poti da call la o functie in alta functie dar nu poti sa definesti o functie in alta functie
        immutabilityExercise();


        builderExercise();
        testShortcuts();

    }

    private static void immutabilityExercise() {
        List<Integer> grades = new ArrayList<>();
        grades.add(10);
        Student student = new Student("student", grades);
//        Student ana = new Student("Ana", List.of(1, 9));
        new Student("Gabi", null);
        System.out.println(student.toString());
        grades.clear();

        List<Integer> internalGrades = student.getGrades();
        internalGrades.clear();

        System.out.println(student.toString());
    }

    private static void builderExercise() {
        Person person = Person.PersonBuilder.person()
                .name("Andrei")
                .age(12)
                .build();

        System.out.println(person);
    }

    private static void testShortcuts() {
        GreatTable myGreatTable = new GreatTable(102, "red");
        myGreatTable.getColor();

        System.out.println("Hello FasttrackIT!");

        if (false) {
            if (true) {
                System.out.println("Ceva");
            }
        }
        String value = "test";

        List<String> test = new ArrayList<>();
        test.add(value + "-test2");
        test.add("ceva-test1");
        test.add("ceva-test2");
        test.add("ceva-test3");
        test.add("ceva-test4");
        test.add("ceva-test5");
        test.add("ceva-test6");
        test.add("ceva-test7");
        test.add("ceva-test8");
        test.add("ceva-test9");
        String another = "alt";

        System.out.println(test);
        System.out.println(another);
        int cost = calculateCost("BigMac");
        if (cost > 10000) {
            System.out.println("Too much");
        }
        int mere = calculateCost("mere");

        Map<Integer, String> integerStringMap = bigMap();
        Map<Integer, String> myMap = integerStringMap;
    }

    private static Map<Integer, String> bigMap() {
        return Map.of();
    }

    private static int calculateCost(String product) {
        return 0;
    }

}
