package org.hunter1041.javaday.designpatterns.adapter;

import org.hunter1041.javaday.designpatterns.adapter.classic.MailBoxAdapter;
import org.hunter1041.javaday.designpatterns.adapter.partialapplication.MailBox2PA;
import org.hunter1041.javaday.designpatterns.templatemethod.inheritance.MailBox;
import org.junit.Test;

import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntFunction;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class AdapterTest {
    @Test
    public void adapterIntro() {
        MailBox mailBox = email -> System.out.println("I'm saving email: [" + email + "]");
        mailBox.store("important JavaDay email");

        MailBox2 mailbox2 = (email,retention) -> System.out.println("I'm saving email: [" + email + "] for " + retention);
        mailbox2.store("personal email", EmailRetention.MONTH);

        // how to adapt???
        // MailBox mailBox = mailbox2;
    }

    @Test
    public void adapterClassic() {
        MailBox2 mailbox2 = (email,retention) -> System.out.println("I'm saving email: [" + email + "] for " + retention);
        MailBox adapter = new MailBoxAdapter(mailbox2);
        adapter.store("another important email");

        // implement an interface
        // get original object to adapt
        // set default value
        // do we really need these classes with relationships
        // it's looks like simple partial applications
        // how to implement???
        // we use java8 -> default methods to rescue
    }

    @Test
    public void adapterPartialApplication() {
        MailBox2PA mailbox2 = (email, retention) -> System.out.println("I'm saving email: [" + email + "] for " + retention);
        MailBox mailBox = mailbox2.retention(EmailRetention.EVER);
        mailBox.store("another important JavaDay email");

        // just a simple partial application!!!
    }
}
