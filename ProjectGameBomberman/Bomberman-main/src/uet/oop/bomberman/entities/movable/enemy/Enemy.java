package uet.oop.bomberman.entities.movable.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.movable.Character;
import uet.oop.bomberman.entities.movable.enemy.ai.AI;

public abstract class Enemy extends Character {
    protected AI _ai;
    public int direction;
    public Enemy(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        setLayer(1);
    }
}
