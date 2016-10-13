package org.hunter1041.javaday.designpatterns.iterator.internal;

import java.util.stream.Stream;

/**
 * @author Alexander Pashinskiy
 * @since 04/12/2015
 * @version 1.0
 */
public interface ModernBook {
    Stream<String> chaptersStream();
}
