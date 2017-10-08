package Levels;

import Characters.InvisibleWall;
import Characters.Seb;
import Characters.Teacher;
import Characters.Thing;
import Engines.GameState;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Level3 extends Level {
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

    public Level3(){
        objects = new Characters.Thing[30][30];
        seb = new Seb(4, 2);
        stressBar = true;

        //outside wall
        objects[16][1] = new InvisibleWall();
        objects[16][2] = new InvisibleWall();
        objects[16][3] = new InvisibleWall();
        objects[16][4] = new InvisibleWall();
        objects[16][5] = new InvisibleWall();
        objects[16][6] = new InvisibleWall();
        objects[16][7] = new InvisibleWall();
        objects[16][8] = new InvisibleWall();
        objects[16][9] = new InvisibleWall();
        objects[16][10] = new InvisibleWall();
        objects[16][11] = new InvisibleWall();
        objects[16][12] = new InvisibleWall();
        objects[16][13] = new InvisibleWall();
        objects[16][14] = new InvisibleWall();
        objects[16][15] = new InvisibleWall();
        objects[16][16] = new InvisibleWall();
        objects[16][17] = new InvisibleWall();
        objects[16][18] = new InvisibleWall();
        //door
        objects[16][21] = new InvisibleWall();
        objects[16][22] = new InvisibleWall();
        objects[16][23] = new InvisibleWall();
        objects[16][24] = new InvisibleWall();
        objects[16][25] = new InvisibleWall();
        objects[16][26] = new InvisibleWall();
        objects[16][27] = new InvisibleWall();
        objects[16][28] = new InvisibleWall();
        objects[16][29] = new InvisibleWall();


        //stairs bottomhalf
        objects[17][22] = new InvisibleWall();
        objects[18][22] = new InvisibleWall();
        objects[19][21] = new InvisibleWall();
        objects[20][20] = new InvisibleWall();
        objects[21][19] = new InvisibleWall();

        //stairs upperhalf
        objects[17][19] = new InvisibleWall();
        objects[18][19] = new InvisibleWall();
        objects[19][18] = new InvisibleWall();
        objects[20][17] = new InvisibleWall();
        objects[21][16] = new InvisibleWall();

        //railing
        objects[21][16] = new InvisibleWall();
        objects[21][15] = new InvisibleWall();
        objects[21][14] = new InvisibleWall();
        objects[21][13] = new InvisibleWall();

        //apartment front wall
        objects[22][12] = new InvisibleWall();
        objects[23][12] = new InvisibleWall();
        //door
        objects[25][12] = new InvisibleWall();
        objects[26][12] = new InvisibleWall();
        objects[27][12] = new InvisibleWall();
        objects[28][12] = new InvisibleWall();
        objects[29][12] = new InvisibleWall();




        background = new ImageIcon(this.getClass().getResource("backgrounds/sebhouse.png")).getImage();
    }

    @Override
    public GameState takeTurn(){
        return getGameState();
    }
}
