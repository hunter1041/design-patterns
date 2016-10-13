package org.hunter1041.javaday.designpatterns.adapter;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public interface MailBox2 {
    void store(String email, EmailRetention retention);
}
