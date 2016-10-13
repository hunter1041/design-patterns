package org.hunter1041.javaday.designpatterns.templatemethod.composition.objects;

import org.hunter1041.javaday.designpatterns.templatemethod.inheritance.Filter;
import org.hunter1041.javaday.designpatterns.templatemethod.inheritance.MailBox;

import static java.util.Objects.requireNonNull;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public final class ComposedFilterMailBox implements MailBox {
    private final Filter mailFilter;
    private final MailBox mailBox;

    public ComposedFilterMailBox(MailBox mailBox, Filter mailFilter) {
        this.mailBox = requireNonNull(mailBox);
        this.mailFilter = requireNonNull(mailFilter);
    }

    public void store(String email) {
        if (mailFilter.allow(email)) {
            mailBox.store(email);
        }
    }
}
