package io.github.clormor.hackerrank.advanced.factory;

class Cake implements Food {
    public static final String CAKE_TYPE = "Someone ordered a Dessert!";

    @Override
    public String getType() {
        return CAKE_TYPE;
    }
}
