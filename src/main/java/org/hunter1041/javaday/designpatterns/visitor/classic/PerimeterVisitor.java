package org.hunter1041.javaday.designpatterns.visitor.classic;

/**
 * @author Alexander Pashinskiy
 * @since 12/06/2016
 * @version 1.0
 */
public class PerimeterVisitor implements Visitor<Double> {
    @Override
    public Double visit(Circle circle) {
        return 2 * Math.PI * circle.radius;
    }

    @Override
    public Double visit(Rectangle rectangle) {
        return 2 * rectangle.width + 2 * rectangle.height;
    }

    @Override
    public Double visit(Square square) {
        return 4 * square.side;
    }
}
