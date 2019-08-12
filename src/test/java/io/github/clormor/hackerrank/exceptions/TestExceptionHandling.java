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
        assertEquals(243L,e.power(3,5));
        assertEquals(16L,e.power(2,4));
    }

    @Test
    public void power_exceptions_test() {
        try {
            e.power(0, 0);
            fail("An exception should have been thrown");
        } catch (Exception e) {
            assertEquals(zero_error, e.getMessage());
        }

        try {
            e.power(-1, -2);
            fail("An exception should have been thrown");
        } catch (Exception e) {
            assertEquals(negative_error, e.getMessage());
        }

        try {
            e.power(-1, 3);
            fail("An exception should have been thrown");
        } catch (Exception e) {
            assertEquals(negative_error, e.getMessage());
        }
    }

    @Test
    public void divide_simple_test() {
        assertEquals(3, e.divide("10", "3"));
    }

    @Test
    public void divide_mismatch_test() {
        try {
            e.divide("10", "Hello");
            fail();
        } catch (InputMismatchException e) {
            assertEquals(mismatch_exception, e.getMessage());
        }
    }

    @Test
    public void zero_argument_test() {
        try {
            e.divide("0", "23");
            fail();
        } catch (ArithmeticException e) {
            assertEquals(arithmetic_exception, e.getMessage());
        }
        try {
            e.divide("232", "0");
            fail();
        } catch (ArithmeticException e) {
            assertEquals(arithmetic_exception, e.getMessage());
        }
    }

    @Test
    public void divide_mismatch_and_0_throws_mismatch_exception() {
        try {
            e.divide("23.233", "0");
            fail();
        } catch (InputMismatchException e) {
            assertEquals(mismatch_exception, e.getMessage());
        }
    }
}
