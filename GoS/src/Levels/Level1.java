package Levels;

import Characters.InvisibleWall;
import Characters.Seb;
import Characters.Thing;
import Engines.GameState;

import java.awt.event.KeyEvent;


public class Level1 extends Level {
    @Override
    public boolean receiveInput(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (seb.y > 0) {
                Thing t = objects[seb.x][seb.y - 1];
                if (t == null) {
                    seb.y--;
                    return true;
                }
                if (t != null)
                    if (!t.isSolid) {
                        seb.y--;
                        return true;
                    }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (seb.y < objects[0].length - 1) {
                Thing t = objects[seb.x][seb.y + 1];
                if (t == null) {
                    seb.y++;
                    return true;
                }
                if (t != null)
                    if (!t.isSolid) {
                        seb.y++;
                        return true;
                    }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (seb.x > 0) {
                Thing t = objects[seb.x - 1][seb.y];
                if (t == null) {
                    seb.x--;
                    return true;
                }
                if (t != null)
                    if (!t.isSolid) {
                        seb.x--;
                        return true;
                    }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (seb.x < objects.length - 1) {
                Thing t = objects[seb.x + 1][seb.y];
                if (t == null) {
                    seb.x++;
                    return true;
                }
                if (t != null)
                    if (!t.isSolid) {
                        seb.x++;
                        return true;
                    }
            }
        }
        return false;
    }

    public Level1() {
        objects = new Characters.Thing[30][30];
        seb = new Seb(6, 6);
        objects[2][2] = new Thing(1,2);
        objects[2][2].isSolid = true;
        objects[2][2].loadImage("resources/rts bus.png");
        //objects[2][3] = new InvisibleWall(2,3);

    }

    @Override
    public GameState takeTurn() {
        Thing b = objects[2][2];
       // b.y++;
        return getGameState();
    }
}
