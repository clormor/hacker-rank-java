package io.github.clormor.hackerrank.advanced;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHashingExamples {

    Sha256Example s;
    MD5Example m;

    @Before
    public void setup() {
        s = new Sha256Example();
        m = new MD5Example();
    }

    @Test
    public void test_sha256() {
        test_sha256_hashes(
                "872e4e50ce9990d8b041330c47c9ddd11bec6b503ae9386a99da8584e9bb12c4",
                "HelloWorld");
        test_sha256_hashes(
                "f1d5f8d75bb55c777207c251d07d9091dc10fe7d6682db869106aacb4b7df678",
                "Javarmi123");
    }

    @Test
    public void test_md5() {
        test_md5_hashes(
                "68e109f0f40ca72a15e05cc22786f8e6",
                "HelloWorld");
        test_md5_hashes(
                "2da2d1e0ce7b4951a858ed2d547ef485",
                "Javarmi123");
    }

    private void test_sha256_hashes(String expected, String input) {
        assertEquals(expected, s.printHash(input));
        assertEquals(expected, s.altPrintHash(input));
    }

    private void test_md5_hashes(String expected, String input) {
        assertEquals(expected, m.printHash(input));
        assertEquals(expected, m.altPrintHash(input));
    }
}
