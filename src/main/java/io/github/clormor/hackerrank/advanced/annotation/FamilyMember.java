package io.github.clormor.hackerrank.advanced.annotation;

public class FamilyMember {

    static final String BUST = "Bust!";

    @FamilyBudget(userRole = "SENIOR", budgetLimit = 100)
    public String seniorMember(int budget, int moneySpent) {
        if (budget >= moneySpent) {
            return String.format("%s:%d", "Senior", budget - moneySpent);
        } else {
            return BUST;
        }
    }

    @FamilyBudget(userRole = "JUNIOR", budgetLimit = 50)
    public String juniorMember(int budget, int moneySpent) {
        if (budget >= moneySpent) {
            return String.format("%s:%d", "Junior", budget - moneySpent);
        } else {
            return BUST;
        }
    }
}
