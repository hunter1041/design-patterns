package org.hunter1041.javaday.designpatterns.chainofresponsibility;

import org.hunter1041.javaday.designpatterns.chainofresponsibility.classic.AuthRequestHandler;
import org.hunter1041.javaday.designpatterns.chainofresponsibility.classic.CORSRequestHandler;
import org.hunter1041.javaday.designpatterns.chainofresponsibility.classic.LogRequestHandler;
import org.hunter1041.javaday.designpatterns.chainofresponsibility.classic.Request;
import org.hunter1041.javaday.designpatterns.chainofresponsibility.classic.RequestHandler;
import org.hunter1041.javaday.designpatterns.chainofresponsibility.functioncomposition.RequestHandlers;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author APASHYNSKIY
 * @since 07/12/2015
 * @version 1.0
 */
public class ChainOfResponsibilityTest {

    @Test
    public void chainOfResponsibilityClassic() {
        AuthRequestHandler authHandler = new AuthRequestHandler(null);
        CORSRequestHandler corsAuthHandler = new CORSRequestHandler(authHandler);
        RequestHandler chain = new LogRequestHandler(corsAuthHandler);

        Request localRequest = new Request("1", "127.0.0.1", "Alex"); // id, ip, name
        chain.handleRequest(localRequest);

        System.out.println("\n-----------------------------------------------------\n");

        Request externalRequest = new Request("2", "121.23.76.25", "Bob");
        chain.handleRequest(externalRequest);

        // define an interface
        // create implementation for chaining
        // build a chain
        // do we really need all these classes with difficult relationships???
        // somewhere we already saw it!!! hm...
        // just a chain of function compositions!!!
        // we use java8 -> streams to rescue!!!
    }

    @Test(expected = IllegalArgumentException.class)
    public void chainOfResponsibilityFunctionComposition() {
        Consumer<Request> chain = buildChain(RequestHandlers::log, RequestHandlers::cors, RequestHandlers::auth);

        Request localRequest = new Request("1", "127.0.0.1", "Alex");
        chain.accept(localRequest);

        System.out.println("\n-----------------------------------------------------\n");

        Request foreignRequest = new Request("2", "121.23.76.25", "Bob");
        chain.accept(foreignRequest);

        // just an ordered stream of functions
        // composed in order
    }

    private Consumer<Request> buildChain(Consumer<Request>... handlers) {
        return Stream.of(handlers).reduce(Consumer::andThen).get();
    }
}