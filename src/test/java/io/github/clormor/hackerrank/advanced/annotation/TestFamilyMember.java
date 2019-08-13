package io.github.clormor.hackerrank.advanced.annotation;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static io.github.clormor.hackerrank.advanced.annotation.FamilyMember.BUST;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestFamilyMember {

    FamilyMember f;

    @Before
    public void setup() {
        f = new FamilyMember();
    }

    @Test
    public void test_junior() throws InvocationTargetException, IllegalAccessException {
        assertEquals("Junior:50", test_method("JUNIOR", 0));
        assertEquals("Junior:40", test_method("JUNIOR", 10));
        assertEquals("Junior:0", test_method("JUNIOR", 50));
        assertEquals(BUST, test_method("JUNIOR", 51));
    }

    @Test
    public void test_senior() throws InvocationTargetException, IllegalAccessException {
        assertEquals("Senior:100", test_method("SENIOR", 0));
        assertEquals("Senior:20", test_method("SENIOR", 80));
        assertEquals("Senior:40", test_method("SENIOR", 60));
        assertEquals("Senior:0", test_method("SENIOR", 100));
        assertEquals(BUST, test_method("SENIOR", 200));
    }

    public String test_method(String role, int spend) throws InvocationTargetException, IllegalAccessException {
        for (Method m : f.getClass().getDeclaredMethods()) {
            FamilyBudget budget = getBudget(m);
            if (role.equals(budget.userRole())) {
                return (String) m.invoke(f, budget.budgetLimit(), spend);
            }
        }
        return null;
    }

    private FamilyBudget getBudget(Method m) {
        if (m.isAnnotationPresent(FamilyBudget.class)) {
            return m.getAnnotation(FamilyBudget.class);
        } else {
            fail(String.format(
                    "Method %s does not have a @%s annotation",
                    m.getName(),
                    FamilyBudget.class.getSimpleName()));
        }
        return null;
    }
}
