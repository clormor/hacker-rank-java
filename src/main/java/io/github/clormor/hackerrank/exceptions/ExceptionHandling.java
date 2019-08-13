package io.github.clormor.hackerrank.exceptions;

import java.util.InputMismatchException;

public class ExceptionHandling {

    static final String ZERO_ERROR = "n and p should not be zero.";
    static final String NEGATIVE_ERROR = "n or p should not be negative.";
    static final String MISMATCH_EXCEPTION = "java.util.InputMismatchException";
    static final String ARITHMETIC_EXCEPTION = "java.lang.ArithmeticException: / by zero";

    public long power(int n, int p) throws Exception {
        if (n == 0 && p == 0) throw new Exception(ZERO_ERROR);
        if (n < 0 || p < 0) throw new Exception(NEGATIVE_ERROR);
        return (long) Math.pow(n, p);
    }

    public int divide(String a, String b) {
        try {
            int ai = Integer.parseInt(a);
            int bi = Integer.parseInt(b);
            if (ai == 0 || bi == 0) {
                throw new ArithmeticException(ARITHMETIC_EXCEPTION);
            }
            return ai / bi;
        } catch (NumberFormatException e) {
            throw new InputMismatchException(MISMATCH_EXCEPTION);
        }
    }
}
