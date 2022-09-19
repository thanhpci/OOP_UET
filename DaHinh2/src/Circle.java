import static java.lang.Math.PI;
import static java.lang.Math.abs;

public class Circle extends Shape {
    protected double radius;
    protected Point center;

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

    public Circle(Point center,double radius, String color, boolean filled) {
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
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
        return "Circle[center=" + center.toString() + ",radius=" + radius + ",color=" + color + ",filled=" + filled + ']';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Circle) {
            Circle other = (Circle) obj;
            if (abs(other.radius - radius) <= 0.001 && center.equals(other.center)) {
                return true;
            }
        }
        return false;
    }

}
