package org.hunter1041.javaday.designpatterns.builder;

import com.google.common.base.MoreObjects;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class Mailer1 {
    private String from;
    private String to;
    private String cc;
    private String subject;
    private String body;

    public void from(String from) {
        this.from = from;
    }

    public void to(String to) {
        this.to = to;
    }

    public void cc(String cc) {
        this.cc = cc;
    }

    public void subject(String subject) {
        this.subject = subject;
    }

    public void body(String body) {
        this.body = body;
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
}
