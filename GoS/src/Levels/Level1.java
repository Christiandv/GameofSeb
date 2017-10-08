package Levels;

import Characters.Seb;
import Characters.Thing;
import Engines.GameState;

import java.awt.event.KeyEvent;


public class Level1 extends Level {
    @Override
    public boolean receiveInput(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if(seb.y>0) {
                Thing t = objects[seb.x][seb.y - 1];
                if (t == null) {
                    seb.y--;
                }
                if (t != null)
                    if (!t.isSolid) {
                        seb.y--;
                    }
            }
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(seb.y<objects[0].length-1) {
                Thing t = objects[seb.x][seb.y + 1];
                if (t == null) {
                    seb.y++;
                }
                if (t != null)
                    if (!t.isSolid) {
                        seb.y++;
                    }
            }
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(seb.x>0) {
                Thing t = objects[seb.x - 1][seb.y];
                if (t == null) {
                    seb.x--;
                }
                if (t != null)
                    if (!t.isSolid) {
                        seb.x--;
                    }
            }
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(seb.x<objects.length-1) {
                Thing t = objects[seb.x + 1][seb.y];
                if (t == null) {
                    seb.x++;
                }
                if (t != null)
                    if (!t.isSolid) {
                        seb.x++;
                    }
            }
        }


            return true;
    }

    public Level1() {
        objects = new Characters.Thing[30][30];
        seb = new Seb(6, 6);
        objects[2][2] = new Thing(2, 2);
        objects[2][2].isSolid = true;
        objects[2][2].loadImage("src/Characters/resources/seb.gif");

    }

    @Override
    public GameState takeTurn() {
        return getGameState();
    }
}
