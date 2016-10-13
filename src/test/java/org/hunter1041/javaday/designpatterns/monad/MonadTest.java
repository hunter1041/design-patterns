package org.hunter1041.javaday.designpatterns.monad;

import org.hunter1041.javaday.designpatterns.monad.classic.SimpleValidator;
import org.hunter1041.javaday.designpatterns.monad.monadic.Validation;
import org.hunter1041.javaday.designpatterns.monad.monadic.Validator;
import org.junit.Test;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class MonadTest {

    @Test
    public void simpleValidator() {
        User user = new User("", 17);
        SimpleValidator validator = new SimpleValidator();
        validator.validate(user);

        // 1. My validations looks like functions
        // 2. But we have 2 outputs: User and Exception
        // 3. We need something to represent ether User or Exception
        // 4. I also want to collect all validation errors
    }

    @Test
    public void monadicValidator() {
        User user = new User("", 17); // name, age

        Validation.success(user)
                .andThan(Validator::validateName)
                .andThan(Validator::validateAge)
                .get();

        // andThan() is monadic function flatMap() => rename

        // Validation represents either User or Error
        // Errors accumulation logic is encapsulated
        // Validation functions represent library of functions and are easily composable using andThan
        // Function composition achieved!!!
        // Validation is the Util -> wright once use everywhere
        // We need to implement only new validation functions
    }
}
