package com.iglaz.astonbase.lesson3.B;

public class Rectangle extends Shape {
    private double w, h;

    public Rectangle(double w, double h) {
        super();
        this.w = w; this.h = h;
    }

    public Rectangle(int x, double w, double h) {
        super();
        this.w = w;
        this.h = h;
    }

    @Override
    public double area() {
        return w*h;
    }

    @Override
    public double circumference() {
        return 2*(w + h);
    }

    public double getWidth() {
        return w;
    }

    public double getHeight() {
        return h;
    }
}

