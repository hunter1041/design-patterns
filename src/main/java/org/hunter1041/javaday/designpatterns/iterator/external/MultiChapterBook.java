package org.hunter1041.javaday.designpatterns.iterator.external;

import static java.util.Objects.requireNonNull;

/**
 * @author Alexander Pashinskiy
 * @since 04/12/2015
 * @version 1.0
 */
public class MultiChapterBook implements Book {
    private final String text;
    private final String chapterSeparator;

    public MultiChapterBook(String bookText, String chapterSeparator) {
        this.text = requireNonNull(bookText);
        this.chapterSeparator = requireNonNull(chapterSeparator);
    }

    @Override
    public ChapterIterator chapterIterator() {
        return new SeparatorBasedChapterIterator();
    }

    private class SeparatorBasedChapterIterator implements ChapterIterator {
        int chapterStartIndex = 0;

        @Override
        public String nextChapter() {
            // if book is empty or chapters is over
            if (chapterStartIndex >= text.length()) {
                return null;
            }

            // get index of next separator
            int separatorIndex = text.indexOf(chapterSeparator, chapterStartIndex + 1);

            if (separatorIndex < 0) {
                separatorIndex = text.length();
            }
            String chapter = text.substring(chapterStartIndex, separatorIndex);
            chapterStartIndex = separatorIndex;
            return chapter;
        }

        @Override
        public boolean hasNextChapter() {
            return chapterStartIndex < text.length() - 1;
        }
    }
}
