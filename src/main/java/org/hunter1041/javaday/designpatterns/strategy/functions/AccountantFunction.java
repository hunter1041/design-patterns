package org.hunter1041.javaday.designpatterns.strategy.functions;

import org.hunter1041.javaday.designpatterns.strategy.classic.Position;

import java.util.function.ToIntFunction;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
@FunctionalInterface
public interface AccountantFunction {
    void transfer(Position position, ToIntFunction<Position> incomeCalculator);
}
