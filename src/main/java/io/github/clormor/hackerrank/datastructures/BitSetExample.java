package io.github.clormor.hackerrank.datastructures;

import java.util.BitSet;

public class BitSetExample {

    BitSet b1 = null;
    BitSet b2 = null;

    BitSetOperation and = (int m, int n) -> {
        whichOne(m).and(whichOne(n));
    };

    BitSetOperation or = (int m, int n) -> {
        whichOne(m).or(whichOne(n));
    };

    BitSetOperation xor = (int m, int n) -> {
        whichOne(m).xor(whichOne(n));
    };

    BitSetOperation set = (int m, int n) -> {
        whichOne(m).set(n);
    };

    BitSetOperation flip = (int m, int n) -> {
        whichOne(m).flip(n);
    };

    private BitSet whichOne(int n) {
        if (n == 1) {
            return b1;
        } else {
            return b2;
        }
    }

    public String transform(int n, int m, String[] operations) {
        StringBuilder result = new StringBuilder();
        b1 = new BitSet(n);
        b2 = new BitSet(n);

        for (int i = 0; i < m; i++) {
            String[] op = operations[i].split(" ");
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
                and.transform(a, b);
                break;
            case "FLIP":
                flip.transform(a, b);
                break;
            case "OR":
                or.transform(a, b);
                break;
            case "SET":
                set.transform(a, b);
                break;
            case "XOR":
                xor.transform(a, b);
                break;
            default:
                throw new IllegalArgumentException("Invalid instruction");
        }
        return String.format("%d %d%n", b1.cardinality(), b2.cardinality());
    }
}
