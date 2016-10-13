package org.hunter1041.javaday.designpatterns.chainofresponsibility.classic;

/**
 * @author Alexander Pashinskiy
 * @since 7/12/2015
 * @version 1.0
 */
public interface RequestHandler {
    void handleRequest(Request request);
}
