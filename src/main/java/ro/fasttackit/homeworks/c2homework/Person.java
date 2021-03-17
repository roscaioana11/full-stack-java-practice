package ro.fasttackit.homeworks.c2homework;

import java.util.List;
import java.util.Objects;

public class Person{
    private final String lastName;
    private final String firstName;
    private final int age;

    public Person(String lastName,String firstName,int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getAgeRange(List<Integer> ageRanges){
        int min = 0;
        int max = 0;
        for(int i = 0; i < ageRanges.size(); i++){
            if(i - 1 >= 0){
                min = ageRanges.get(i - 1);
            }
            max = ageRanges.get(i);
            if(age > min && age <= max){
                return min + "-" + max;
            }
        }
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(lastName,person.lastName) && Objects.equals(firstName,person.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName,firstName,age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
