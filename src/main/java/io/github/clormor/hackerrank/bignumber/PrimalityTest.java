package io.github.clormor.hackerrank.bignumber;

import java.math.BigInteger;

public class PrimalityTest {

    public String isPrime(BigInteger i) {
        if (i.isProbablePrime(100)) {
            return "prime";
        } else {
            return "not prime";
        }
    }
}
