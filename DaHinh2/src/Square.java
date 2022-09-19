import static java.lang.Math.abs;

public class Square extends Rectangle {

    public Square() {}

    public Square(double side) {
        this.width = side;
        this.length = side;
    }

    /**
     Method.
     */

    public Square(double side, String color, boolean filled) {
        this.width = side;
        this.length = side;
        this.color = color;
        this.filled = filled;
    }

    public Square(Point topLeft, double side, String color, boolean filled) {
        this.topLeft = topLeft;
        this.width = side;
        this.length = side;
        this.color = color;
        this.filled = filled;
    }

    public double getSide() {
        return width;
    }

    public void setSide(double side) {
        this.width = side;
        this.length = side;
    }

    public void setWidth(double width) {
        this.width = width;
        this.length = width;
    }

    public void setLength(double length) {
        this.width = length;
        this.length = length;
    }

    public String toString() {
        return "Square[topLeft=" + topLeft.toString() + ",side=" + width + ",color=" + color + ",filled=" + filled + ']';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Square) {
            Square other = (Square) obj;
            if (abs(other.width - this.width) <= 0.001) {
                return true;
            }
        }
        return false;
    }

}
