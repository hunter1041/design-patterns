package org.hunter1041.javaday.designpatterns.chainofresponsibility.classic;

/**
 * @author Alexander Pashinskiy
 * @since 7/12/2015
 * @version 1.0
 */
public class LogRequestHandler implements RequestHandler {
    private final RequestHandler nextHandler;

    public LogRequestHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Request request) {
        logRequest(request);

        if (nextHandler != null)
            nextHandler.handleRequest(request);
    }

    private void logRequest(Request request) {
        System.out.println("Logging request: " + request);
    }
}
