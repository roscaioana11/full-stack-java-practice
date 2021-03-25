package ro.fasttackit.classes.curs3;

enum Cardinal {
    NORD,
    SOUTH,
    WEST,
    EAST;
}

sealed interface Animal permits Cat, Dog, Bird {
    String say();
}

sealed interface Bird extends Animal {
}

public class SealedInterfaces {
    public static void main(String[] args) {
        sealedInterfaces();
    }

    private static void sealedInterfaces() {
//        Animal pet = new Canary();
//        switch (pet) {
//            case pet instanceof Canary c -> c.say();
//            case pet instanceof Cat cat -> c.say();
//            case pet instanceof Dog d -> c.say();
//        }
    }
}

record Cat(String name) implements Animal {
    public String say() {
        return "miau";
    }
}

record Dog(String name) implements Animal {
    @Override
    public String say() {
        return "ham";
    }
}

non-sealed class Canary implements Bird {
    @Override
    public String say() {
        return "cip";
    }
}
