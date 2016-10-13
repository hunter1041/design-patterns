package org.hunter1041.javaday.designpatterns.iterator.internal;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Objects.requireNonNull;

/**
 * @author Alexander Pashinskiy
 * @since 04/12/2015
 * @version 1.0
 */
public class ModernMultiChapterBook implements ModernBook {
    private final String text;
    private final String chapterSeparator;

    public ModernMultiChapterBook(String text, String chapterSeparator) {
        this.text = requireNonNull(text);
        this.chapterSeparator = requireNonNull(chapterSeparator);
    }

    @Override
    public Stream<String> chaptersStream() {
        return StreamSupport.stream(new ChaptersSpliterator(), false);
    }

    private class ChaptersSpliterator extends Spliterators.AbstractSpliterator<String> {

        int chapterStartIndex = 0;

        private ChaptersSpliterator() {
            super(Long.MAX_VALUE, Spliterator.NONNULL | Spliterator.SIZED);
        }

        @Override
        public boolean tryAdvance(Consumer<? super String> action) {
            // if book is empty or chapters is over
            if (chapterStartIndex >= text.length()) {
                return false;
            }

            // get index of next separator
            int separatorIndex = text.indexOf(chapterSeparator, chapterStartIndex + 1);

            if (separatorIndex < 0) {
                separatorIndex = text.length();
            }
            String chapter = text.substring(chapterStartIndex, separatorIndex);

            action.accept(chapter);

            chapterStartIndex = separatorIndex;
            return true;
        }
    }
}
