package ro.fasttackit.homeworks.c3homework.gym;

import java.time.LocalDate;
import java.util.Objects;

public class GymMember {
    private final String name;
    private final LocalDate birthday;

    public GymMember(String name,LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GymMember gymMember = (GymMember) o;
        return Objects.equals(name,gymMember.name) && Objects.equals(birthday,gymMember.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,birthday);
    }

    @Override
    public String toString() {
        return "GymMember{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
