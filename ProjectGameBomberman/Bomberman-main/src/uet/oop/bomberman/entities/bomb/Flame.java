package uet.oop.bomberman.entities.bomb;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.still.Brick;
import uet.oop.bomberman.entities.still.Wall;
import uet.oop.bomberman.graphics.Sprite;

import java.awt.*;

public class Flame extends Entity {
    private int left;
    private int right;
    private int top;
    private int down;
    public int radius;
    private int size = Sprite.SCALED_SIZE;
    private int direction;
    private int time = 0;

    public Flame(int x, int y, Image image, int direction){
        super(x, y);
        this.img = image;
        this.direction = direction;
    }

    public Flame(int x, int y, Image image){
        super(x, y);
        this.img = image;
        this.radius = 2;
    }

    public Flame(int x, int y){
        super(x,y);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }


    private void Right() {
        for (int i = 0; i < radius; i++) {
            Rectangle exRight = new Rectangle(x + size * (i + 1), y, size, size);
            if (collisionType(exRight) instanceof Wall) {
                right = i;
                return;
            } else if(collisionType(exRight) instanceof Brick) {
                right = i + 1;
                return;
            }
            right = i + 1;
        }
    }

    private void Left() {
        for (int i = 0; i < radius; i++) {
            Rectangle exLeft = new Rectangle(x - size*(i + 1), y, size, size);
            if (collisionType(exLeft) instanceof Wall) {
                left = i;
                return;
            } else if(collisionType(exLeft) instanceof Brick) {
                left = i + 1;
                return;
            }
            left = i + 1;
        }
    }

    private void Top() {
        for (int i = 0; i < radius; i++) {
            Rectangle exTop = new Rectangle(x, y - size*(i + 1), size, size);
            if (collisionType(exTop) instanceof Wall) {
                top = i;
                return;
            } else if(collisionType(exTop) instanceof Brick) {
                top = i + 1;
                return;
            }
            top = i + 1;
        }
    }

    private void Down() {
        for (int i = 0; i < radius; i++) {
            Rectangle exDown = new Rectangle(x, y + size*(i + 1), size, size);
            if (collisionType(exDown) instanceof Wall) {
                down = i;
                return;
            } else if(collisionType(exDown) instanceof Brick) {
                down = i + 1;
                return;
            }
            down = i + 1;
        }
    }



    @Override
    public void update(){
        if(time < 20){
            time++;
            //System.out.println(direction);
            setImg();
            //System.out.println(time);
        } else
            BombermanGame.flameList.remove(this);
    }

    public void render_explosion(){
        Right();
        Left();
        Top();
        Down();
        create_explosion();
    }

    //bom no
    private void create_explosion(){
        BombermanGame.flameList.add(new Flame(x, y, Sprite.explosionCentral.getFxImage(),0));
        for(int i = 0; i < right; i++){                         //right = 1
            Flame e = new Flame(x + size * (i + 1), y);
            if(i == right - 1) {
                e.img = Sprite.explosionHorizontalRightLast.getFxImage();
                e.direction = 2;
            } else{
                e.img = Sprite.explosionHorizontal.getFxImage();
                e.direction = 1;
            }
            BombermanGame.flameList.add(e);
        }

        for(int i = 0; i < left; i++){
            Flame e = new Flame(x - size*(i + 1), y);
            if(i == left - 1) {
                e.img = Sprite.explosionHorizontalLeftLast.getFxImage();
                e.direction = 3;
            } else{
                e.img = Sprite.explosionHorizontal.getFxImage();
                e.direction = 1;
            }
            BombermanGame.flameList.add(e);
        }

        for(int i = 0; i < top; i++){
            Flame e = new Flame(x , y - size*(i + 1));
            if(i == top - 1) {
                e.img = Sprite.explosionVerticalTopLast.getFxImage();
                e.direction = 5;
            } else{
                e.img = Sprite.explosionVertical.getFxImage();
                e.direction = 4;
            }
            BombermanGame.flameList.add(e);
        }

        for(int i = 0; i < down; i++){
            Flame e = new Flame(x, y + size*(i + 1));
            if(i == right - 1) {
                e.img = Sprite.explosionVerticalDownLast.getFxImage();
                e.direction = 6;
            } else{
                e.img = Sprite.explosionVertical.getFxImage();
                e.direction = 4;
            }
            BombermanGame.flameList.add(e);
        }
    }

    private static Object collisionType(Rectangle r){
        for(Entity e : BombermanGame.stillObjects){
            Rectangle r2 = e.getBounds();
            if(r.intersects(r2)){
                return e;
            }
        }
        return r;
    }

    private void setImg() {
        switch (direction) {
            case 0:
                img = Sprite.movingSprite(Sprite.explosionCentral, Sprite.explosionCentral1,
                        Sprite.explosionCentral2, time, 20).getFxImage();
                break;
            case 1:
                img = Sprite.movingSprite(Sprite.explosionHorizontal, Sprite.explosionHorizontal1
                        ,Sprite.explosionHorizontal2,time,20).getFxImage();
                break;
            case 2:
                img = Sprite.movingSprite(Sprite.explosionHorizontalRightLast, Sprite.explosionHorizontalRightLast1
                        ,Sprite.explosionHorizontalRightLast2, time,20).getFxImage();
                break;
            case 3:
                img = Sprite.movingSprite(Sprite.explosionHorizontalLeftLast, Sprite.explosionHorizontalLeftLast1
                        ,Sprite.explosionHorizontalLeftLast2, time,20).getFxImage();
                break;
            case 4:
                img = Sprite.movingSprite(Sprite.explosionVertical, Sprite.explosionVertical1
                        ,Sprite.explosionVertical2, time,20).getFxImage();
                break;
            case 5:
                img = Sprite.movingSprite(Sprite.explosionVerticalTopLast, Sprite.explosionVerticalTopLast1
                        ,Sprite.explosionVerticalTopLast2, time,20).getFxImage();
                break;
            case 6:
                img = Sprite.movingSprite(Sprite.explosionVerticalDownLast, Sprite.explosionVerticalDownLast1
                        ,Sprite.explosionVerticalDownLast2, time,20).getFxImage();
                break;
        }
    }

}
