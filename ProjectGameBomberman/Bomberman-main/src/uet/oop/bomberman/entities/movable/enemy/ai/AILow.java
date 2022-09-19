package uet.oop.bomberman.entities.movable.enemy.ai;

import java.util.Random;

public class AILow extends AI{

    @Override
    public int caculateDirection() {
        return random.nextInt(4);
    }
}
