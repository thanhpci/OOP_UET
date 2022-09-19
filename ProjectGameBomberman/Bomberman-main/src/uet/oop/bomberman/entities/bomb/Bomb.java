package uet.oop.bomberman.entities.bomb;

import javafx.scene.image.Image;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;


import static uet.oop.bomberman.sound.Sound.no_bom;

public class Bomb extends Entity {
    private int timeCounter = 0;
    int radius;

    public Bomb(int xUnit, int yUnit, Image img, int radius) {
        super(xUnit, yUnit, img);
        setLayer(2);
        this.radius = radius;
        this.alive = true;
    }

    @Override
    public void update() {
        if (timeCounter++ == 120) {
            explodeUpgrade();
        }
        img = Sprite.movingSprite(Sprite.bomb, Sprite.bomb1, Sprite.bomb2, timeCounter, 60).getFxImage();
    }

    public void explodeUpgrade() {
        Flame e = new Flame(x, y);
        e.setRadius(radius);
        e.render_explosion();
        alive = false;
        no_bom.play();
        no_bom.seek(no_bom.getStartTime());
    }
}