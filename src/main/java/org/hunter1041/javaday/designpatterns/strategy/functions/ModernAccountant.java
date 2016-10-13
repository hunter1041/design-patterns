package org.hunter1041.javaday.designpatterns.strategy.functions;

import org.hunter1041.javaday.designpatterns.strategy.classic.Position;

import java.util.function.ToIntFunction;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class ModernAccountant {
        private final ToIntFunction<Position> calculator;

        public ModernAccountant(ToIntFunction<Position> calculator) {
            this.calculator = calculator;
        }

        public void transfer(Position position) {
            int amount = calculator.applyAsInt(position);
            System.out.println("For position: " + position + "ammoutn " + amount + " was transfered.");
        }
}
