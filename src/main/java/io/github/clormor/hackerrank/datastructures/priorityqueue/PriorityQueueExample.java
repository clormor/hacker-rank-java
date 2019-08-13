package io.github.clormor.hackerrank.datastructures.priorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static io.github.clormor.hackerrank.datastructures.priorityqueue.Student.COMPARE_STUDENTS;

public class PriorityQueueExample {
    static final String ENTER_COMMAND = "ENTER";
    static final String SERVED_COMMAND = "SERVED";

    PriorityQueue<Student> students = null;

    public List<Student> getStudents(String[] events) {
        students = new PriorityQueue<>(events.length, COMPARE_STUDENTS);
        for (String event : events) {
            processEvent(event);
        }
        List<Student> result = new ArrayList<>(students.size());
        while (! students.isEmpty()) {
            result.add(students.remove());
        }
        return result;
    }

    private void processEvent(String event) {
        String[] parts = event.split(" ");
        switch (parts[0]) {
            case ENTER_COMMAND:
                Student s1 = createStudent(parts);
                System.out.printf("Student %s has been added%n", s1.getName());
                students.add(s1);
                break;
            case SERVED_COMMAND:
                Student s2 = students.remove();
                System.out.printf("Student %s got SERVED!%n", s2.getName());
                break;
            default:
                throw new RuntimeException("Invalid command " + parts[0]);
        }
    }

    private Student createStudent(String[] parts) {
        return ImmutableStudent.of(
                parts[1],
                Double.parseDouble(parts[2]),
                Integer.parseInt(parts[3]));
    }
}
