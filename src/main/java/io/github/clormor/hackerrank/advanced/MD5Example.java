package io.github.clormor.hackerrank.advanced;

public class MD5Example extends AbstractHashingExample {

    static final int expectedLength = 32;

    public MD5Example() {
        super(MD5);
    }

    @Override
    public int getExpectedLength() {
        return expectedLength;
    }
}
