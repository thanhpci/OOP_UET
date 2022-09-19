package uet.oop.bomberman.entities.still.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.still.StillEntity;

public abstract class Item extends StillEntity {
    public Item(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        setLayer(1);
    }
}
