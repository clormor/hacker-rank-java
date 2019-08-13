package io.github.clormor.hackerrank.advanced;

import java.math.BigInteger;

public class MyMaths {

    private PerformMathsOperation isOdd = (int n) -> {
        return n % 2 != 0;
    };

    private PerformMathsOperation isPrime = (int n) -> {
        BigInteger b = new BigInteger(Integer.toString(n));
        return b.isProbablePrime(100);
    };

    private PerformMathsOperation isPalindrome = (int n) -> {
        char[] chars = Integer.toString(n).toCharArray();
        for (int i = 0; i < (chars.length / 2); i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    };

    PerformMathsOperation isOdd() {
        return isOdd;
    }

    PerformMathsOperation isPrime() {
        return isPrime;
    }

    PerformMathsOperation isPalindrome() {
        return isPalindrome;
    }

    boolean checker(PerformMathsOperation op, int n) {
        return op.operation(n);
    }
}
