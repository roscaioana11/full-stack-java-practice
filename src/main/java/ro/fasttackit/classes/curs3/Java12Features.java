package ro.fasttackit.classes.curs3;


import ro.fasttackit.classes.curs3.additional.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.stream.IntStream;

import static java.text.NumberFormat.Style.SHORT;
import static java.util.Locale.US;
import static java.util.stream.Collectors.*;

public class Java12Features {
    public static void main(String[] args) throws IOException {
        filesMismatch();
        numberFormatting();
        teeingCollectors();
        stringMethods();
        instanceofPattern(new Person("Ana", 12, "test"));
    }

    private static void instanceofPattern(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            System.out.println(person.getName());
        } else if (obj instanceof String) {
            String str = (String) obj;
            System.out.println(str.length());
        }

        if (obj instanceof Person person) {
            System.out.println(person.getName());
        } else if (obj instanceof String str) {
            System.out.println(str.length());
        }


    }

    private static void stringMethods() {
        String row = "Ana are mere";
        System.out.println(row.indent(4));
        Person person = row.transform(s -> new Person(s, 10, "abc"));
        System.out.println(person);

    }

    private static void teeingCollectors() {
        double avg = IntStream.range(1, 100)
                .boxed()
                .collect(teeing(
                        summingDouble(i -> i),
                        counting(),
                        (sum, count) -> sum / count));
        System.out.println(avg);
    }

    private static void numberFormatting() {
        NumberFormat formatter = NumberFormat.getCompactNumberInstance(US, SHORT);
        System.out.println(formatter.format(100000003));
    }

    private static void filesMismatch() throws IOException {
        Path firstFile = Path.of("first.txt");
        Path secondFile = Path.of("second.txt");
        Path thirdFile = Path.of("third.txt");

        Files.writeString(firstFile, "content");
        Files.writeString(secondFile, "content");
        Files.writeString(thirdFile, "content different");

        System.out.println(Files.mismatch(firstFile, secondFile));
        System.out.println(Files.mismatch(firstFile, thirdFile));
    }
}
