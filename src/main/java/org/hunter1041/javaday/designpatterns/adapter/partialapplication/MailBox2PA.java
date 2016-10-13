package org.hunter1041.javaday.designpatterns.adapter.partialapplication;

import org.hunter1041.javaday.designpatterns.adapter.EmailRetention;
import org.hunter1041.javaday.designpatterns.templatemethod.inheritance.MailBox;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public interface MailBox2PA {
    void store(String email, EmailRetention retention);

    default MailBox retention(EmailRetention retention) {
        return email -> store(email, retention);
    }
}
