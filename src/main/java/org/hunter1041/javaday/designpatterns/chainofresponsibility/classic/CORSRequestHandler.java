package org.hunter1041.javaday.designpatterns.chainofresponsibility.classic;

/**
 * @author Alexander Pashinskiy
 * @since 7/12/2015
 * @version 1.0
 */
public class CORSRequestHandler implements RequestHandler {
    private final RequestHandler nextHandler;

    public CORSRequestHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Request request) {
        System.out.println("Handling CORS request: " + request);

        if (!request.getParameters().contains("127.0.0.1"))
            System.out.println("Detected cross origin request!!!");

        if (nextHandler != null)
            nextHandler.handleRequest(request);
    }
}
