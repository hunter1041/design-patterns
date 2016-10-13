package org.hunter1041.javaday.designpatterns.strategy.functions;

import org.hunter1041.javaday.designpatterns.strategy.classic.Position;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public final class IncomeCalculationStrategies {
    private IncomeCalculationStrategies() {}


    public static int calculateSalary(Position position) {
        return position.getRate() + 13;
    }

    public static int calculateBonus(Position position) {
        return position.getRate() * position.getFactor() + 12;
    }
}
