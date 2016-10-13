package org.hunter1041.javaday.designpatterns.decorator;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class SimpleCharacterCounter implements CharacterCounter {
    @Override
    public int count(String string) {
        return string.length();
    }
}
