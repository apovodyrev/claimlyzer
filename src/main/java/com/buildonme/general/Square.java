package com.buildonme.general;

/**
 * Created by Andrei on 6/9/2017
 */
public class Square extends Shape {
    Double sideAsObject;

    public Square(double sideLength) {
        this.sideAsObject = new Double(sideLength);
    }

    public double area() {
        return sideAsObject*sideAsObject;
    }


    @Override
    public String toString() {
        String str =  "Square{" +
                "sideLength=" + sideAsObject +
                " area=" + area() +
                '}';
        return str;
    }
}
