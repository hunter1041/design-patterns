package org.hunter1041.javaday.designpatterns.templatemethod.composition.statik;

import org.hunter1041.javaday.designpatterns.templatemethod.inheritance.Filter;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
@FunctionalInterface
public interface StaticMailBox {
    void store(String email);

    static StaticMailBox filterMailBox(StaticMailBox mailBox, Filter mailFilter) {
        return email -> {if (mailFilter.allow(email)) mailBox.store(email);};
    }
}
