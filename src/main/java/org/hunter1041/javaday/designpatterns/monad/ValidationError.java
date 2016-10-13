package org.hunter1041.javaday.designpatterns.monad;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class ValidationError extends IllegalStateException {
    public ValidationError(String validationMessage) {
        super(validationMessage);
    }
}
