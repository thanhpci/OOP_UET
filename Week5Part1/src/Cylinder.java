public class Cylinder extends Circle{
    private double height = 1.0;

    public Cylinder() {

    }

    public Cylinder(double radius) {
        setRadius(radius);
    }

    public Cylinder(double radius, double height) {
        setRadius(radius);
        this.height = height;
    }

    public Cylinder(double radius, double height, String color) {
        setRadius(radius);
        setColor(color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Method.
     */

    public double getArea() {
        double area = super.getArea()*2.0;
        area += 2.0 * PI * getRadius() * height;
        return area;
    }

    /**
     * Method.
     */

    public double getVolume() {
        return getArea()*height;
    }

    /**
     * Method.
     */

    public String toString() {
        return "Cylinder[" + super.toString() + ",height=" + height + ']';
    }
}
