package io.github.clormor.hackerrank.advanced;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class AbstractHashingExample {

    static final String SHA_256 = "SHA-256";
    static final String MD5 = "MD5";

    private final MessageDigest instance;

    public AbstractHashingExample(String algorithm) {
        try {
            instance = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    byte[] digest(String input) {
        return instance.digest(input.getBytes(StandardCharsets.UTF_8));
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
        String format = new StringBuilder()
                .append("%0")
                .append(getExpectedLength())
                .append("x")
                .toString();

        // you have to tell big integer that the number represented is unsigned
        return String.format(format, new BigInteger(1, output));
    }

    /**
     * The expected length (in 0-padded, hexadecimal characters) of a cryptographic hash.
     * @return the length in characters of the expected size of a hash (in 0-padded hex).
     */
    public abstract int getExpectedLength();
}
