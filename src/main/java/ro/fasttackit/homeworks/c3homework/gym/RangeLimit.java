package ro.fasttackit.homeworks.c3homework.gym;

import java.util.Objects;

public class RangeLimit {
    private final Integer lowerLimit;
    private final Integer upperLimit;

    public RangeLimit(Integer lowerLimit,Integer upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public Integer getLowerLimit() {
        return lowerLimit;
    }

    public Integer getUpperLimit() {
        return upperLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RangeLimit that = (RangeLimit) o;
        return Objects.equals(lowerLimit,that.lowerLimit) && Objects.equals(upperLimit,that.upperLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lowerLimit,upperLimit);
    }

    @Override
    public String toString() {
        return "RangeLimit{" +
                "lowerLimit=" + lowerLimit +
                ", upperLimit=" + upperLimit +
                '}';
    }
}
