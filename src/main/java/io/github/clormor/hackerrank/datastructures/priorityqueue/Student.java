package io.github.clormor.hackerrank.datastructures.priorityqueue;


import java.util.Comparator;
import org.immutables.value.Value;


@Value.Immutable
public abstract class Student {

    @Value.Parameter
    abstract String getName();

    @Value.Parameter
    abstract double getCgpa();

    @Value.Parameter
    abstract int getId();

    public static final Comparator<Student> COMPARE_STUDENTS = (Student a, Student b) -> {
        if (a.getCgpa() == b.getCgpa()) {
            if (a.getName().equals(b.getName())) {
                return b.getId() - a.getId();
            } else {
                return a.getName().compareTo(b.getName());
            }
        } else {
            return (a.getCgpa() > b.getCgpa()) ? -1 : 1;
        }
    };

}
