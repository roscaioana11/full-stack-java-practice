package ro.fasttackit.classes.curs2;

abstract class Pet { //cel mai bine fara public de la clasele abstracte sa opreasca mostenirea
    private final String name;

    public Pet(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    abstract Pet friend();

    public abstract String makeSound();
}
