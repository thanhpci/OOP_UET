package uet.oop.bomberman.entities.movable.enemy.ai;

import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.movable.Bomber;
import uet.oop.bomberman.entities.movable.enemy.Enemy;

import java.util.List;

import static uet.oop.bomberman.BombermanGame.bomberman;

public class AIHigh extends AI{
    Bomber _bomber;
    Enemy _e;
    List<Bomb> _bombs;

    public AIHigh(Bomber bomber, Enemy e) {
        _bomber = bomber;
        _e = e;
        _bombs = bomberman.getBombs();
    }

    @Override
    public int caculateDirection() {

        // TODO: avoid Bomb

        for(int i = 0; i <_bombs.size(); i++) {
            if(_bombs.get(i).getX() > _e.getX()) return 3;
            else if(_bombs.get(i).getX() < _e.getX()) return 1;
            else if(_bombs.get(i).getY() < _e.getY()) return 2;
            else
                return 0;
        }

        // TODO: chase Bomber
        int vertical = random.nextInt(2);

        if(vertical == 1) {
            if(calculateColDirection() != -1)
                return calculateColDirection();
            else
                return calculateRowDirection();

        } else {
            if(calculateRowDirection() != -1)
                return calculateRowDirection();
            else
                return calculateColDirection();
        }
    }

    protected int calculateColDirection() {
        if(_bomber.getX() < _e.getX())
            return 3;
        else if(_bomber.getX() > _e.getX())
            return 1;

        return -1;
    }

    protected int calculateRowDirection() {
        if (_bomber.getY() < _e.getY())
            return 0;
        else if (_bomber.getY() > _e.getY())
        return 2;
        return -1;
    }

}
