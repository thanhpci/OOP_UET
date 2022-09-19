import java.util.ArrayList;
import java.util.List;

public class Layer {
    private List<Shape> listShape = new ArrayList<>();

    public void addShape(Shape newShape) {
        listShape.add(newShape);
    }

    public void removeCircles() {
        for (int i = 0; i < listShape.size(); i++) {
            if (listShape.get(i) instanceof Circle) {
                listShape.remove(i);
            }
        }
    }

    public String getInfo() {
        String result = "Layer of crazy shapes: \n";
        for (int i = 0; i < listShape.size(); i++) {
            if (listShape.get(i) instanceof )
        }

    }
}
