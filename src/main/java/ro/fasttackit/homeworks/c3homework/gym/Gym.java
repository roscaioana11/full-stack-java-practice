package ro.fasttackit.homeworks.c3homework.gym;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Gym {
    private final GymMemberRepository memberRepository;
    private final SubscriptionRepository subscriptionRepository;

    public Gym() {
        this.memberRepository = new GymMemberRepository();
        this.subscriptionRepository = new SubscriptionRepository();
    }

    public void addGymMember(String name,LocalDate birthday){
        memberRepository.add(new GymMember(name, birthday));
    }

    public void addSubscription(String name, LocalDate endDate){
        GymMember existingMember = memberRepository.find(member -> member.getName() == name);
        if(existingMember != null){
            subscriptionRepository.add(new Subscription(existingMember, endDate));
        }
    }

    public int getMaxMemberAge(){
        return (int) memberRepository.applyMathForMembers(
                gymMembers -> Float.valueOf(calculateMaxMemberAge(gymMembers)));
    }

    public Integer calculateMaxMemberAge(List<GymMember> gymMembers){
        return gymMembers.stream()
                .map(gymMember -> gymMember.getBirthday())
                .min(Comparator.comparing(LocalDate::toEpochDay))
                .map(min -> Period.between(min, LocalDate.now()).getYears())
                .orElse(0);
    }

    public int getMinMemberAge(){
        return (int) memberRepository.applyMathForMembers(
                gymMembers -> Float.valueOf(calculateMinMemberAge(gymMembers)));
    }

    public Integer calculateMinMemberAge(List<GymMember> gymMembers){
        return gymMembers.stream()
                .map(gymMember -> gymMember.getBirthday())
                .max(Comparator.comparing(LocalDate::toEpochDay))
                .map(max -> Period.between(max, LocalDate.now()).getYears())
                .orElse(0);
    }

    public float getAverageMemberAge(){
        return memberRepository.applyMathForMembers(
                gymMembers -> (float) gymMembers.stream()
                            .map(gymMember -> Period.between(gymMember.getBirthday(), LocalDate.now()).getYears())
                            .mapToInt(age -> age)
                            .average()
                            .orElse(0));
    }

    public GymMember getMemberInfo(String name){
        GymMember existingMember = memberRepository.find(member -> member.getName() == name);
        if(existingMember != null){
            return existingMember;
        }else {
            return null;
        }
    }

    public float getTotalRemainingTime(){
        double averageRemainingTime = subscriptionRepository.getLatestMembersSubscriptions()
                .stream()
                .mapToDouble(subscription -> (Duration.between(LocalDateTime.now(), subscription.getSubscriptionEnd().atStartOfDay()).toHours()))
                .sum();
        return (float) averageRemainingTime;
    }

    public void generateGymReport(String outputFile,HashMap<RangeLimit, String> subscriptionLimits) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            var latestSubscriptions = subscriptionRepository.getLatestMembersSubscriptions();
            writeRemainingTime(writer, latestSubscriptions, subscriptionLimits);
        }
    }

    public void writeRemainingTime(BufferedWriter writer, List<Subscription> latestSubscriptions, HashMap<RangeLimit, String> subscriptionLimits){
        latestSubscriptions.stream()
                .collect(Collectors.groupingBy(subscription -> getRangeIndex(subscriptionLimits,(int) Duration.between(
                        LocalDateTime.now(), subscription.getSubscriptionEnd().atStartOfDay()).toHours())))
                .forEach((keyColor,valueSubscription) -> writeSubscriptionRangeToFile(writer, keyColor, valueSubscription));
    }

    private String getRangeIndex(HashMap<RangeLimit, String> rangeList, int testedValue){
        RangeLimit foundKey = rangeList.keySet().stream()
                .filter(keyRange -> keyRange.getLowerLimit() == null || keyRange.getLowerLimit() < testedValue)
                .filter(keyRange -> keyRange.getUpperLimit() == null || keyRange.getUpperLimit() >= testedValue)
                .findFirst()
                .orElse(new RangeLimit(0, 0));
        return rangeList.get(foundKey);
    }

    private void writeSubscriptionRangeToFile(BufferedWriter writer, String header, List<Subscription> subscriptionRange){
        writeToFile(writer, header + ": ", false);
        subscriptionRange.stream()
                .map(subscription -> subscription.getGymMember().getName() + ",")
                .forEach(line -> writeToFile(writer, line, false));
        writeToFile(writer, "", true);
    }

    private void writeToFile(BufferedWriter writer,String line, boolean isNewLine) {
        try {
            if(isNewLine){
                writer.newLine();
            }
            writer.write(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
