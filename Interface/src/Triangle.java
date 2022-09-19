public class Triangle implements GeometricObject {
    private Point p1;
    private Point p2;
    private Point p3;

    /**
     * Method.
     */

    public Triangle(Point p1, Point p2, Point p3) throws RuntimeException {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;

        if (checkCoincide(p1, p2) || checkInLine(p1, p2, p3)) {
            throw new RuntimeException();
        }
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    public double getPerimeter() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    /**
     * Method.
     */

    public double getArea() {
        return Math.abs(p1.getPointX() * (p2.getPointY() - p3.getPointY())
                + p2.getPointX() * (p3.getPointY() - p1.getPointY())
                + p3.getPointX() * (p1.getPointY() - p2.getPointY())) / 2;
    }

    /**
     * Method.
     */

    public String getInfo() {
        return "Triangle[(" + String.format("%.2f", p1.getPointX()) + ','
                + String.format("%.2f", p1.getPointY()) + "),("
                + String.format("%.2f", p2.getPointX()) + ','
                + String.format("%.2f", p2.getPointY()) + "),("
                + String.format("%.2f", p3.getPointX()) + ','
                + String.format("%.2f", p3.getPointY()) + ")]";
    }

    /**
     * Method.
     */

    public boolean checkCoincide(Point p1, Point p2) {
        if (p1.getPointX() == p2.getPointX() && p1.getPointY() == p2.getPointY()) {
            return true;
        }
        return false;
    }

    /**
     * Method.
     */

    public boolean checkInLine(Point p1, Point p2, Point p3) {
        if ((p1.getPointY() - p2.getPointY()) / (p1.getPointX() - p2.getPointX())
                == (p1.getPointY() - p3.getPointY()) / (p1.getPointX() - p3.getPointX())) {
            return true;
        }
        return false;
    }
}
