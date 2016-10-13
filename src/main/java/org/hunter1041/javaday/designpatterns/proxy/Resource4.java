package org.hunter1041.javaday.designpatterns.proxy;

import java.util.function.Consumer;

/**
 * @author APASHYNSKIY
 * @since 07/12/2015
 * @version 1.0
 */
public class Resource4 {
    private Resource4() {
        System.out.println("Creating resource");
    }

    public Resource4 func1(){
        System.out.println("Run function 1");
        return this;
    }

    public Resource4 func2(){
        System.out.println("Run function 2");
        return this;
    }

    private void close() {
        System.out.println("Closing resource");
    }

    public static void use(Consumer<Resource4> consumer) {
        Resource4 resource = new Resource4();
        try {
            consumer.accept(resource);
        } finally {
            resource.close();
        }
    }
}
