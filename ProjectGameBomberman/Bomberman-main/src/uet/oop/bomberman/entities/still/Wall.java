package uet.oop.bomberman.entities.still;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

public class Wall extends StillEntity {

    public Wall(int x, int y, Image img) {
        super(x, y, img);
        setLayer(5);
    }

    @Override
    public void update() {

    }


}
