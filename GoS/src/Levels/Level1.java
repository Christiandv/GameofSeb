package Levels;

import Characters.*;
import Engines.GameState;

import javax.swing.*;
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
        seb = new Seb(2, 22);
        objects[2][2] = new Bus(7,4);
        objects[5][29] = new StressBar();
        //objects[2][3] = new InvisibleWall(2,3);
        background = new ImageIcon(this.getClass().getResource("backgrounds/street.png")).getImage();

    }

    @Override
    public GameState takeTurn() {
        seb.addStress(1);
        Thing[][] after = new Thing[30][30];
        if(seb.x >= 29 && 3 <= seb.y && seb.y >= 4 ){
            nextLevel = true;
        }
       // Thing b = objects[2][2];
        for(int i = 0; i < after.length; i++) {
            for (int j = 0; j < after[0].length; j++) {
                if (objects[i][j] != null) {
                    if (objects[i][j] instanceof Bus) {
                        Bus bus = (Bus) objects[i][j];
                        //System.out.println("kllk   " + i);
                        if(i+1 <=29){
                            after[i+1][j] = bus;
                        }else{
                            bus.isVisable = false;
                        }
                    }
                }
            }
        }
        objects = after;
        return getGameState();
    }
}
