package io.github.clormor.hackerrank.advanced;

public class SHA256Example extends AbstractHashingExample {

    public SHA256Example() {
        super(SHA_256);
    }

    @Override
    public String altPrintHash(String input) {
        return altPrintHash(input, 64);
    }
}
