package io.github.clormor.hackerrank.bignumber;

import java.math.BigDecimal;
import java.util.Arrays;

public class BigDecimalSort {

    public String[] sort(String[] strings, int n) {
        String[] result = Arrays.copyOf(strings, n);

        Arrays.sort(result, (String s1, String s2) -> {
            BigDecimal b1 = new BigDecimal(s1);
            BigDecimal b2 = new BigDecimal(s2);
            return b2.compareTo(b1);
        });

        return result;
    }

    public String[] sort(String[] strings) {
        return sort(strings, strings.length);
    }
}
