package ro.fasttackit.homeworks.c3homework.gym;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SubscriptionRepository implements Repository<Subscription>{
    private List<Subscription> subscriptions = new ArrayList<>();

    @Override
    public Subscription find(Predicate<Subscription> condition) {
        Optional<Subscription> foundGymMember = subscriptions.stream()
                .filter(condition)
                .findFirst();
        if(foundGymMember.isPresent()){
            return foundGymMember.get();
        }
        return null;
    }

    @Override
    public List<Subscription> findAll(Predicate<Subscription> condition) {
        List<Subscription> foundSubscription = subscriptions.stream()
                .filter(condition)
                .collect(Collectors.toList());
        return foundSubscription;
    }

    @Override
    public void add(Subscription newElement) {
        subscriptions.add(newElement);
    }

    public float applyMathForSubscriptions(Function<List<Subscription>, Float> mathFunction){
        return mathFunction.apply(subscriptions);
    }

    public List<Subscription> getLatestMembersSubscriptions(){
        return subscriptions.stream()
                .sorted(Comparator.comparing(Subscription::getSubscriptionEnd, Comparator.reverseOrder()))
                .collect(Collectors.groupingBy(subscription -> subscription.getGymMember().getName(),LinkedHashMap::new, Collectors.toList())) //HashMap nu pastreaza ordinea listei
                .values()
                .stream()
                .map(group -> group.get(0))
                .collect(Collectors.toList());
    }
}
