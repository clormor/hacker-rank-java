package io.github.clormor.hackerrank.advanced;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
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

    @Test
    public void test_private_method() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        testPowerOf2(2, true);
        testPowerOf2(1, true);
        testPowerOf2(3, false);
        testPowerOf2(0, false);
        testPowerOf2(-1, false);
        testPowerOf2(4, true);
        testPowerOf2(16, true);
        testPowerOf2(248, false);
    }

    private void testPowerOf2(int n, boolean expected) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Object o = null;
        Constructor ctor = ReflectionExample.Inner.Private.class.getDeclaredConstructors()[0];
        ctor.setAccessible(true);
        o = ctor.newInstance(new ReflectionExample.Inner());
        Method powerOf2 = o.getClass().getDeclaredMethod("powerOf2", int.class);
        powerOf2.setAccessible(true);
        boolean result = (boolean) powerOf2.invoke(o, n);
        assertEquals(expected, result);
    }
}
