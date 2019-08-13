package io.github.clormor.hackerrank.advanced.factory;

import org.junit.Before;
import org.junit.Test;

import static io.github.clormor.hackerrank.advanced.factory.Food.cakeType;
import static io.github.clormor.hackerrank.advanced.factory.Food.pizzaType;
import static org.junit.Assert.assertEquals;

public class TestFoodFactory {

    FoodFactory f;

    @Before
    public void setup() {
        f = new FoodFactory();
    }

    @Test
    public void simple_test() {
        testAndExpect("pizza", pizzaType);
        testAndExpect("cake", cakeType);
        testAndExpect("Pizza", pizzaType);
        testAndExpect("cAke", cakeType);
        testAndExpect("PIZZA", pizzaType);
        testAndExpect("CakE", cakeType);
    }

    private void testAndExpect(String order, String expectedType) {
        assertEquals(expectedType, f.getFood(order).getType());
    }

    @Test (expected = IllegalArgumentException.class)
    public void invalid_food_test() {
        f.getFood("Chips");
    }

    @Test (expected = IllegalArgumentException.class)
    public void order_not_trimmed_test() {
        f.getFood(" pizza");
    }

    @Test (expected = NullPointerException.class)
    public void order_does_not_like_null() {
        f.getFood(null);
    }
}
