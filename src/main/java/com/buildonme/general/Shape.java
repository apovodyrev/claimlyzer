package com.buildonme.general;


/**
 * Created by Andrei on 6/9/2017
 */
public class Shape {
    static int counter = 0;

    public Shape() {
        counter++;
    }

    double area(){
        throw new RuntimeException("this method must be overiden by children");
    }

    public void printme(){
        System.out.println(this.toString());
        System.out.println(counter);
    }
}
