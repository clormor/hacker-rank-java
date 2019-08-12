package io.github.clormor.hackerrank.advanced;

public class SHA256Example extends AbstractHashingExample {

    static final int expectedLength = 64;

    public SHA256Example() {
        super(SHA_256);
    }

    @Override
    public int getExpectedLength() {
        return expectedLength;
    }
}
