package com.buildonme.general;

/**
 * Created by Andrei on 6/9/2017
 */
public class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return radius*radius*Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                " area=" + area() +
                '}';
    }
}
