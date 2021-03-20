package ro.fasttackit.homeworks.c2homework;

import java.util.List;

public class AgeRange {
    private final List<Integer> ageRanges;

    public AgeRange(List<Integer> ageRanges) {
        this.ageRanges = ageRanges;
    }

    public String getAgeRange(Person person){
        int min = 0;
        int max = 0;
        for(int i = 0; i < ageRanges.size(); i++){
            if(i - 1 >= 0){
                min = ageRanges.get(i - 1);
            }
            max = ageRanges.get(i);
            if(person.getAge() > min && person.getAge() <= max){
                return min + "-" + max;
            }
        }
        return "";
    }
}
