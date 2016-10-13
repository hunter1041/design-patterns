package org.hunter1041.javaday.designpatterns.proxy;

/**
 * @author Alexander Pashinskiy
 * @since 5/12/2015
 * @version 1.0
 */
public class Resource {
    public Resource() {
        System.out.println("Creating resource");
    }
    public void func1(){
        System.out.println("Run function 1");
    }
    public void func2(){
        System.out.println("Run function 2");
    }
    public void finalize() {
        System.out.println("Closing resource");
    }
}
