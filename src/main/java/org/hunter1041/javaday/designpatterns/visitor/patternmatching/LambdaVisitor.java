package org.hunter1041.javaday.designpatterns.visitor.patternmatching;

import org.hunter1041.javaday.designpatterns.visitor.classic.Element;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Alexander Pashinskiy
 * @since 12/06/2016
 * @version 1.0
 */
public class LambdaVisitor<R> implements Function<Element, R> {
    private Map<Class<? extends Element>, Function<Element, R>> fMap = new HashMap<>();

    @Override
    public R apply(Element o) {
        return fMap.get(o.getClass()).apply(o);
    }

    public <T extends Element> Acceptor<R, T> on(Class<T> clazz) {
        return new Acceptor<>(this, clazz);
    }

    public static class Acceptor<R, T> {
        private final LambdaVisitor visitor;
        private final Class<T> clazz;

        public Acceptor(LambdaVisitor<R> visitor, Class<T> clazz) {
            this.visitor = visitor;
            this.clazz = clazz;
        }

        public LambdaVisitor<R> then(Function<T, R> f) {
            visitor.fMap.put(clazz, f);
            return visitor;
        }
    }
}
