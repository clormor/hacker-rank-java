package io.github.clormor.hackerrank.advanced.factory;

class Pizza implements Food {
    public static final String PIZZA_TYPE = "Someone ordered a Fast Food!";

    @Override
    public String getType() {
        return PIZZA_TYPE;
    }
}
