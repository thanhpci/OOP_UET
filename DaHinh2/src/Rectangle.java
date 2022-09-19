import static java.lang.Math.abs;

public class Rectangle extends Shape {
    protected double width;
    protected double length;
    protected Point topLeft;

    public Rectangle() {}

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /**
     Method.
     */

    public Rectangle(double width, double length, String color, boolean filled) {
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
    }

    public Rectangle(Point topLeft, double width, double length, String color, boolean filled) {
        this.topLeft = topLeft;
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    /**
     Method.
     */

    public double getArea() {
        return width * length;
    }

    /**
     Method.
     */

    public double getPerimeter() {
        return 2 * (width + length);
    }

    public String toString() {
        return "Rectangle[topLeft=" + topLeft.toString() +  ",width=" + width + ",length="
                + length + ",color=" + color + ",filled=" + filled + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Rectangle) {
            Rectangle other = (Rectangle) obj;
            if (abs(other.width - width) <= 0.001 && abs(other.length - length) <= 0.001
                    && topLeft.equals(other.topLeft)) {
                return true;
            }
        }
        return false;
    }


}
