package uet.oop.bomberman.entities.movable.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.movable.enemy.ai.AIHigh;
import uet.oop.bomberman.entities.movable.enemy.ai.AIMedium;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.bomberman;

public class Doll extends Enemy {

    public Doll(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        setLayer(1);
        setSpeed(2);
        _ai = new AIMedium(bomberman,this);
        direction =_ai.caculateDirection();
        alive = true;
    }
    int n=0;
    @Override
    public void update() {
        if (isAlive()) {
            if (direction == 3) goLeft();
            if (direction == 1) goRight();
            if (direction == 0) goUp();
            if (direction == 2) goDown();
            if(n==32) {
                direction = _ai.caculateDirection();
                n = 0;
            }
        } else if (animated < 30) {
            animated++;
            img = Sprite.dollDead.getFxImage();
        } else
            BombermanGame.enemies.remove(this);
        //
    }

    public void goLeft() {
        super.goLeft();
        img = Sprite.movingSprite(Sprite.dollLeft1, Sprite.dollLeft2, Sprite.dollLeft3, left++, 18).getFxImage();
    }

    public void goRight() {
        super.goRight();
        img = Sprite.movingSprite(Sprite.dollRight1, Sprite.dollRight2, Sprite.dollRight3, right++, 18).getFxImage();
    }

    public void goUp() {
        super.goUp();
        img = Sprite.movingSprite(Sprite.dollLeft1, Sprite.dollLeft2, Sprite.dollLeft3, up++, 18).getFxImage();
    }

    public void goDown() {
        super.goDown();
        img = Sprite.movingSprite(Sprite.dollRight1, Sprite.dollRight2, Sprite.dollRight3, down++, 18).getFxImage();
    }

    @Override
    public void stay() {
        super.stay();
        direction = _ai.caculateDirection();
    }
}
