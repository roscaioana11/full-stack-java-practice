package ro.fasttackit.homeworks.c3homework.gym;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        Gym gym = new Gym();
        gym.addGymMember("Ioana", LocalDate.of(1995, 9, 11));
        gym.addGymMember("Ion", LocalDate.of(1990, 4, 1));
        gym.addGymMember("Pop", LocalDate.of(1991, 10, 15));
        gym.addGymMember("Vlad", LocalDate.of(2000, 1, 1));
        gym.addGymMember("Grigore", LocalDate.of(1997, 7, 20));

        gym.addSubscription("Ioana", LocalDate.of(2021, 3, 20));
        gym.addSubscription("Ion", LocalDate.of(2021, 1, 20));
        gym.addSubscription("Ion", LocalDate.of(2021, 3, 21));
        gym.addSubscription("Pop", LocalDate.of(2021, 3, 22));
        gym.addSubscription("Vlad", LocalDate.of(2021, 3, 21));
        gym.addSubscription("Grigore", LocalDate.of(2021, 2, 20));
        gym.addSubscription("Grigore", LocalDate.of(2021, 3, 20));
        gym.addSubscription("Grigore", LocalDate.of(2021, 4, 20));

        HashMap<RangeLimit, String> rangeLimits = new HashMap<>();
        rangeLimits.put(new RangeLimit(null, 10), "RED");
        rangeLimits.put(new RangeLimit(10, 30), "YELLOW");
        rangeLimits.put(new RangeLimit(30, null), "GREEN");
        System.out.println("Min age: " + gym.getMinMemberAge());
        System.out.println("Max age: " + gym.getMaxMemberAge());
        System.out.println("Average age: " + gym.getAverageMemberAge());
        System.out.println("Total remaining time: " + gym.getTotalRemainingTime());

        gym.generateGymReport("gymReport.txt", rangeLimits);
    }
}
