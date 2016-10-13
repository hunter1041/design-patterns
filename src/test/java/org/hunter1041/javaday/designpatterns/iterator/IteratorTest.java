package org.hunter1041.javaday.designpatterns.iterator;

import org.hunter1041.javaday.designpatterns.iterator.external.Book;
import org.hunter1041.javaday.designpatterns.iterator.external.ChapterIterator;
import org.hunter1041.javaday.designpatterns.iterator.external.MultiChapterBook;
import org.hunter1041.javaday.designpatterns.iterator.internal.ModernBook;
import org.hunter1041.javaday.designpatterns.iterator.internal.ModernMultiChapterBook;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author APASHYNSKIY
 * @since 04/12/2015
 * @version 1.0
 */
public class IteratorTest {
    public static final String CHAPTER_SEPARATOR = "#";

    @Test
    public void externalIteratorFor() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        for (int i = 0; i < numbers.size(); i++) {
            businessLogic(numbers.get(i));
        }
    }

    @Test
    public void externalIterator() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Iterator<Integer> iter = numbers.iterator();

        while (iter.hasNext()) {
            businessLogic(iter.next());
        }
    }

    @Test
    public void externalIteratorForEach() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        for (Integer number : numbers) {
            businessLogic(number);
        }

        // cool!!!
        // but I need to remove an element(((((
        // lets go back to classic Iterator
    }

    @Test
    public void externalIteratorRemove() {
        // can't use Arrays.asList() -> UnsupportedOperationException
        List<Integer> numbers = newArrayList(1, 2, 3, 4, 5);

        for (Iterator<Integer> i = numbers.iterator(); i.hasNext();) {
            Integer number = i.next();
            if (number % 2 == 0) {
                System.out.println("Removing odd number: " + number);
                i.remove();
            }
        }

        System.out.println("Result numbers: " + numbers);

        // but we use java8 -> there is internal iterator!!!
    }

    @Test
    public void internalIterator() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.forEach(n -> businessLogic(n));

        // cool - I don't need to think how to iterate anymore!!!
        // separation of concerns -> I care about business logic only!!!
        // but if I need to remove an element???
        // removeIf() for rescue!!!
    }

    @Test
    public void internalIteratorRemove() {
        List<Integer> numbers = newArrayList(1, 2, 3, 4, 5);

        numbers.removeIf(n -> (n % 2) == 0);

        numbers.forEach(this::businessLogic);

        // but removing is no so good - moving parts increase the complexity
        // let's filter instead -> make our WORLD safe -> immutable!!!
    }

    @Test
    public void internalIteratorFilter() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.stream()
                .filter(numberGreaterThanTwo())
                .forEach(n -> businessLogic(n));

        System.out.println("Numbers: " + numbers);

        // but I need custom Iterator
        // let's implement
    }

    @Test
    public void customExternalIterator() {
        Book effectiveJava = new MultiChapterBook("#1.Introduction" +
                                      "#2.Creating And Destroying Objects" +
                                      "#3.Methods Common To All Objects" +
                                      "#4.Classes And Interfaces" +
                                      "#5.Generics" +
                                      "#6.Enums and Annotations" +
                                      "#7.Methods" +
                                      "#8.General Programming" +
                                      "#9.Exceptions" +
                                      "#10.Concurrency" +
                                      "#11.Serialization",
                                      CHAPTER_SEPARATOR);

        ChapterIterator iterator = effectiveJava.chapterIterator();

        while(iterator.hasNextChapter()) {
            System.out.println("Cool chapter: " + iterator.nextChapter());
        }

        // cool!!!
        // but I've used cool internal Iterator
        // I want internal Iterator!!!!!!!!!!!
        // lets implement!!!
        // how?
        // we need to implement Spliterator!!!
    }

    @Test
    public void customInternalIterator() {
        ModernBook effectiveJava = new ModernMultiChapterBook(
                "#1.Introduction" +
                "#2.Creating And Destroying Objects" +
                "#3.Methods Common To All Objects" +
                "#4.Classes And Interfaces" +
                "#5.Generics" +
                "#6.Enums and Annotations" +
                "#7.Methods" +
                "#8.General Programming" +
                "#9.Exceptions" +
                "#10.Concurrency" +
                "#11.Serialization",
                CHAPTER_SEPARATOR);

        effectiveJava.chaptersStream()
                .map(ch -> "Wow, really cool chapter: " + ch)
                .forEach(System.out::println);

        // cool!!!
        // I got all stream functionality for free as a bonus!!!
        // Lets use internal iterator instead of external!!!
    }

    private Predicate<Integer> numberGreaterThanTwo() {
        return n -> n > 2;
    }

    private void businessLogic(Integer i) {
        System.out.println(i);
    }
}
