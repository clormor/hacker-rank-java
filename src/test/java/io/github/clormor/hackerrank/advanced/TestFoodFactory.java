package io.github.clormor.hackerrank.advanced;

import org.junit.Before;
import org.junit.Test;

import static io.github.clormor.hackerrank.advanced.Food.cakeType;
import static io.github.clormor.hackerrank.advanced.Food.pizzaType;
import static org.junit.Assert.assertEquals;

public class TestFoodFactory {

    FoodFactory f;

    @Before
    public void setup() {
        f = new FoodFactory();
    }

    @Test
    public void simple_test() {
        Food p = f.getFood("pizza");
        assertEquals(pizzaType, p.getType());

        Food c = f.getFood("cake");
        assertEquals(cakeType, c.getType());
    }
}
