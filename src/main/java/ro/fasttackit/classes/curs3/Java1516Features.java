package ro.fasttackit.classes.curs3;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;

interface Being {
    String name();
}

public class Java1516Features {
    public static void main(String[] args) {
        records();
        sealedClasses();

        List<String> name = List.of();

        for (int i = 0; i < name.size(); i++) {
            System.out.println(name);
        }
        BiFunction<String, String, String> transform = (s, suffix) -> s + "string";
        transform.apply("a", "");
        name.forEach(Java1516Features::printName);
    }

    private static void printName(String name) {
        System.out.println(name);
    }

    private static void sealedClasses() {

    }

    private static void records() {
        var person = new People("Ana", 43);
        System.out.println(person.name());
        System.out.println(person.age());
        System.out.println(person.toString());
        var ana = new People("Ana", 43);
        System.out.println(ana);
        ana.getsOlder();
        System.out.println(ana);
        System.out.println(person.equals(ana));

    }
}

sealed abstract class Person permits Student, Teacher, Director {
    abstract String name();
}

final class Student extends Person {
    @Override
    String name() {
        return "studnet";
    }
}

sealed class Director extends Person {
    @Override
    String name() {
        return "director";
    }
}

final class DirectorAdjunct extends Director {
}

final class DirectorPrincipal extends Director {
}

non-sealed class Teacher extends Person {

    @Override
    String name() {
        return "teacher";
    }
}

class MathTeacher extends Teacher {
}

record People(String name, AtomicInteger age) implements Being {
    public People {
        if (age.get() > 18) {
            name = "ms. " + name;
        }
    }

    public People(String name, int age) {
        this(name, new AtomicInteger(age));
    }

    public People(String name) {
        this(name, new AtomicInteger(20));
    }

    public void getsOlder() {
        age.incrementAndGet();
    }
}


class PersonOld {
    private final String name;
    private final int age;

    PersonOld(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonOld personOld = (PersonOld) o;
        return age == personOld.age &&
                Objects.equals(name, personOld.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
