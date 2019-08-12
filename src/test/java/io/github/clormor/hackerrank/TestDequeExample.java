package io.github.clormor.hackerrank;

import io.github.clormor.hackerrank.datastructures.DequeExample;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDequeExample {

    private DequeExample d;

    @Before
    public void setup() {
        d = new DequeExample();
    }

    @Test
    public void first_test() {
        Integer[] input = {5, 3, 5, 2, 3, 2};
        assertEquals(3, d.maxUnique(3, input));
    }

    @Test
    public void debugging_test() {
        Integer[] input = {5, 3, 5, 2, 3, 2, 9, 100, 27, 34, 27, 100, 38, 8, 8, 8, 9, 9, 10, 11, 100, 99, 27, 88};
        assertEquals(6, d.maxUnique(6, input));
    }

    @Test
    public void boundary_test() {
        Integer[] input = {1, 2, 3};
        assertEquals(3, d.maxUnique(3, input));
    }
}
