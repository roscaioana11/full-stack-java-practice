package ro.fasttackit.classes.curs3;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.entry;
import static java.util.stream.Collectors.groupingBy;

public class Java8Features {
    public static void main(String[] args) {
        lambdas();
        streams();
        optional();
        methodRefs();
        forEachCollections();
        timeApi();
    }

    private static void timeApi() {
        LocalDate onlyDate = LocalDate.of(2021, Month.APRIL, 10);
        LocalDateTime dateTime = LocalDateTime.now();
        Date date = new Date(dateTime.toInstant(ZoneOffset.UTC).toEpochMilli());
        Optional<Date> date1 = Optional.of(dateTime)
                .map(dt -> dt.toInstant(ZoneOffset.UTC))
                .map(Instant::toEpochMilli)
                .map(Date::new);
    }

    private static void forEachCollections() {
        List.of("abc").forEach(System.out::println);
        Map.of("a", "c", "d", "e").forEach(Java8Features::printEntry);
        Map.ofEntries(
                entry("key", "value")
        );
    }

    private static void printEntry(String key, String value) {
        System.out.println(key + " = " + value);
    }

    private static void methodRefs() {
        List<Integer> collect = names().stream()
                .map(String::length) // name->name.length()
//                .map(Java8Features::toLength) //name-> toLenght(name)
                .collect(Collectors.toList());

        Optional.of(List.of("abc"))
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
    }

    private static int toLength(String s) {
        return s.length();
    }

    private static void optional() {
        Optional<String> ana = names().stream()
                .filter(name -> name.equalsIgnoreCase("Ana Popescu"))
                .map(name -> "Ana-Maria Popescu")
                .findFirst();

        ana.ifPresent(System.out::println);
        String name = ana.orElse("Ioan");
        System.out.println(name);
        if (ana.isPresent()) {
            String s = ana.get();
        }

        System.out.println("-------------------");
        String result = names().stream()
                .filter(n -> n.startsWith("R"))
                .findFirst()
                .orElse(createEntry());
        System.out.println(result);

        System.out.println("----------orElseGet-------------");
        String resultGet = names().stream()
                .filter(n -> n.startsWith("R"))
                .findFirst()
                .orElseGet(() -> createEntry());
        System.out.println(resultGet);
        Optional<String> myId = Optional.empty();

        myId.ifPresent(Java8Features::findById);

//        Optional<String> item = findById(myId);

    }

    private static Optional<String> findById(String id) {
        Optional.of("abc");
        String a = null;
        Optional.ofNullable(a);
        return Optional.empty();
    }

    private static String createEntry() {
        System.out.println("heavy processing");
        return "Ioan";
    }

    private static void streams() {
        System.out.println(names().stream()
                .filter(name -> name.length() < 10)
                .count());

        names().stream()
                .filter(name -> name.length() < 10)
                .map(Java8Features::abbreviate)
                .forEach(System.out::println);

        Map<Character, List<String>> byFirstLetter = names()
                .parallelStream()
                .peek(n -> System.out.println(Thread.currentThread().getName()))
                .collect(groupingBy(n -> n.charAt(0)));


        System.out.println(byFirstLetter);

        Map.of("key", "value")
                .forEach((key, value) -> System.out.println("key: " + key + " = " + value));
    }

    private static String abbreviate(String name) {
        String[] parts = name.split(" ");
        return parts[0] + " " + parts[1].charAt(0) + ".";
    }

    private static List<String> names() {
        return List.of("Isabell Bushman",
                "Wendolyn Roiger",
                "Magaret Demyan",
                "Corene Strang",
                "Marcie Fausnaught",
                "Valerie Maselli",
                "Terresa Ritenour",
                "Tamra Theiss",
                "Tyler Knicely",
                "Shenita Kerner",
                "Foster Keeney",
                "Nina Mulhall",
                "Reginia Peralto",
                "Daria Obando",
                "Sona Poff",
                "Gema Mink",
                "Delbert Kamp",
                "Tandra Wuensche",
                "Terrell Boelter",
                "Kyle Bassi");
    }

    private static void lambdas() {
        A a = new A();
        System.out.println(a.sayHello("Bogdan"));

        MyInterface b = Java8Features::doHello;
        use(n -> n + " ceva");

        use(new MyInterface() {
            @Override
            public String sayHello(String name) {
                return name + " ceva";
            }
        });
    }

    private static void use(MyInterface logic) {

    }

    private static String doHello(String name) {
        System.out.println("hello");
        return "salut " + name;
    }
}

@FunctionalInterface
interface MyInterface {
    public static final String NAME = "MyInterface";

    String sayHello(String name);

    default String withImplementation() {
        return "salutare" + sayHello("Ioan");
    }
}

class A implements MyInterface {

    @Override
    public String sayHello(String name) {
        return "salut " + name;
    }
}
