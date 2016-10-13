package org.hunter1041.javaday.designpatterns.builder.classic;

import com.google.common.base.MoreObjects;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class Email {
    private String from;
    private String to;
    private String cc;
    private String subject;
    private String body;

    public static ReusableBuilder reusableBuilder() {
        return new ReusableBuilder();
    }

    public static SimpleBuilder simpleBuilder() {
        return new SimpleBuilder();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public static class SimpleBuilder {

        Email email = new Email();
        public SimpleBuilder body(String body) {
            email.setBody(body);
            return this;
        }

        public SimpleBuilder subject(String subject) {
            email.setSubject(subject);
            return this;
        }

        public SimpleBuilder to(String to) {
            email.setTo(to);
            return this;
        }

        public SimpleBuilder from(String from) {
            email.setFrom(from);
            return this;
        }

        public SimpleBuilder cc(String cc) {
            email.setCc(cc);
            return this;
        }

        public Email build() {
            return email;
        }

    }

    public static class ReusableBuilder {
        private String from;
        private String to;
        private String cc;
        private String subject;
        private String body;

        public ReusableBuilder body(String body) {
            this.body = body;
            return this;
        }

        public ReusableBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public ReusableBuilder to(String to) {
            this.to = to;
            return this;
        }

        public ReusableBuilder from(String from) {
            this.from = from;
            return this;
        }

        public ReusableBuilder cc(String cc) {
            this.cc = cc;
            return this;
        }

        public Email build() {
            Email email = new Email();
            email.setBody(this.body);
            email.setCc(this.cc);
            email.setFrom(this.from);
            email.setTo(this.to);
            email.setSubject(this.subject);
            return email;
        }

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
