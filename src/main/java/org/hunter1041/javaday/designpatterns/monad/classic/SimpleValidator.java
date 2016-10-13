package org.hunter1041.javaday.designpatterns.monad.classic;

import org.hunter1041.javaday.designpatterns.monad.User;
import org.hunter1041.javaday.designpatterns.monad.ValidationError;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class SimpleValidator {
   public User validate(User user) throws ValidationError {
        if (user.name == null) {
            throw new ValidationError("Name is null");
        }
        if (user.name.isEmpty()) {
           throw new ValidationError("Name is empty");
        }
       if (user.age < 18 || user.age > 100) {
           throw new ValidationError("Age isn't between 18 and 100");
       }
       return user;
   }
}
