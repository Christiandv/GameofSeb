package Levels;

import Characters.InvisibleWall;
import Characters.Seb;
import Characters.Teacher;
import Characters.Thing;
import Engines.GameState;

import java.awt.event.KeyEvent;

public class Level2 extends Level {
    public int turnNum = 0;

    @Override
    public boolean receiveInput(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (seb.y > 0) {
                Thing t = objects[seb.x][seb.y - 1];
                if (t == null) {
                    seb.y--;
                    turnNum++;
                    return true;
                }
                if (t != null)
                    if (!t.isSolid) {
                        seb.y--;
                        turnNum++;
                        return true;
                    }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (seb.y < objects[0].length - 1) {
                Thing t = objects[seb.x][seb.y + 1];
                if (t == null) {
                    seb.y++;
                    turnNum++;
                    return true;
                }
                if (t != null)
                    if (!t.isSolid) {
                        seb.y++;
                        turnNum++;
                        return true;
                    }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (seb.x > 0) {
                Thing t = objects[seb.x - 1][seb.y];
                if (t == null) {
                    seb.x--;
                    turnNum++;
                    return true;
                }
                if (t != null)
                    if (!t.isSolid) {
                        seb.x--;
                        turnNum++;
                        return true;
                    }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (seb.x < objects.length - 1) {
                Thing t = objects[seb.x + 1][seb.y];
                if (t == null) {
                    seb.x++;
                    turnNum++;
                    return true;
                }
                if (t != null)
                    if (!t.isSolid) {
                        seb.x++;
                        turnNum++;
                        return true;
                    }
            }
        }
        return false;
    }

    public Level2(){
        objects = new Characters.Thing[30][30];
        seb = new Seb(4,2);
        objects[1][1] = new Teacher(6,10);
        objects[1][2] = new Teacher(20,15);
        objects[1][3] = new Teacher(15,4);
        objects[2][1] = new Teacher(16,20);
    }

    @Override
    public GameState takeTurn() {
       /* Thing T1= objects[1][1];
        Thing T2 = objects[1][2];
        Thing T3 = objects[1][3];
        Thing T4 = objects[2][1];
        if(turnNum%2 == 0){
            T1.x++;
            T2.y++;
            T3.x++;
            T4.y++;

        }else{
            T1.x--;
            T2.y--;
            T3.x--;
            T4.y--;
        }
        //if(seb.x == 15 && seb.y == 30){
          //  nextLevel = true;
        //}
        */
        return getGameState();
    }

}