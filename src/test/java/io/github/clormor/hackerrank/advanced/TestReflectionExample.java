package io.github.clormor.hackerrank.advanced;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestReflectionExample {

    ReflectionExample r;

    @Before
    public void setup() {
        r = new ReflectionExample();
    }

    @Test
    public void test_get_methods() {
        String result = r.getObjectMethods();
        assertTrue(result.contains("clone\n"));
        assertTrue(result.contains("equals\n"));
        assertTrue(result.contains("finalize\n"));
        assertTrue(result.contains("getClass\n"));
        assertTrue(result.contains("hashCode\n"));
        assertTrue(result.contains("notify\n"));
        assertTrue(result.contains("notifyAll\n"));
        assertTrue(result.contains("toString\n"));
        assertTrue(result.contains("wait\n"));
    }
}
