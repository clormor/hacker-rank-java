package io.github.clormor.hackerrank.advanced;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSHA256Example {

    SHA256Example s;

    @Before
    public void setup() {
        s = new SHA256Example();
    }

    @Test
    public void test_hello_world() {
        test_both_hashes(
                "872e4e50ce9990d8b041330c47c9ddd11bec6b503ae9386a99da8584e9bb12c4",
                "HelloWorld");
    }

    @Test
    public void test_java_rmi_123() {
        test_both_hashes(
                "f1d5f8d75bb55c777207c251d07d9091dc10fe7d6682db869106aacb4b7df678",
                "Javarmi123");
    }

    private void test_both_hashes(String expected, String input) {
        assertEquals(expected, s.printHash(input));
        assertEquals(expected, s.altPrintHash(input));
    }
}
