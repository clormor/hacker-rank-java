package io.github.clormor.hackerrank.advanced;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestMyMaths {

    MyMaths m = new MyMaths();

    @Before
    public void setup() {
        m = new MyMaths();
    }

    @Test
    public void test_odd() {
        PerformOperation op = m.isOdd();
        assertTrue(m.checker(op, 3));
        assertFalse(m.checker(op, 4));
        assertFalse(m.checker(op, 0));
        assertTrue(m.checker(op, 13));
        assertTrue(m.checker(op, 99));
    }

    @Test
    public void test_prime() {
        PerformOperation op = m.isPrime();
        assertTrue(m.checker(op, 3));
        assertFalse(m.checker(op, 4));
        assertFalse(m.checker(op, 0));
        assertTrue(m.checker(op, 13));
        assertFalse(m.checker(op, 99));
    }

    @Test
    public void test_palindrome() {
        PerformOperation op = m.isPalindrome();
        assertTrue(m.checker(op, 3));
        assertTrue(m.checker(op, 4));
        assertTrue(m.checker(op, 0));
        assertFalse(m.checker(op, 13));
        assertTrue(m.checker(op, 99));
        assertTrue(m.checker(op, 131));
        assertFalse(m.checker(op, 132));
        assertTrue(m.checker(op, 132231));
    }
}
