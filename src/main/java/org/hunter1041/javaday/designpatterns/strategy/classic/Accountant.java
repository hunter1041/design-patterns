package org.hunter1041.javaday.designpatterns.strategy.classic;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class Accountant {
    private final IncomeCalculator calculator;

    public Accountant(IncomeCalculator calculator) {
        this.calculator = calculator;
    }

    public void transfer(Position position) {
        int amount = calculator.calculate(position);
        System.out.println("For position: " + position + "amount " + amount + " was transferred.");
    }
}
