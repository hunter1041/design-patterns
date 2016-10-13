package org.hunter1041.javaday.designpatterns.decorator;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class NonWhitespaceCharacterCounter implements CharacterCounter {
    private final CharacterCounter characterCounter;

    public NonWhitespaceCharacterCounter(CharacterCounter characterCounter) {
        this.characterCounter = characterCounter;
    }

    @Override
    public int count(String string) {
        String stringWithoutWhitespaces = string.replaceAll(" ", "");
        return characterCounter.count(stringWithoutWhitespaces);
    }
}
