package ro.fasttackit.homeworks.c3homework.gym;

import java.time.LocalDate;

public class Subscription {
    private final GymMember gymMember;
    private LocalDate subscriptionEnd;

    public Subscription(GymMember gymMember,LocalDate subscriptionEnd) {
        this.gymMember = gymMember;
        this.subscriptionEnd = subscriptionEnd;
    }

    public GymMember getGymMember() {
        return gymMember;
    }

    public LocalDate getSubscriptionEnd() {
        return subscriptionEnd;
    }

    public void setSubscriptionEnd(LocalDate subscriptionEnd) {
        this.subscriptionEnd = subscriptionEnd;
    }

}
