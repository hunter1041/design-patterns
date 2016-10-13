package org.hunter1041.javaday.designpatterns.proxy;

/**
 * @author APASHYNSKIY
 * @since 07/12/2015
 * @version 1.0
 */
public class Resource3 implements AutoCloseable {
    public Resource3() {
        System.out.println("Creating resource");
    }
    public void func1(){
        System.out.println("Run function 1");
    }
    public void func2(){
        System.out.println("Run function 2");
    }
    public void close() {
        System.out.println("Closing resource");
    }
}
