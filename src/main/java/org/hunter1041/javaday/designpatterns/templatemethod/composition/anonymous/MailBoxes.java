package org.hunter1041.javaday.designpatterns.templatemethod.composition.anonymous;

import org.hunter1041.javaday.designpatterns.templatemethod.inheritance.Filter;
import org.hunter1041.javaday.designpatterns.templatemethod.inheritance.MailBox;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class MailBoxes {
    public static MailBox filterMailBox(MailBox mailBox, Filter mailFilter) {
        return new MailBox() {
            @Override
            public void store(String email) {
                if (mailFilter.allow(email)) {
                    mailBox.store(email);
                }
            }
        };
    }
}

// not required final parameters anymore
