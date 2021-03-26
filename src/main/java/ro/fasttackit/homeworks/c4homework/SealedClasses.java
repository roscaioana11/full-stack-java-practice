package ro.fasttackit.homeworks.c4homework;

import java.util.ArrayList;
import java.util.List;

sealed interface Animal permits Dog, Cat, Bird, Insects{
    String noise();
}

public class SealedClasses {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat("Luna"));
        animals.add(new Bird());
        animals.add(new Parrot());
        animals.add(new Chicken());
        animals.add(new Fly());
        animals.add(new LadyBug("Cocinella Septempunctata"));

        animals.stream()
                .forEach(animal -> System.out.println(animal.noise()));
    }
}

final class Dog implements Animal{
    @Override
    public String noise() {
        return "ham";
    }
}

record Cat(String name) implements Animal{
    @Override
    public String noise() {
        return "miau";
    }
}

sealed class Bird implements Animal permits Parrot, Chicken{
    @Override
    public String noise() {
        return "cip";
    }
}

/**
 * record Canary nu poate extinde sealed class Bird
 * doar daca aceasta este modificata intr-o interfata sealed, permitand implementarea
 */
//record Canary(String name) extends Bird {
//
//}

final class Parrot extends Bird {

}

non-sealed class Chicken extends Bird {

}

non-sealed interface Insects extends Animal {

}

class Fly implements Insects{
    @Override
    public String noise() {
        return "bzz";
    }
}

record LadyBug(String name) implements Insects{
    @Override
    public String noise() {
        return "brrz";
    }
}
