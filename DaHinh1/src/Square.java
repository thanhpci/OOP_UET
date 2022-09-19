import java.nio.file.attribute.UserPrincipalLookupService;

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
        return "Square[side=" + width + ",color=" + color + ",filled=" + filled + ']';
    }

}
