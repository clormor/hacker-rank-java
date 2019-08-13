package io.github.clormor.hackerrank.exceptions;

import org.junit.Before;
import org.junit.Test;

import java.util.InputMismatchException;

import static io.github.clormor.hackerrank.exceptions.ExceptionHandling.arithmetic_exception;
import static io.github.clormor.hackerrank.exceptions.ExceptionHandling.mismatch_exception;
import static io.github.clormor.hackerrank.exceptions.ExceptionHandling.negative_error;
import static io.github.clormor.hackerrank.exceptions.ExceptionHandling.zero_error;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestExceptionHandling {

    ExceptionHandling e;

    @Before
    public void setup() {
        e = new ExceptionHandling();
    }

    @Test
    public void power_simple_test() throws Exception {
        assertEquals(243,e.power(3,5));
        assertEquals(16,e.power(2,4));
        assertEquals(1, e.power(10, 0));
        assertEquals(0, e.power(0, 10));
    }

    @Test
    public void power_exceptions_test() {
        try_invalid_power(0, 0, zero_error);
        try_invalid_power(-1, -2, negative_error);
        try_invalid_power(-1, 1, negative_error);
        try_invalid_power(1, -2, negative_error);
    }

    private void try_invalid_power(int n, int p, String expectedMessage) {
        try {
            e.power(n, p);
            fail("An exception should have been thrown");
        } catch (Exception e) {
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    private void try_invalid_divide(String m, String n, String expectedMessage) {
        try {
            e.divide(m, n);
            fail("An exception should have been thrown");
        } catch (Exception e) {
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void divide_simple_test() {
        assertEquals(3, e.divide("10", "3"));
    }

    @Test
    public void divide_mismatch_test() {
        try_invalid_divide("10", "Hello", mismatch_exception);
        try_invalid_divide("_d338dh", "12", mismatch_exception);
    }

    @Test
    public void zero_argument_test() {
        try_invalid_divide("0", "23", arithmetic_exception);
        try_invalid_divide("23", "0", arithmetic_exception);
    }

    @Test
    public void divide_mismatch_and_0_throws_mismatch_exception() {
        try_invalid_divide("23.232", "0", mismatch_exception);
    }
}
