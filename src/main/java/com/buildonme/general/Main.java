package com.buildonme.general;

import org.apache.log4j.Logger;

/**
 * Created by Andrei on 6/9/2017
 */
public  class Main {
    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String [] args){

        Square s = new Square(2);
        print(s);

        Circle c = new Circle(2);
         print(c);

    }

    public static void print(Shape s){
        s.printme();
    }
}
