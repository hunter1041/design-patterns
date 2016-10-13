package org.hunter1041.javaday.designpatterns.builder;

import com.google.common.base.MoreObjects;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class Mailer2 {
    private String from;
    private String to;
    private String cc;
    private String subject;
    private String body;

    public Mailer2 from(String from) {
        this.from = from;
        return this;
    }

    public Mailer2 to(String to) {
        this.to = to;
        return this;
    }

    public Mailer2 cc(String cc) {
        this.cc = cc;
        return this;
    }

    public Mailer2 subject(String subject) {
        this.subject = subject;
        return this;
    }

    public Mailer2 body(String body) {
        this.body = body;
        return this;
    }

    public void send() {
        System.out.println("Sending email: " + this);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("from", from)
                .add("to", to)
                .add("cc", cc)
                .add("subject", subject)
                .add("body", body)
                .omitNullValues()
                .toString();
    }

    // nice chaining
    // reusable???
}
