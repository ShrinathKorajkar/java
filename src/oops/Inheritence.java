package oops;

abstract class Shape {

    abstract void area();
}

class Triangle extends Shape {

    int length, breadth;

    Triangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    void area() {
        System.out.println("area of triangle " + (float) 1 / 2 * length * breadth);
    }
}

class Circle extends Shape {

    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    void area() {
        System.out.println("area of circle " + 3.14 * radius * radius);
    }
}

public class Inheritence {
    public static void main(String[] args) {
        Triangle tri = new Triangle(10, 15);
        tri.area();
        Circle circle = new Circle(5);
        circle.area();
    }

}
