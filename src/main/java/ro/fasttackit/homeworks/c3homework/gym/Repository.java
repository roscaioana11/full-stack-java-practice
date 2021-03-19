package ro.fasttackit.homeworks.c3homework.gym;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Repository<C> {
    C find(Predicate<C> condition);
    List<C> findAll(Predicate<C> condition);
    void add(C newElement);
}
