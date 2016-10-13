package org.hunter1041.javaday.designpatterns.adapter.classic;

import org.hunter1041.javaday.designpatterns.adapter.EmailRetention;
import org.hunter1041.javaday.designpatterns.adapter.MailBox2;
import org.hunter1041.javaday.designpatterns.templatemethod.inheritance.MailBox;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class MailBoxAdapter implements MailBox {
    private final MailBox2 mailBox;

    public MailBoxAdapter(MailBox2 mailBox) {
        this.mailBox = mailBox;
    }

    @Override
    public void store(String email) {
        mailBox.store(email, EmailRetention.EVER);
    }
}
