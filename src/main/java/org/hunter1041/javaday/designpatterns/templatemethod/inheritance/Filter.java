package org.hunter1041.javaday.designpatterns.templatemethod.inheritance;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public interface Filter {
    boolean allow(String email);
}
