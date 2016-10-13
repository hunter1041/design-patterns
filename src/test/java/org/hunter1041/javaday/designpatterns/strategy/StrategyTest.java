package org.hunter1041.javaday.designpatterns.strategy;

import org.hunter1041.javaday.designpatterns.strategy.classic.Accountant;
import org.hunter1041.javaday.designpatterns.strategy.classic.BonusCalculator;
import org.hunter1041.javaday.designpatterns.strategy.classic.Position;
import org.hunter1041.javaday.designpatterns.strategy.classic.SalaryCalculator;
import org.hunter1041.javaday.designpatterns.strategy.functions.AccountantFunction;
import org.hunter1041.javaday.designpatterns.strategy.functions.IncomeCalculationStrategies;
import org.hunter1041.javaday.designpatterns.strategy.functions.ModernAccountant;
import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.ToIntFunction;

/**
 * @author Alexander Pashinskiy
 * @since 07/12/2015
 * @version 1.0
 */
public class StrategyTest {
    @Test
    public void strategyClassic() {
        new Accountant(new SalaryCalculator()).transfer(new Position(1000, 3));
        new Accountant(new BonusCalculator()).transfer(new Position(1000, 3));

        // define interface
        // implement strategies
        // use strategy on demand
        // but strategies are just a function
        // lets define library of strategies functions instead!!!
    }

    @Test
    public void strategyFunctions() {
        new ModernAccountant(IncomeCalculationStrategies::calculateSalary).transfer(new Position(1000, 3));
        new ModernAccountant(IncomeCalculationStrategies::calculateBonus).transfer(new Position(1000, 3));

        // do we really need ModernAccountant class???
        // it looks like just a function
        // lets do it!!!
    }

    @Test
    public void strategyCustomModernFunctions() {
        AccountantFunction accountant = (position, incomeCalculator) -> {
            int  amount = incomeCalculator.applyAsInt(position);
            System.out.println("For position: " + position + "amount " + amount + " was transferred.");
        };

        accountant.transfer(new Position(1000, 3), IncomeCalculationStrategies::calculateSalary);
        accountant.transfer(new Position(1000, 3), IncomeCalculationStrategies::calculateBonus);

        // but AccountantFunctions looks like already exists in jdk!!!
    }

    @Test
    public void strategyModernFunctions() {
        BiConsumer<Position, ToIntFunction<Position>> accountant = (position, incomeCalculator) -> {
            int  amount = incomeCalculator.applyAsInt(position);
            System.out.println("For position: " + position + "amount " + amount + " was transferred.");
        };

        accountant.accept(new Position(1000, 3), IncomeCalculationStrategies::calculateSalary);
        accountant.accept(new Position(1000, 3), IncomeCalculationStrategies::calculateBonus);

        // we have only 1 class with strategies
        // it's really lightweight!!!
    }
}
