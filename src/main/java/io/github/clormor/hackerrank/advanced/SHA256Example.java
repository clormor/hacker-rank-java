package io.github.clormor.hackerrank.advanced;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Example {

    static final String SHA_256 = "SHA-256";
    static final MessageDigest instance;

    static {
        try {
            instance = MessageDigest.getInstance(SHA_256);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String printHash(String input) {
        byte[] output = digest(input);

        StringBuilder result = new StringBuilder();
        for (byte b : output) {
            result.append(String.format("%02x", b));
        }

        return result.toString();
    }

    public String altPrintHash(String input) {
        byte[] output = digest(input);

        // you have to tell big integer that the number represented is unsigned
        return String.format("%064x", new BigInteger(1, output));
    }

    private byte[] digest(String input) {
        return instance.digest(input.getBytes(StandardCharsets.UTF_8));
    }
}
