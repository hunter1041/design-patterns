package org.hunter1041.javaday.designpatterns.templatemethod.composition.function;

import java.util.function.Predicate;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
@FunctionalInterface
public interface ModernMailBox {
    void store(String email);

    default ModernMailBox filterMailBox(Predicate<String> mailFilter) {
        return email -> {if (mailFilter.test(email)) store(email);};
    }
}
