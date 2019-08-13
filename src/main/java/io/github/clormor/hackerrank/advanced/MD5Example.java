package io.github.clormor.hackerrank.advanced;

public class MD5Example extends AbstractHashingExample {

    static final int EXPECTED_LENGTH = 32;

    public MD5Example() {
        super(MD5);
    }

    @Override
    public int getExpectedLength() {
        return EXPECTED_LENGTH;
    }
}
