package org.hunter1041.javaday.designpatterns.templatemethod.composition.objects;

import org.hunter1041.javaday.designpatterns.templatemethod.inheritance.Filter;

/**
 * C@author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class JavaDayFilter implements Filter {
    @Override
    public boolean allow(String email) {
        return email.contains("");
    }
}
