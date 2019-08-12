package io.github.clormor.hackerrank.advanced;

public class MD5Example extends AbstractHashingExample {

    public MD5Example() {
        super(MD5);
    }

    @Override
    public String altPrintHash(String input) {
        return altPrintHash(input, 32);
    }

}
