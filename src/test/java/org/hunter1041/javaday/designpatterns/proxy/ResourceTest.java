package org.hunter1041.javaday.designpatterns.proxy;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author APASHYNSKIY
 * @since 07/12/2015
 * @version 1.0
 */
public class ResourceTest {
    @Test
    public void incorrectResourceManager() {
        Resource resource = new Resource();
        resource.func1();
        resource.func2();

        // Java automatic resource management
        // do you really trust to thing with Management in his name???
        // really not)))

        // System.gc();
        // resource.finalize();

        // it's completely broken((((
        // what to do?
        // lets rename method and call one by hand!!!
    }

    @Test
    public void almostCorrectResourceManager() {
        Resource2 resource = new Resource2();
        resource.func1();
        resource.func2();
        resource.close();

        // it works!!! Great but ...
        // what about exceptions???
        // and easy to forget close???
        // try-catch for rescue!!!
    }

    @Test
    public void correctResourceManager() {
        Resource2 resource = new Resource2();
        try {
            resource.func1();
            resource.func2();
        } finally {
            resource.close();
        }

        // it works!!! But ...
        // easy to forget close + finally
        // verbose
        // ARM Java7 try-catch with resources for rescue!!!
    }

    @Test
    public void ARMJava7ResourceManager() {
        try(Resource3 resource = new Resource3()) {
            resource.func1();
            resource.func2();
        }

        // easy to forget try???
        // needed to implement AutoClosable interface from jdk
        // compiler knows resource is AutoClosable but will no give you an error =((((((((((((
        // lets reverse the WORLD!!!
        // user - please provide your code - we will do housekeeping for you
    }

    @Test
    public void rightResourceManager() {
        Resource4.use(resource -> {
            resource.func1();
            resource.func2();
        });

        Consumer<Resource4> resourceConsumer = resource -> {
                    resource.func1().func2();
        };

        Resource4.use(resourceConsumer);

        // cool!!!
        // I shouldn't care about closing resource.
        // It's really cool!!!
        // But how to get result from my functionality???
        // And I want to configure resource!!!
        // It's really easy -> use factory method or builder
        // Use generics to return result
    }

    @Test
    public void moreFeaturedResourceManager() {
        String result = Resource5.withParameters("connections=5", "timeout=300ms")
                .use(resource -> {
                    resource.func1();
                    resource.func2();
                    return "result";
                });

        System.out.println(result);
    }

    // Proxy -> Lawyer (resource management, transactions, logging, ...)
    // LightWeight proxy!!!
}
