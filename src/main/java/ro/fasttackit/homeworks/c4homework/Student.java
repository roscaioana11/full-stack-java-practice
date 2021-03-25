package ro.fasttackit.homeworks.c4homework;

import java.time.LocalDate;
import java.time.Period;

public record Student (String name, LocalDate birthday, double grade){

    /**
     * Math.random() genereaza un nr cu virgula (0,1, 0,5 etc) intre 0 si 1 (o limita de jos, 1 limita de sus)
     * Daca Math.random() = 0, se ia minimum age (inceputul anului de nastere, 1 ian)
     * Daca Math.random() = 1, se ia minimum age + diferenta dintre minim si maxim (adica 31 decembrie al anului de nastere)
     * @param name
     * @param age
     * @param grade
     */
    public Student(String name,int age,float grade) {
        this(name,
        LocalDate.ofEpochDay((long) (Math.random() * (LocalDate.of(LocalDate.now().getYear() - age, 12, 31).toEpochDay()
                - LocalDate.of(LocalDate.now().getYear() - age, 1, 1).toEpochDay())
                + LocalDate.of(LocalDate.now().getYear() - age, 1, 1).toEpochDay())),
        grade);
    }

    public int getAge(){
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }

}
