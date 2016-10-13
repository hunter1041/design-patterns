package org.hunter1041.javaday.designpatterns.chainofresponsibility.classic;

/**
 * @author Alexander Pashinskiy
 * @since 7/12/2015
 * @version 1.0
 */
public class AuthRequestHandler implements RequestHandler {
    private final RequestHandler nextHandler;

    public AuthRequestHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Request request) {
        System.out.println("Authenticating request: " + request);
        if (nextHandler != null)
            nextHandler.handleRequest(request);
    }
}
