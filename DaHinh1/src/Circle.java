import static java.lang.Math.PI;

public class Circle extends Shape {
    protected double radius;

    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     Method.
     */

    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     Method.
     */

    public double getArea() {
        return PI * radius * radius;
    }

    /**
     Method.
     */

    public double getPerimeter() {
        return 2.0 * PI * radius;
    }

    public String toString() {
        return "Circle[radius=" + radius + ",color=" + color + ",filled=" + filled + ']';
    }

}
