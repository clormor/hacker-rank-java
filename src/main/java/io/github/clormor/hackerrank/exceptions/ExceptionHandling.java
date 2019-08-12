package io.github.clormor.hackerrank.exceptions;

import java.util.InputMismatchException;

public class ExceptionHandling {

    static final String zero_error = "n and p should not be zero.";
    static final String negative_error = "n or p should not be negative.";
    static final String mismatch_exception = "java.util.InputMismatchException";
    static final String arithmetic_exception = "java.lang.ArithmeticException: / by zero";

    public long power(int n, int p) throws Exception {
        if (n == 0 && p == 0) throw new Exception(zero_error);
        if (n < 0 || p < 0) throw new Exception(negative_error);
        return (long) Math.pow(n, p);
    }

    public int divide(String a, String b) {
        try {
            int ai = Integer.parseInt(a);
            int bi = Integer.parseInt(b);
            if (ai == 0 || bi == 0) {
                throw new ArithmeticException(arithmetic_exception);
            }
            return ai / bi;
        } catch (NumberFormatException e) {
            throw new InputMismatchException(mismatch_exception);
        }
    }
}
