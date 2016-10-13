package org.hunter1041.javaday.designpatterns.templatemethod;

import org.hunter1041.javaday.designpatterns.templatemethod.composition.anonymous.MailBoxes;
import org.hunter1041.javaday.designpatterns.templatemethod.composition.function.ModernMailBox;
import org.hunter1041.javaday.designpatterns.templatemethod.composition.objects.ComposedFilterMailBox;
import org.hunter1041.javaday.designpatterns.templatemethod.composition.objects.JavaDayFilter;
import org.hunter1041.javaday.designpatterns.templatemethod.composition.statik.StaticMailBox;
import org.hunter1041.javaday.designpatterns.templatemethod.inheritance.JavaDayFilterMailBox;
import org.hunter1041.javaday.designpatterns.templatemethod.inheritance.FilterMailBox;
import org.hunter1041.javaday.designpatterns.templatemethod.inheritance.MailBox;
import org.junit.Test;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class TemplateMethodTest {

    @Test
    public void simpleMailbox() {
        MailBox mailBox = email -> System.out.println("Saved [" + email + "] to MailBox");

        mailBox.store("important JavaDay 2016 organization email");
        mailBox.store("not important advertising email");
        mailBox.store("another important JavaDay 2016 organization email");
    }

    @Test
    public void templateMethodInheritance() {
        MailBox mailBox = email -> System.out.println("Saved [" + email + "] to MailBox");
        FilterMailBox javaDayMailBox = new JavaDayFilterMailBox(mailBox);

        javaDayMailBox.store("important JavaDay 2016 organization email");
        javaDayMailBox.store("not important advertising email");
        javaDayMailBox.store("another important JavaDay 2016 organization email");

        // we should inherit from
        // behavior is scattered through class hierarchy
        // 2 responsibility -> sandbox and filter
    }

    @Test
    public void templateMethodComposition() {
        MailBox mailBox = email -> System.out.println("Saved [" + email + "] to MailBox");
        MailBox javaDayMailBox = new ComposedFilterMailBox(mailBox, new JavaDayFilter());

        javaDayMailBox.store("important JavaDay 2016 organization email");
        javaDayMailBox.store("not important advertising email");
        javaDayMailBox.store("another important JavaDay 2016 organization email");

        // Implementation doesn't add new methods
        // why do we need both: Interface and Implementation?
        // we don't need named class for this
        // lets make implementation as anonymous
        // in javadoc we will see a method - not a class
    }

    @Test
    public void templateMethodCompositionAnonymous() {
        MailBox mailBox = email -> System.out.println("Saved [" + email + "] to MailBox");
        MailBox javaDayMailBox = MailBoxes.filterMailBox(mailBox, new JavaDayFilter());

        javaDayMailBox.store("important JavaDay 2016 organization email");
        javaDayMailBox.store("not important advertising email");
        javaDayMailBox.store("another important JavaDay 2016 organization email");

        // why do we need wrapper class? I'ts - garbage!!!
        // we use java8 -> static methods in interface
    }

    @Test
    public void templateMethodCompositionStatic() {
        StaticMailBox mailBox = email -> System.out.println("Saved [" + email + "] to MailBox");
        StaticMailBox javaDayMailBox = StaticMailBox.filterMailBox(mailBox, email -> email.contains("JavaDay"));

        javaDayMailBox.store("important JavaDay 2016 organization email");
        javaDayMailBox.store("not important advertising email");
        javaDayMailBox.store("another important JavaDay 2016 organization email");

        // why do we pass mailbox to the mailbox. FTF???
        // we use java8 -> default methods in interfaces
        // Why do we need Filter interface - we use java8 -> Predicate
    }

    @Test
    public void templateMethodFunctionComposition() {
        ModernMailBox mailBox = email -> System.out.println("Saved [" + email + "] to MailBox");
        ModernMailBox javaDayMailBox = mailBox.filterMailBox(email -> email.contains("JavaDay"));

        javaDayMailBox.store("important JavaDay 2016 organization email");
        javaDayMailBox.store("not important advertising email");
        javaDayMailBox.store("another important JavaDay 2016 organization email");

        // We removed all classes!!!
        // We have only 1 interface!!!
        // Program to an Interface, not an implementation -> Done!!!
        // Favor object composition over class Inheritance -> Done!!!
    }
}

