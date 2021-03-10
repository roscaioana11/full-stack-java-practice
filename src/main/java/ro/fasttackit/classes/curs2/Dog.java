package ro.fasttackit.classes.curs2;

public class Dog extends Pet{
    private int tailLength;

    public Dog(String name) {
        super(name);
    }

    @Override
    Dog friend() {
        return null;
    }

    @Override
    public String makeSound() {
        return "woof";
    }

    public int getTailLength(){
        return tailLength;
    }
}
