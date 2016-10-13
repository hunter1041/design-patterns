package org.hunter1041.javaday.designpatterns.visitor.classic;

/**
 * @author Alexander Pashinskiy
 * @since 12/06/2016
 * @version 1.0
 */
public interface Visitor<T> {
    T visit(Circle circle);
    T visit(Rectangle rectangle);
    T visit(Square square);
}
