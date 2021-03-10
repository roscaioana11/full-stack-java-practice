package ro.fasttackit.classes.curs2.interfaces;

//Java8+ --->
public interface Pet {
    String NAME = "PET";

    String getName();

    String makeSound();

    default String getColor(){ //implementare default
        return "BROWN";
    }

    default String phrase(){
        logPhraseCall();
        return getName() + ":" + makeSound();
    }

    private void logPhraseCall(){
        System.out.println("phrase method was called");
    }
}
