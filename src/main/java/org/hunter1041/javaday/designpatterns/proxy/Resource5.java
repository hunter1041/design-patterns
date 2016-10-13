package org.hunter1041.javaday.designpatterns.proxy;

import java.util.function.Function;

/**
 * @author APASHYNSKIY
 * @since 07/12/2015
 * @version 1.0
 */
public final class Resource5 {

    private Resource5(String param1, String param2) {
        System.out.println("Creating resource with params: [" + param1 + ", " + param2 + "]");
    }

    public static Resource5 withParameters(String... initParams) {
        return new Resource5(initParams[0], initParams[1]);
    }

    public Resource5 func1() {
        System.out.println("Run function 1");
    return this;

    }
    public Resource5 func2() {
        System.out.println("Run function 2");
    return this;

    }

    private void close() {
        System.out.println("Closing resource");

    }

    public <T> T use(Function<Resource5, T> consumer) {
        try {
            return consumer.apply(this);
        } finally {
            this.close();
        }
    }
}
