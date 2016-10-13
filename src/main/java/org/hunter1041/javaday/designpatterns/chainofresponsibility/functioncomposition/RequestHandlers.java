package org.hunter1041.javaday.designpatterns.chainofresponsibility.functioncomposition;

import org.hunter1041.javaday.designpatterns.chainofresponsibility.classic.Request;

/**
 * @author Alexander Pashinskiy
 * @since 7/12/2015
 * @version 1.0
 */
public class RequestHandlers {
    private RequestHandlers() {}

    public static void log(Request request) {
        System.out.println("Logging request: " + request);
    }

    public static void cors(Request request) {
        System.out.println("Handling CORS request: " + request);
        if (!request.getParameters().contains("127.0.0.1"))
            System.out.println("Detected cross origin request!!!");
    }

    public static void auth(Request request) {
        System.out.println("Authenticating request: " + request);
    }
}
