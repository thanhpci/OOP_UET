package uet.oop.bomberman.entities.movable;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.still.Brick;
import uet.oop.bomberman.entities.still.item.BombItem;
import uet.oop.bomberman.entities.still.item.FlameItem;
import uet.oop.bomberman.entities.still.item.Item;
import uet.oop.bomberman.entities.still.item.SpeedItem;
import uet.oop.bomberman.entities.movable.enemy.*;
import uet.oop.bomberman.entities.still.Portal;
import uet.oop.bomberman.graphics.Sprite;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.sound.Sound.*;

public class Bomber extends Character {
    private int bombRemain;
    private int radius;
    private boolean placeBombCommand = false;
    private final List<Bomb> bombs = new ArrayList<>();
    private KeyCode direction = null;
    private int timeAfterDie = 0;

    public Bomber(int x, int y, Image img) {
        super( x, y, img);
        setLayer(1);
        //setSpeed(startSpeed);// speed of bomberman
        //setBombRemain(1);// number of bomb
        //setPower(1);
        //setRadius(4);// power of bomb
        setBombRemain(startBomb);
        setSpeed(startSpeed);
        setRadius(startFlame);
    }

    public int getBombRemain() {
        return bombRemain;
    }

    public void setBombRemain(int bombRemain) {
        this.bombRemain = bombRemain;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public Rectangle getBounds() {
        return new Rectangle(desX + 2, desY +5, Sprite.SCALED_SIZE - 10, Sprite.SCALED_SIZE * 3/4);
    }

    public boolean isAlive() {
        return alive;
    }

    public void goLeft() {
        super.goLeft();
        img = Sprite.movingSprite(Sprite.bomberLeft, Sprite.bomberLeft1, Sprite.bomberLeft2, left++, 20).getFxImage();
    }

    public void goRight() {
        super.goRight();
        img = Sprite.movingSprite(Sprite.bomberRight, Sprite.bomberRight1, Sprite.bomberRight2, right++, 20).getFxImage();
        //System.out.println("x = " + x + ", desX = " + desX + ",right = " + right);

    }

    public void goUp() {
        super.goUp();
        img = Sprite.movingSprite(Sprite.bomberUp, Sprite.bomberUp1, Sprite.bomberUp2, up++, 20).getFxImage();
    }

    public void goDown() {
        super.goDown();
        img = Sprite.movingSprite(Sprite.bomberDown, Sprite.bomberDown1, Sprite.bomberDown2, down++, 20).getFxImage();
    }

    public void placeBomb() {
        if (bombRemain > 0) {
            int xB = (int) Math.round(x / (double) Sprite.SCALED_SIZE);
            int yB = (int) Math.round(y / (double) Sprite.SCALED_SIZE);
            for (Bomb bomb : bombs) {
                if (xB * Sprite.SCALED_SIZE == bomb.getX() && yB * Sprite.SCALED_SIZE == bomb.getY()) return;
            }
            bombs.add(new Bomb(xB, yB, Sprite.bomb.getFxImage(), radius));
            bombRemain--;
            dat_bom.play();
            dat_bom.seek(dat_bom.getStartTime());
            System.out.println("xB = " + xB + ",yB = " + yB + ",x = " + x + ",y = " + y);
        }
    }

    public void die() {
        if (timeAfterDie == 20) cout --;
        if(timeAfterDie <= 45) {
            img = Sprite.movingSprite(Sprite.bomberDead1, Sprite.bomberDead2,
                    Sprite.bomberDead3, timeAfterDie, 20).getFxImage();
        }
    }

    @Override
    public void update() {
        if (direction == KeyCode.LEFT) {
            goLeft();
        }
        if (direction == KeyCode.RIGHT) {
            goRight();
        }
        if (direction == KeyCode.UP) {
            goUp();
        }
        if (direction == KeyCode.DOWN) {
            goDown();
        }
        if (placeBombCommand) {
            placeBomb();
        }
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (!bomb.isAlive()) {
                bombs.remove(bomb);
                bombRemain++;
            }
        }
        //animate();
        if(!isAlive()) {
            timeAfterDie ++;
            die();
        }
    }

    public void handleKeyPressedEvent(KeyCode keyCode) {
        if (keyCode == KeyCode.LEFT || keyCode == KeyCode.RIGHT
                || keyCode == KeyCode.UP || keyCode == KeyCode.DOWN) {
            this.direction = keyCode;
        }
        if (keyCode == KeyCode.SPACE) {
            placeBombCommand = true;
        }
    }

    public void handleKeyReleasedEvent(KeyCode keyCode) {
        if (direction == keyCode) {
            if (direction == KeyCode.LEFT) {
                img = Sprite.bomberLeft.getFxImage();
            }
            if (direction == KeyCode.RIGHT) {
                img = Sprite.bomberRight.getFxImage();
            }
            if (direction == KeyCode.UP) {
                img = Sprite.bomberUp.getFxImage();
            }
            if (direction == KeyCode.DOWN) {
                img = Sprite.bomberDown.getFxImage();
            }
            direction = null;
        }
        if (keyCode == KeyCode.SPACE) {
            placeBombCommand = false;
        }
    }

