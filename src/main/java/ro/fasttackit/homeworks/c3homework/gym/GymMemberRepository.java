package ro.fasttackit.homeworks.c3homework.gym;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.groupingBy;

public class GymMemberRepository implements Repository<GymMember>{
    private List<GymMember> gymMembers = new ArrayList<>();

    @Override
    public GymMember find(Predicate<GymMember> condition) {
        Optional<GymMember> foundGymMember =gymMembers.stream()
                .filter(condition)
                .findFirst();
        if(foundGymMember.isPresent()){
            return foundGymMember.get();
        }
        return null;
    }

    @Override
    public List<GymMember> findAll(Predicate<GymMember> condition) {
        List<GymMember> foundGymMembers = gymMembers.stream()
                .filter(condition)
                .collect(toList());
        return foundGymMembers;
    }

    @Override
    public void add(GymMember newElement) {
        Optional<GymMember> foundGymMember =gymMembers.stream()
                .filter(existingMember -> existingMember.getName() == newElement.getName())
//                .filter(existingMember -> existingMember.getBirthday().equals(newElement.getBirthday()))
                .findFirst();
        if(!foundGymMember.isPresent()){
            gymMembers.add(newElement);
        }
    }

    public float applyMathForMembers(Function<List<GymMember>, Float> mathFunction){
        return mathFunction.apply(gymMembers);
    }
}
