package uet.oop.bomberman.entities.movable.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.movable.enemy.ai.AILow;
import uet.oop.bomberman.graphics.Sprite;

public class Balloom extends Enemy {
    //private int direction;

    public Balloom(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        setLayer(1);
        setSpeed(1);
        _ai = new AILow();
        direction = _ai.caculateDirection();
        alive = true;
    }

    @Override
    public void update() {
        if(isAlive()) {
            if (direction == 0) goLeft();
            if (direction == 1) goRight();
            if (direction == 2) goUp();
            if (direction == 3) goDown();

        }else if(animated < 30){
            animated ++;
            img = Sprite.balloomDead.getFxImage();
        }else
            BombermanGame.enemies.remove(this);
    }

    public void goLeft() {
        super.goLeft();
        img = Sprite.movingSprite(Sprite.balloomLeft1, Sprite.balloomLeft2, Sprite.balloomLeft3, left++, 18).getFxImage();
    }

    public void goRight() {
        super.goRight();
        img = Sprite.movingSprite(Sprite.balloomRight1, Sprite.balloomRight2, Sprite.balloomRight3, right++, 18).getFxImage();
    }

    public void goUp() {
        super.goUp();
        img = Sprite.movingSprite(Sprite.balloomLeft1, Sprite.balloomLeft2, Sprite.balloomLeft3, up++, 18).getFxImage();
    }

    public void goDown() {
        super.goDown();
        img = Sprite.movingSprite(Sprite.balloomRight1, Sprite.balloomRight2, Sprite.balloomRight3, down++, 18).getFxImage();
    }

    @Override
    public void stay() {
        super.stay();
        direction = _ai.caculateDirection();
    }
}
