package io.github.clormor.hackerrank.advanced.factory;

public class FoodFactory {

    Food getFood(String order) {
        switch(order.toLowerCase()) {
            case "pizza":
                return new Pizza();
            case "cake":
                return new Cake();
            default:
                throw new IllegalArgumentException("Unrecognised food type!");
        }
    }
}
