package io.github.clormor.hackerrank.datastructures.priorityqueue;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static io.github.clormor.hackerrank.datastructures.priorityqueue.Student.COMPARE_STUDENTS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestPriorityQueueExample {

    PriorityQueueExample p;

    @Before
    public void setup() {
        p = new PriorityQueueExample();
    }

    @Test
    public void simple_comparisons() {
        Student shafaet = ImmutableStudent.of("Shafaet", 3.7, 35);
        Student maria = ImmutableStudent.of("Maria", 3.6, 46);
        assertTrue(COMPARE_STUDENTS.compare(shafaet, maria) < 0);

        Student dan = ImmutableStudent.of("Dan", 3.95, 50);
        assertTrue(COMPARE_STUDENTS.compare(dan, shafaet) < 0);

        Student secondDan = ImmutableStudent.of("Dan", 3.95, 40);
        assertTrue(COMPARE_STUDENTS.compare(dan, secondDan) < 0);

        Student asCleverAsDan = ImmutableStudent.of("Zoe", 3.95, 51);
        assertTrue(COMPARE_STUDENTS.compare(dan, asCleverAsDan) < 0);
    }

    @Test
    public void hacker_rank_sample_test() {
        String[] input = {
                PriorityQueueExample.ENTER_COMMAND + " John 3.75 50",
                PriorityQueueExample.ENTER_COMMAND + " Mark 3.8 24",
                PriorityQueueExample.ENTER_COMMAND + " Shafaet 3.7 35",
                PriorityQueueExample.SERVED_COMMAND,
                PriorityQueueExample.SERVED_COMMAND,
                PriorityQueueExample.ENTER_COMMAND + " Samiha 3.85 36",
                PriorityQueueExample.SERVED_COMMAND,
                PriorityQueueExample.ENTER_COMMAND + " Ashley 3.9 42",
                PriorityQueueExample.ENTER_COMMAND + " Maria 3.6 46",
                PriorityQueueExample.ENTER_COMMAND + " Anik 3.95 49",
                PriorityQueueExample.ENTER_COMMAND + " Dan 3.95 50",
                PriorityQueueExample.SERVED_COMMAND
        };

        List<Student> students = p.getStudents(input);
        assertEquals(4, students.size());
        checkStudent("Dan", 3.95, 50, students.get(0));
        checkStudent("Ashley", 3.9, 42, students.get(1));
        checkStudent("Shafaet", 3.7, 35, students.get(2));
        checkStudent("Maria", 3.6, 46, students.get(3));
    }

    @Test
    public void its_possible_to_serve_an_empty_queue() {
        String[] input = {
                PriorityQueueExample.SERVED_COMMAND,
                PriorityQueueExample.SERVED_COMMAND,
                PriorityQueueExample.ENTER_COMMAND + " Samiha 3.85 36",
                PriorityQueueExample.ENTER_COMMAND + " Maria 3.6 46",
                PriorityQueueExample.SERVED_COMMAND,
                PriorityQueueExample.SERVED_COMMAND,
                PriorityQueueExample.SERVED_COMMAND
        };

        List<Student> students = p.getStudents(input);
        assertEquals(0, students.size());
    }


    @Test(expected = RuntimeException.class)
    public void throw_runtime_exception_on_bad_command() {
        p.getStudents(new String[]{"ioefhewoifhwe"});
    }

    private void checkStudent(String name, double cgpa, int id, Student student) {
        assertEquals(name, student.getName());
        assertEquals(cgpa, student.getCgpa(), 0.001);
        assertEquals(id, student.getId());
    }
}
