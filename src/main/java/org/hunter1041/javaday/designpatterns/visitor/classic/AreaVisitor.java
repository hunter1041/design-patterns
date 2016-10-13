package org.hunter1041.javaday.designpatterns.visitor.classic;

/**
 * @author Alexander Pashinskiy
 * @since 12/06/2016
 * @version 1.0
 */
public class AreaVisitor implements Visitor<Double> {
    @Override
    public Double visit(Circle circle) {
        return Math.PI * circle.radius * circle.radius;
    }

    @Override
    public Double visit(Rectangle rectangle) {
        return rectangle.height * rectangle.width;
    }

    @Override
    public Double visit(Square square) {
        return square.side * square.side;
    }
}
