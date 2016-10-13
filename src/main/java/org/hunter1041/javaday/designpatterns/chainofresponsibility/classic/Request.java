package org.hunter1041.javaday.designpatterns.chainofresponsibility.classic;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Alexander Pashinskiy
 * @since 7/12/2015
 * @version 1.0
 */
public class Request {
    private final List<String> parameters;

    public Request(String... parameters) {
        this.parameters = asList(parameters);
    }

    @Override
    public String toString() {
        return "Request{" +
                "parameters=" + parameters +
                '}';
    }

    public List<String> getParameters() {
        return parameters;
    }
}
