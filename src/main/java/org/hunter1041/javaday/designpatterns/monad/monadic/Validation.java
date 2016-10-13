package org.hunter1041.javaday.designpatterns.monad.monadic;

import org.hunter1041.javaday.designpatterns.monad.ValidationError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class Validation<T> {
    private final T obj;
    private final List<ValidationError> errors;

    private Validation(T obj, List<ValidationError> errors) {
        this.obj = Objects.requireNonNull(obj);
        this.errors = errors;
    }

    public static <T> Validation<T> of(T t) {
        return success(t);
    }

    public static <T> Validation<T> success(T t) {
        return new Validation<>(t, new ArrayList<>());
    }

    public static <T> Validation<T>  failure(T t, String s) {
        return new Validation<>(t, Arrays.asList(new ValidationError(s)));
    }

    public Validation<T> andThan(Function<T, Validation<T>> validator) {
        Validation<T> result = validator.apply(obj);
        errors.addAll(result.errors);
        return new Validation<>(obj, new ArrayList<>(errors));
    }

    public T get() throws ValidationError {
        if (errors.isEmpty()) {
            return obj;
        }
        ValidationError error = new ValidationError("User Validation Exception");
        errors.forEach(error::addSuppressed);
        throw error;
    }
}
