package org.hunter1041.javaday.designpatterns.builder.classic;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public final class Mailer {
    private Mailer() {}

    public static void send(Email email) {
        System.out.println("Sending email: " + email);
    }
}
