package io.github.clormor.hackerrank.advanced;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestAdd {

    private Add v;

    @Before
    public void setup() {
        v = new Add();
    }

    @Test
    public void simple_test() {
        assertEquals("1+2=3", v.add(1, 2));
        assertEquals("1+2+3=6", v.add(1, 2, 3));
    }

    @Test
    public void method_not_overloaded_test() throws Exception {
        Method[] methods = Add.class.getDeclaredMethods();
        Set<String> set = new HashSet<>();
        boolean overload = false;

        for (int i = 0; i < methods.length; i++) {
            if (set.contains(methods[i].getName())) {
                overload = true;
                break;
            }
            set.add(methods[i].getName());
        }
        if (overload) {
            throw new Exception("Overloading not allowed");
        }
    }
}
