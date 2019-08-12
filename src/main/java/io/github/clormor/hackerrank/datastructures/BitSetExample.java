package io.github.clormor.hackerrank.datastructures;

import java.util.BitSet;

public class BitSetExample {

    BitSet b1 = null;
    BitSet b2 = null;

    public String transform(int n, int m, String[] instructions) {
        StringBuilder result = new StringBuilder();
        b1 = new BitSet(n);
        b2 = new BitSet(n);

        for (String line : instructions) {
            String[] op = line.split(" ");
            String instruction = op[0];
            int a = Integer.parseInt(op[1]);
            int b = Integer.parseInt(op[2]);
            result.append(singleTransform(instruction, a, b));
        }

        return result.toString();
    }

    private String singleTransform(String instruction, int a, int b) {
        switch (instruction) {
            case "AND":
                if (a == 1 && b == 2) b1.and(b2);
                if (a == 2 && b == 1) b2.and(b1);
                break;
            case "FLIP":
                if (a == 1) b1.flip(b);
                if (a == 2) b2.flip(b);
                break;
            case "OR":
                if (a == 1 && b == 2) b1.or(b2);
                if (a == 2 && b == 1) b2.or(b1);
                break;
            case "SET":
                if (a == 1) b1.set(b);
                if (a == 2) b2.set(b);
                break;
            case "XOR":
                if (a == 1 && b == 2) b1.xor(b2);
                if (a == 2 && b == 1) b2.xor(b1);
                break;
            default:
                throw new IllegalArgumentException("Invalid instruction");
        }
        return String.format("%d %d%n", b1.cardinality(), b2.cardinality());
    }
}
