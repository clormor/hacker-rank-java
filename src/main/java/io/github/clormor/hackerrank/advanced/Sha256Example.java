package io.github.clormor.hackerrank.advanced;

public class Sha256Example extends AbstractHashingExample {

    static final int expectedLength = 64;

    public Sha256Example() {
        super(SHA_256);
    }

    @Override
    public int getExpectedLength() {
        return expectedLength;
    }
}
