public class Point {
    private double pointX;
    private double pointY;

    public Point(double x, double y) {
        pointX = x;
        pointY = y;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double x) {
        pointX = x;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double y) {
        pointY = y;
    }

    /**
     * Method.
     */

    public double distance(Point other) {
        double distance = Math.sqrt((pointX - other.pointX) * (pointX - other.pointX)
                + (pointY - other.pointY) * (pointY - other.pointY));

        return distance;
    }

}
