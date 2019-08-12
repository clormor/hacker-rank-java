package io.github.clormor.hackerrank.advanced;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestReflectionExample {

    ReflectionExample r;

    @Before
    public void setup() {
        r = new ReflectionExample();
    }

    @Test
    public void test_get_methods() {
        String result = r.getStudentMethods();
        String expected = new StringBuilder()
                .append("getEmail")
                .append(System.lineSeparator())
                .append("getId")
                .append(System.lineSeparator())
                .append("getName")
                .append(System.lineSeparator())
                .append("setEmail")
                .append(System.lineSeparator())
                .append("setId")
                .append(System.lineSeparator())
                .append("setName")
                .append(System.lineSeparator())
                .toString();

        assertEquals(expected, result);
    }
}
