package io.github.clormor.hackerrank.advanced;

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

interface Food {
    static final String pizzaType = "Someone ordered a Fast Food!";
    static final String cakeType = "Someone ordered a Dessert!";
    public String getType();
}

class Pizza implements Food {
    @Override
    public String getType() {
        return pizzaType;
    }
}

class Cake implements Food {
    @Override
    public String getType() {
        return cakeType;
    }
}
