package org.hunter1041.javaday.designpatterns.templatemethod.inheritance;

import java.util.Objects;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public abstract class FilterMailBox implements MailBox, Filter {
    private final MailBox mailBox;

    public FilterMailBox(MailBox mailBox) {
        this.mailBox = Objects.requireNonNull(mailBox);
    }

    public final void store(String email) {
        if (allow(email)) {
            mailBox.store(email);
        }
    }

    public abstract boolean allow(String email);
}
