abstract class Shape {
    double a, b;
    Shape(double a, double b) { this.a = a; this.b = b; }
    abstract void printArea();
}

class Rectangle extends Shape {
    Rectangle(double l, double w) { super(l, w); }
    void printArea() { System.out.println("Area of Rectangle = " + (a * b)); }
}

class Triangle extends Shape {
    Triangle(double base, double height) { super(base, height); }
    void printArea() { System.out.println("Area of Triangle = " + (0.5 * a * b)); }
}

class Circle extends Shape {
    Circle(double r) { super(r, 0); }
    void printArea() { System.out.printf("Area of Circle = %.2f%n", Math.PI * a * a); }
}

public class Main {
    public static void main(String[] args) {
        Shape s;
        s = new Rectangle(10, 5);  s.printArea();
        s = new Triangle(8, 6);    s.printArea();
        s = new Circle(7);         s.printArea();
    }
}
