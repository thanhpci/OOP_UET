import java.util.List;

public class ShapeUtil {

    /**
     * Method.
     */

    public String printInfo(List<GeometricObject> shapes) {
        String result = "";

        result += "Circle:\n";
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) instanceof Circle) {
                result = result + shapes.get(i).getInfo() + "\n";
            }
        }

        result += "Triangle:\n";
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) instanceof Triangle) {
                result = result + shapes.get(i).getInfo() + "\n";
            }
        }
        return result;
    }
}
