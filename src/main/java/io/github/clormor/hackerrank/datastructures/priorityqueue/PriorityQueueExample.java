package io.github.clormor.hackerrank.datastructures.priorityqueue;

import static io.github.clormor.hackerrank.datastructures.priorityqueue.Student.COMPARE_STUDENTS;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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
        while (!students.isEmpty()) {
            result.add(students.remove());
        }
        return result;
    }

    private void processEvent(String event) {
        String[] parts = event.split(" ");
        switch (parts[0]) {
            case ENTER_COMMAND:
                addStudent(parts);
                break;
            case SERVED_COMMAND:
                removeStudentIfPossible();
                break;
            default:
                throw new RuntimeException("Invalid command " + parts[0]);
        }
    }

    private void removeStudentIfPossible() {
        if (!students.isEmpty()) {
            students.remove();
        }
    }

    private void addStudent(String[] parts) {
        students.add(ImmutableStudent.of(
                parts[1],
                Double.parseDouble(parts[2]),
                Integer.parseInt(parts[3])));
    }
}
