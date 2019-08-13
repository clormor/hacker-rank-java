package io.github.clormor.hackerrank.advanced;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSingleton {

    private Singleton s;

    @Before
    public void setup() {
        s = Singleton.getSingleInstance();
    }

    @Test
    public void simple_test() {
        s.setStr("hello");
        assertEquals("hello", s.getStr());

        Singleton s2 = Singleton.getSingleInstance();
        s.setStr("world");

        assertEquals("world", s2.getStr());
        assertEquals("world", s.getStr());
    }
}
