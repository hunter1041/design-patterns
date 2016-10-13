package org.hunter1041.javaday.designpatterns.visitor.classic;

/**
 * @author Alexander Pashinskiy
 * @since 12/06/2016
 * @version 1.0
 */
public interface Element {
    <T> T accept(Visitor<T> visitor);
}
