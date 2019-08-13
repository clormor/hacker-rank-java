package io.github.clormor.hackerrank.exceptions;

import org.junit.Before;
import org.junit.Test;

import static io.github.clormor.hackerrank.exceptions.ExceptionHandling.ARITHMETIC_EXCEPTION;
import static io.github.clormor.hackerrank.exceptions.ExceptionHandling.MISMATCH_EXCEPTION;
import static io.github.clormor.hackerrank.exceptions.ExceptionHandling.NEGATIVE_ERROR;
import static io.github.clormor.hackerrank.exceptions.ExceptionHandling.ZERO_ERROR;
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
        try_invalid_power(0, 0, ZERO_ERROR);
        try_invalid_power(-1, -2, NEGATIVE_ERROR);
        try_invalid_power(-1, 1, NEGATIVE_ERROR);
        try_invalid_power(1, -2, NEGATIVE_ERROR);
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
        try_invalid_divide("10", "Hello", MISMATCH_EXCEPTION);
        try_invalid_divide("_d338dh", "12", MISMATCH_EXCEPTION);
    }

    @Test
    public void zero_argument_test() {
        try_invalid_divide("0", "23", ARITHMETIC_EXCEPTION);
        try_invalid_divide("23", "0", ARITHMETIC_EXCEPTION);
    }

    @Test
    public void divide_mismatch_and_0_throws_mismatch_exception() {
        try_invalid_divide("23.232", "0", MISMATCH_EXCEPTION);
    }
}
