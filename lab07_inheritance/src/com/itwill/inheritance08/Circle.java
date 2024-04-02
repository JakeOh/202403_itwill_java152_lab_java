package com.itwill.inheritance08;

public class Circle extends Shape {
    // field
    private double radius;
    
    public Circle(double radius) {
        super("동그라미");
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
    
}
