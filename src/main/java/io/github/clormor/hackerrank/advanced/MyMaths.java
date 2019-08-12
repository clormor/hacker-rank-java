package io.github.clormor.hackerrank.advanced;

import java.math.BigInteger;

public class MyMaths {

    private PerformOperation isOdd = (int n) -> {
        return n % 2 == 1;
    };

    private PerformOperation isPrime = (int n) -> {
        BigInteger b = new BigInteger(Integer.toString(n));
        return b.isProbablePrime(100);
    };

    private PerformOperation isPalindrome = (int n) -> {
        char[] chars = Integer.toString(n).toCharArray();
        for (int i = 0; i < (chars.length / 2); i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    };

    PerformOperation isOdd() {
        return isOdd;
    }

    PerformOperation isPrime() {
        return isPrime;
    }

    PerformOperation isPalindrome() {
        return isPalindrome;
    }

    boolean checker(PerformOperation op, int n) {
        return op.operation(n);
    }
}
