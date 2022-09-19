import java.text.DecimalFormat;
import java.util.Objects;

public class Point {
    private double pointX;
    private double pointY;

    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public double distance(Point other) {
        return Math.sqrt((pointX - other.pointX) * (pointX - other.pointX)
                + (pointY - other.pointY) * (pointY - other.pointY));
    }

//    public boolean equals(Object object) {
////        if (object instanceof Point) {
////            Point other = (Point) object;
////            if (other.pointX == this.pointX && other.pointY == this.pointY) {
////                return true;
////            }
////        }
////        return false;
////    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.pointX, pointX) == 0 && Double.compare(point.pointY, pointY) == 0;
    }

    public int hashCode() {
        return Objects.hash(pointX, pointY);
    }

    public String toString() {
        return "(" + pointX + ',' + pointY + ')';
    }
}

