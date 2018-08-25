package com.company;

public class Circle {
    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        String s;
    }

    @Override
    public String toString() {
        return "center = " + center + ", radius = " + radius;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if (obj == this)
            return true;
        if(obj instanceof Circle){
            Circle other = (Circle)obj;
            return this.radius == other.radius && this.center.equals(other.center);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 57 * radius * radius ^ 19 * center.hashCode();
    }
}