    public void handleCollisions(){
        List<Bomb> bombs = bomberman.getBombs();
        Rectangle r1 = bomberman.getBounds();
        //Bomber vs stillObject
        for (Entity stillObject : stillObjects) {
            Rectangle r2 = stillObject.getBounds();
            if (r1.intersects(r2)) {
                if (bomberman.getLayer() == stillObject.getLayer() && stillObject instanceof Item) {
                    if(stillObject instanceof BombItem) {
                        eatItem.play();
                        eatItem.seek(eatItem.getStartTime());
                        bomberman.setBombRemain(bomberman.getBombRemain() + 1);
                        stillObjects.remove(stillObject);
                    } else if(stillObject instanceof SpeedItem) {
                        eatItem.play();
                        eatItem.seek(eatItem.getStartTime());
                        bomberman.setSpeed(bomberman.getSpeed() + 1);
                        stillObjects.remove(stillObject);
                    } else if(stillObject instanceof FlameItem) {
                        eatItem.play();
                        eatItem.seek(eatItem.getStartTime());
                        bomberman.setRadius(bomberman.getRadius() + 1);
                        stillObjects.remove(stillObject);
                    }
                    bomberman.stay();
                } else if(bomberman.getLayer() == stillObject.getLayer() && stillObject instanceof Portal) {
                    if(enemies.size() == 0) {
                        level++;
                        levelUp.play();
                        levelUp.seek(levelUp.getStartTime());
                        check = true;
                    }
                } else if(bomberman.getLayer() >= stillObject.getLayer()) {
                    bomberman.move();
                }
                else {
                    bomberman.stay();
                }
                break;
            }
        }
        //Bomber vs Enemies
        for (Enemy enemy : enemies) {
            Rectangle r2 = enemy.getBounds();
            if (r1.intersects(r2)) {
                bomberman.setAlive(false);
                BomberDie.play();
                BomberDie.seek(BomberDie.getStartTime());
                bomberman.setSpeed(startSpeed);
                bomberman.setBombRemain(startBomb);
                bomberman.setRadius(startFlame);

                if(bomberman.isAlive() == false){
                    if(cout >= 0) {
                        Timer count = new Timer();
                        count.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                bomberman = new Bomber(1, 1, Sprite.bomberRight.getFxImage());
                                count.cancel();
                            }
                        }, 500, 1);
                    }
                }
            }
        }
        //Enemies vs Bombs
        for (Enemy enemy : enemies) {
            Rectangle r2 = enemy.getBounds();
            for (Bomb bomb : bombs) {
                Rectangle r3 = bomb.getBounds();
                if (r2.intersects(r3)) {
                    enemy.stay();
                    break;
                }
            }
        }
        //Enemies vs StillObjects
        for (Enemy enemy : enemies) {
            Rectangle r2 = enemy.getBounds();
            for (Entity stillObject : stillObjects) {
                Rectangle r3 = stillObject.getBounds();
                if (r2.intersects(r3)) {
                    if (enemy.getLayer() >= stillObject.getLayer()) {
                        enemy.move();
                    } else {
                        enemy.stay();
                    }
                    break;
                }
            }
        }
    }
    public void checkCollisionFlame() {
        //if(explosionList != null){
        for (int i = 0; i < flameList.size(); i++) {
            Rectangle r1 = flameList.get(i).getBounds();
            for (int j = 0; j < stillObjects.size(); j++) {
                Rectangle r2 = stillObjects.get(j).getBounds();
                if (r1.intersects(r2) && (stillObjects.get(j) instanceof Brick))
                    stillObjects.get(j).setAlive(false);
            }
            for (int j = 0; j < enemies.size(); j++) {
                Rectangle r2 = enemies.get(j).getBounds();
                if (r1.intersects(r2)){
                    if(enemies.get(j) instanceof Kondoria ||enemies.get(j) instanceof Doll) score+=5;
                    else if(enemies.get(j) instanceof Oneal) score+=2;
                    else score+=1;
                    enemyDie.play();
                    enemyDie.seek(levelUp.getStartTime());
                    enemies.get(j).setAlive(false);
                }
            }
            Rectangle r2 = bomberman.getBounds();
            if (r1.intersects(r2)) {
                bomberman.setAlive(false);
                BomberDie.play();
                BomberDie.seek(BomberDie.getStartTime());
                bomberman.setSpeed(startSpeed);
                bomberman.setBombRemain(startBomb);
                bomberman.setRadius(startFlame);
                if (bomberman.isAlive() == false) {
                    if (cout >= 0) {
                        Timer count = new Timer();
                        count.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                bomberman = new Bomber(1, 1, Sprite.bomberRight.getFxImage());
                                count.cancel();
                            }
                        }, 800, 1);
                    }
                }
            }
        }
    }
}
