package org.hunter1041.javaday.designpatterns.builder;

import org.hunter1041.javaday.designpatterns.builder.classic.Email;
import org.hunter1041.javaday.designpatterns.builder.classic.Mailer;
import org.hunter1041.javaday.designpatterns.builder.functional.FMailer;
import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class BuilderTest {
    @Test
    public void naiveBuilder() {
        Mailer1 mailer = new Mailer1();
        mailer.from("Alex");
        mailer.to("Bob");
        mailer.subject("event");
        mailer.body("you are invited");
        mailer.send();

        // noising mail.to(), mail.from(), ...
        // reusable???
    }

    @Test
    public void cascadeBuilder() {
        Mailer2 mailer = new Mailer2()
                .from("Alex")
                .to("Bob")
                .subject("event")
                .body("you are invited");

        mailer.send();

        // nice chaining
        // getters, setters???
        // reusable???
    }

    @Test
    public void classicBuilder()  {
        Email.SimpleBuilder simpleEmail = Email.simpleBuilder()
                .from("Alex")
                .to("Bob")
                .subject("event")
                .body("you are invited");

        Email email = simpleEmail.build();
        Mailer.send(email);

        System.out.println("\n----------------------------------------------------------\n");

        Email emailCcJavaDay = simpleEmail.cc("JavaDay 2016").build();
        System.out.println(emailCcJavaDay);



        // but every time we got the same object
        // reusable???
        // System.out.println("Is it the same object? - " + (email == emailCcJavaDay));
    }

    @Test
    public void reusableBuilder() {
        Email.ReusableBuilder emailTemplate = Email.reusableBuilder()
                .from("Alex")
                .to("Bob")
                .subject("event")
                .body("you are invited");

        Email email = emailTemplate.build();
        Mailer.send(email);

        System.out.println("\n----------------------------------------------------------\n");

        Email emailWithCc = emailTemplate
                .cc("JavaDay 2016")
                .build();

        Mailer.send(emailWithCc);

        System.out.println("Is it the same object? - " + (email == emailWithCc));

        // reusable!!! +++
        // but boilerplate copy-paste (((((
        // Mailer doesn't have control on the object
        // lets revert the WORLD again!!!
        // please say me how to build - I will build as you want!!!
    }

    @Test
    public void functionalBuilder() {
        FMailer.send(email -> email
                .from("Alex")
                .to("Bob")
                .subject("event")
                .body("you are invited"));

        // can reuse???
        // yes!!!
    }

    @Test
    public void reusableFunctionalBuilder() {
        Consumer<FMailer> simpleEmail = email -> email
                .from("Alex")
                .to("Bob")
                .subject("event")
                .body("you are invited");

        FMailer.send(simpleEmail);

        System.out.println("\n----------------------------------------------------------\n");

        Consumer<FMailer> simpleEmailWithCC = simpleEmail.andThen(email -> email.cc("JavaDay 2016"));

        FMailer.send(simpleEmailWithCC);

        // reusable!!! - again function composition
        // mailer has full control on object --> encapsulation!!!
        // can reuse (or not) the object in my encapsulated scope of Mailer!!!
    }
}
