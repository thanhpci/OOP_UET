package uet.oop.bomberman.entities.movable;

import javafx.scene.image.Image;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import java.awt.*;


public abstract class Character extends Entity {
    protected final int MAX_ANIMATE = 7500;
    protected int desX = x;
    protected int desY = y;
    protected int speed;
    protected int left = 0;
    protected int right = 0;
    protected int up = 0;
    protected int down = 0;

    public Character(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        alive = true;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // them
    public int getSpeed() {
        return speed;
    }

    public void goLeft() {
        desX = x - speed;
    }

    public void goRight() {
        desX = x + speed;
    }

    public void goUp() {
        desY = y - speed;
    }

    public void goDown() {
        desY = y + speed;
    }

    public void move() {
        x = desX;
        y = desY;
    }

    public void stay() {
        desX = x;
        desY = y;
    }

    public Rectangle getBounds() {
        return new Rectangle(desX, desY, Sprite.SCALED_SIZE, Sprite.SCALED_SIZE);
    }
    public Rectangle getBoundArea(int n){
        return new Rectangle(desX-Sprite.SCALED_SIZE*n, desY-Sprite.SCALED_SIZE*n, Sprite.SCALED_SIZE*(1+2*n), Sprite.SCALED_SIZE*(1+2*n));
    }
}
