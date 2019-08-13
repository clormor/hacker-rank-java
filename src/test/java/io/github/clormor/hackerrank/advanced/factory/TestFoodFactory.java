package io.github.clormor.hackerrank.advanced.factory;

import org.junit.Before;
import org.junit.Test;

import static io.github.clormor.hackerrank.advanced.factory.Cake.CAKE_TYPE;
import static io.github.clormor.hackerrank.advanced.factory.Pizza.PIZZA_TYPE;
import static org.junit.Assert.assertEquals;

public class TestFoodFactory {

    FoodFactory f;

    @Before
    public void setup() {
        f = new FoodFactory();
    }

    @Test
    public void simple_test() {
        testAndExpect("pizza", PIZZA_TYPE);
        testAndExpect("cake", CAKE_TYPE);
        testAndExpect("Pizza", PIZZA_TYPE);
        testAndExpect("cAke", CAKE_TYPE);
        testAndExpect("PIZZA", PIZZA_TYPE);
        testAndExpect("CakE", CAKE_TYPE);
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
