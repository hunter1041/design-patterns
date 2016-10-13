package org.hunter1041.javaday.designpatterns.visitor;

import org.hunter1041.javaday.designpatterns.visitor.classic.AreaVisitor;
import org.hunter1041.javaday.designpatterns.visitor.classic.Circle;
import org.hunter1041.javaday.designpatterns.visitor.classic.Element;
import org.hunter1041.javaday.designpatterns.visitor.classic.PerimeterVisitor;
import org.hunter1041.javaday.designpatterns.visitor.classic.Rectangle;
import org.hunter1041.javaday.designpatterns.visitor.classic.Square;
import org.hunter1041.javaday.designpatterns.visitor.classic.Visitor;
import org.hunter1041.javaday.designpatterns.visitor.patternmatching.LambdaVisitor;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author Alexander Pashinskiy
 * @since 12/06/2016
 * @version 1.0
 */
public class VisitorTest {
    @Test
    public void classicVisitor() {
        List<Element> figures = Arrays.asList(new Circle(3), new Rectangle(2, 4), new Square(5));

        double totalArea = 0.0;
        Visitor<Double> areaVisitor = new AreaVisitor();
        for (Element figure : figures) {
            totalArea += figure.accept(areaVisitor);
        }
        System.out.println("Total area = " + totalArea);

        double totalPerimeter = 0.0;
        Visitor<Double> perimeterVisitor = new PerimeterVisitor();
        for (Element figure : figures) {
            totalPerimeter += figure.accept(perimeterVisitor);
        }
        System.out.println("Total perimeter = " + totalPerimeter);
    }

    @Test
    public void lambdaVisitor() {
        List<Element> figures = Arrays.asList(new Circle(3), new Rectangle(4, 2), new Square(5));

        final Function<Element, Double> areaCalculator = new LambdaVisitor<Double>()
                .on(Circle.class).then(c -> Math.PI * c.radius * c.radius)
                .on(Rectangle.class).then(r -> r.width * r.height)
                .on(Square.class).then(s -> s.side * s.side);

        final Function<Element, Double> perimeterCalculator = new LambdaVisitor<Double>()
                .on(Circle.class).then(c -> 2 * Math.PI * c.radius)
                .on(Rectangle.class).then(r -> 2 * r.width + 2 * r.height)
                .on(Square.class).then(s -> 4 * s.side);

        double totalArea = figures.stream()
                .map(areaCalculator)
                .reduce(0.0, (a, b) -> a + b);

        System.out.println("Total area = " + totalArea);

        double totalPerimeter = figures.stream()
                .map(perimeterCalculator)
                .reduce(0.0, (a, b) -> a + b);

        System.out.println("Total perimeter = " + totalPerimeter);

        // LambdaVisitor is Util -> wright once use everywhere
    }
}
