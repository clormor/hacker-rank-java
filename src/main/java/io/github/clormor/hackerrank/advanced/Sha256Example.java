package io.github.clormor.hackerrank.advanced;

public class Sha256Example extends AbstractHashingExample {

    static final int EXPECTED_LENGTH = 64;

    public Sha256Example() {
        super(SHA_256);
    }

    @Override
    public int getExpectedLength() {
        return EXPECTED_LENGTH;
    }
}
