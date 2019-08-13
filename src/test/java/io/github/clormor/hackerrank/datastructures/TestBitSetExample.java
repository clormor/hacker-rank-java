package io.github.clormor.hackerrank.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBitSetExample {

    BitSetExample b;

    @Before
    public void setup() {
        b = new BitSetExample();
    }

    @Test
    public void simple_test() {
        String[] instructions = {"AND 1 2", "SET 1 4", "FLIP 2 2", "OR 2 1", "XOR 1 1"};

        String result = b.transform(5, instructions.length, instructions);
        String[] lines = result.split(System.lineSeparator());
        assertEquals("0 0", lines[0]);
        assertEquals("1 0", lines[1]);
        assertEquals("1 1", lines[2]);
        assertEquals("1 2", lines[3]);
        assertEquals("0 2", lines[4]);
    }

    @Test (expected = IllegalArgumentException.class)
    public void illegal_arg_test() {
        String[] instructions = {"AND 1 2", "ROTATE 1 2"};
        b.transform(5, instructions.length, instructions);
    }

    @Test (expected = IllegalArgumentException.class)
    public void very_illegal_arg_test() {
        String[] instructions = {"hello how are you"};
        b.transform(5, instructions.length, instructions);
    }
}
