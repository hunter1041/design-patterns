package org.hunter1041.javaday.designpatterns.decorator;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class DecoratorTest {
    @Test
    public void decoratorClassic() {
        CharacterCounter counter = new NonWhitespaceCharacterCounter(new SimpleCharacterCounter());
        System.out.println(counter.count(" abc de"));

        // implement same interface
        // get instance of original object
        // do we really need classes with difficult relationships???
        // but it looks like a simple function composition
    }

    @Test
    public void decoratorCustomModern() {
        Function<String, String> removeWhitespaces = s -> s.replaceAll(" ", "");
        int num = removeWhitespaces.andThen(new SimpleCharacterCounter()::count).apply(" abc de");

        System.out.println(num);

        // do wee really need SimpleCharacterCounter class?
        // we need only function for decoration
    }

    @Test
    public void decoratorModern() {
        Function<String, String> removeWhitespaces = s -> s.replaceAll(" ", "");
        Function<String, Integer> calculateLength = String::length;

        Function<String, Integer> calculator = removeWhitespaces.andThen(calculateLength);

        System.out.println(calculator.apply(" abc de"));

        // it's just function composition!!!
    }
}