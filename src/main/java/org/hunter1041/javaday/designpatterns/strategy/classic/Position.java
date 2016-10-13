package org.hunter1041.javaday.designpatterns.strategy.classic;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class Position {
    private final int rate;
    private final int factor;

    public Position(int rate, int factor) {
        this.rate = rate;
        this.factor = factor;
    }

    public int getRate() {
        return rate;
    }

    public int getFactor() {
        return factor;
    }

    @Override
    public String toString() {
        return "Position{" +
                "rate=" + rate +
                ", factor=" + factor +
                '}';
    }
}
