package org.hunter1041.javaday.designpatterns.templatemethod.inheritance;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class JavaDayFilterMailBox extends FilterMailBox {

    public JavaDayFilterMailBox(MailBox mailBox) {
        super(mailBox);
    }

    @Override
    public boolean allow(String email) {
        return email.contains("JavaDay");
    }
}
