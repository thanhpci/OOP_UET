package uet.oop.bomberman.entities.movable.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
//import uet.oop.bomberman.entities.movable.enemy.ai.AIMedium;
//import uet.oop.bomberman.entities.movable.enemy.ai.AIMedium;
import uet.oop.bomberman.entities.movable.enemy.ai.AIHigh;
import uet.oop.bomberman.entities.movable.enemy.ai.AIMedium;
import uet.oop.bomberman.graphics.Sprite;

import java.awt.*;

import static uet.oop.bomberman.BombermanGame.*;

public class Oneal extends Enemy {
    public Oneal(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        setLayer(1);
        setSpeed(2);
        _ai = new AIHigh(bomberman,this);
        direction = _ai.caculateDirection();

        alive = true;
    }

    Rectangle e = this.getBounds();
    int n = 0;

    @Override
    public void update() {
        n++;
        if (isAlive()) {
            if (direction == 3) goLeft();
            if (direction == 1) goRight();
            if (direction == 0) goUp();
            if (direction == 2) goDown();
            if ( n == 32) {
                direction = _ai.caculateDirection();
                n = 0;
            }
            if (!bomberman.isAlive()) bomberman.update();

        } else if (animated < 30) {
            animated++;
            img = Sprite.onealDead.getFxImage();
        } else
            BombermanGame.enemies.remove(this);
        //
    }

    public boolean check() {
        Rectangle ee = this.getBoundArea(3);
        if (e.contains(ee) == false) {
            return true;
        }
        return false;
    }

    public void goLeft() {
        e = this.getBounds();
        super.goLeft();
        img = Sprite.movingSprite(Sprite.onealLeft1, Sprite.onealLeft2, Sprite.onealLeft3, left++, 18).getFxImage();
    }

    public void goRight() {
        e = this.getBounds();
        super.goRight();
        img = Sprite.movingSprite(Sprite.onealRight1, Sprite.onealRight2, Sprite.onealRight3, right++, 18).getFxImage();
    }

    public void goUp() {
        e = this.getBounds();
        super.goUp();
        img = Sprite.movingSprite(Sprite.onealLeft1, Sprite.onealLeft2, Sprite.onealLeft3, up++, 18).getFxImage();
    }

    public void goDown() {
        e = this.getBounds();
        super.goDown();
        img = Sprite.movingSprite(Sprite.onealRight1, Sprite.onealRight2, Sprite.onealRight3, down++, 18).getFxImage();
    }

    @Override
    public void stay() {
        super.stay();
        direction = _ai.caculateDirection();
    }


}