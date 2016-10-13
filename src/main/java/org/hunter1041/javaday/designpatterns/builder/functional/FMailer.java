package org.hunter1041.javaday.designpatterns.builder.functional;

import com.google.common.base.MoreObjects;

import java.util.function.Consumer;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class FMailer {
        private String from;
        private String to;
        private String cc;
        private String subject;
        private String body;

        private FMailer() {}

        public FMailer from(String from) {
            this.from = from;
            return this;
        }

        public FMailer to(String to) {
            this.to = to;
            return this;
        }

        public FMailer cc(String cc) {
            this.cc = cc;
            return this;
        }

        public FMailer subject(String subject) {
            this.subject = subject;
            return this;
        }

        public FMailer body(String body) {
            this.body = body;
            return this;
        }

        public static void send(Consumer<FMailer> consumer) {
            FMailer mailer = new FMailer();
            consumer.accept(mailer);
            System.out.println("Sending email: " + mailer);
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
