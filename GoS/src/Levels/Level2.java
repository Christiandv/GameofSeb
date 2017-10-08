package Levels;

import Characters.InvisibleWall;
import Characters.Seb;
import Characters.Teacher;
import Characters.Thing;
import Engines.GameState;

import javax.swing.*;
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

    public Level2() {

        objects = new Characters.Thing[30][30];
        seb = new Seb(4, 2);
        stressBar = true;
        objects[6][10] = new Teacher();
        objects[20][15] = new Teacher();
        objects[15][4] = new Teacher();
        objects[16][20] = new Teacher();
        objects[2][22] = new Teacher();
        objects[10][10] = new Teacher();

        //block the inifity with invisible walls
        objects[14][18] = new InvisibleWall();
        objects[15][18] = new InvisibleWall();
        objects[13][18] = new InvisibleWall();
        objects[16][18] = new InvisibleWall();
        objects[14][17] = new InvisibleWall();
        objects[15][17] = new InvisibleWall();
        objects[16][17] = new InvisibleWall();
        objects[16][16] = new InvisibleWall();
        objects[15][16] = new InvisibleWall();
        objects[14][16] = new InvisibleWall();
        objects[15][15] = new InvisibleWall();
        objects[14][15] = new InvisibleWall();
        objects[15][19] = new InvisibleWall();
        objects[14][19] = new InvisibleWall();
        objects[15][20] = new InvisibleWall();
        objects[14][20] = new InvisibleWall();

        //block the buildings with invisible walls
        //Gleason
        objects[6][0] = new InvisibleWall();
        objects[7][0] = new InvisibleWall();
        objects[8][0] = new InvisibleWall();
        objects[9][0] = new InvisibleWall();
        objects[10][0] = new InvisibleWall();
        objects[11][0] = new InvisibleWall();
        objects[12][0] = new InvisibleWall();
        objects[13][0] = new InvisibleWall();
        objects[14][0] = new InvisibleWall();
        objects[15][0] = new InvisibleWall();
        objects[16][0] = new InvisibleWall();
        objects[17][0] = new InvisibleWall();
        objects[18][0] = new InvisibleWall();
        objects[19][0] = new InvisibleWall();
        objects[20][0] = new InvisibleWall();
        objects[21][0] = new InvisibleWall();
        objects[22][0] = new InvisibleWall();

        objects[6][1] = new InvisibleWall();
        objects[7][1] = new InvisibleWall();
        objects[8][1] = new InvisibleWall();
        objects[9][1] = new InvisibleWall();
        objects[10][1] = new InvisibleWall();
        objects[11][1] = new InvisibleWall();
        objects[12][1] = new InvisibleWall();
        objects[13][1] = new InvisibleWall();
        objects[14][1] = new InvisibleWall();
        objects[15][1] = new InvisibleWall();
        objects[16][1] = new InvisibleWall();
        objects[17][1] = new InvisibleWall();
        objects[18][1] = new InvisibleWall();
        objects[19][1] = new InvisibleWall();
        objects[20][1] = new InvisibleWall();
        objects[21][1] = new InvisibleWall();
        objects[22][1] = new InvisibleWall();

        objects[6][2] = new InvisibleWall();
        objects[7][2] = new InvisibleWall();
        objects[8][2] = new InvisibleWall();
        objects[9][2] = new InvisibleWall();
        objects[10][2] = new InvisibleWall();
        objects[11][2] = new InvisibleWall();
        objects[12][2] = new InvisibleWall();
        objects[13][2] = new InvisibleWall();
        objects[14][2] = new InvisibleWall();
        objects[15][2] = new InvisibleWall();
        objects[16][2] = new InvisibleWall();
        objects[17][2] = new InvisibleWall();
        objects[18][2] = new InvisibleWall();
        objects[19][2] = new InvisibleWall();
        objects[20][2] = new InvisibleWall();
        objects[21][2] = new InvisibleWall();
        objects[22][2] = new InvisibleWall();

        //Booth
        objects[29][2] = new InvisibleWall();
        objects[29][3] = new InvisibleWall();
        objects[29][4] = new InvisibleWall();
        objects[29][5] = new InvisibleWall();
        objects[29][6] = new InvisibleWall();
        objects[29][7] = new InvisibleWall();
        objects[29][8] = new InvisibleWall();
        objects[29][9] = new InvisibleWall();
        objects[29][10] = new InvisibleWall();
        objects[29][11] = new InvisibleWall();
        objects[29][12] = new InvisibleWall();
        objects[29][13] = new InvisibleWall();
        objects[29][14] = new InvisibleWall();
        objects[29][15] = new InvisibleWall();
        objects[29][16] = new InvisibleWall();
        objects[29][17] = new InvisibleWall();
        objects[29][18] = new InvisibleWall();
        objects[29][19] = new InvisibleWall();
        objects[29][20] = new InvisibleWall();
        objects[29][21] = new InvisibleWall();
        objects[29][22] = new InvisibleWall();

        objects[28][2] = new InvisibleWall();
        objects[28][3] = new InvisibleWall();
        objects[28][4] = new InvisibleWall();
        objects[28][5] = new InvisibleWall();
        objects[28][6] = new InvisibleWall();
        objects[28][7] = new InvisibleWall();
        objects[28][8] = new InvisibleWall();
        objects[28][9] = new InvisibleWall();
        objects[28][10] = new InvisibleWall();
        objects[28][11] = new InvisibleWall();
        objects[28][12] = new InvisibleWall();
        objects[28][13] = new InvisibleWall();
        objects[28][14] = new InvisibleWall();
        objects[28][15] = new InvisibleWall();
        objects[28][16] = new InvisibleWall();
        objects[28][17] = new InvisibleWall();
        objects[28][18] = new InvisibleWall();
        objects[28][19] = new InvisibleWall();
        objects[28][20] = new InvisibleWall();
        objects[28][21] = new InvisibleWall();
        objects[28][22] = new InvisibleWall();

        objects[27][2] = new InvisibleWall();
        objects[27][3] = new InvisibleWall();
        objects[27][4] = new InvisibleWall();
        objects[27][5] = new InvisibleWall();
        objects[27][6] = new InvisibleWall();
        objects[27][7] = new InvisibleWall();
        objects[27][8] = new InvisibleWall();
        objects[27][9] = new InvisibleWall();
        objects[27][10] = new InvisibleWall();
        objects[27][11] = new InvisibleWall();
        objects[27][12] = new InvisibleWall();
        objects[27][13] = new InvisibleWall();
        objects[27][14] = new InvisibleWall();
        objects[27][15] = new InvisibleWall();
        objects[27][16] = new InvisibleWall();
        objects[27][17] = new InvisibleWall();
        objects[27][18] = new InvisibleWall();
        objects[27][19] = new InvisibleWall();
        objects[27][20] = new InvisibleWall();
        objects[27][21] = new InvisibleWall();
        objects[27][22] = new InvisibleWall();

        objects[26][3] = new InvisibleWall();
        objects[26][4] = new InvisibleWall();
        objects[26][5] = new InvisibleWall();
        objects[26][6] = new InvisibleWall();
        objects[26][7] = new InvisibleWall();
        objects[26][8] = new InvisibleWall();
        objects[26][9] = new InvisibleWall();
        objects[26][10] = new InvisibleWall();
        objects[26][11] = new InvisibleWall();
        objects[26][12] = new InvisibleWall();
        objects[26][13] = new InvisibleWall();
        objects[26][14] = new InvisibleWall();
        objects[26][15] = new InvisibleWall();
        objects[26][16] = new InvisibleWall();
        objects[26][17] = new InvisibleWall();
        objects[26][18] = new InvisibleWall();
        objects[26][19] = new InvisibleWall();
        objects[26][20] = new InvisibleWall();
        objects[26][21] = new InvisibleWall();


        //Gosnell
        objects[0][0] = new InvisibleWall();
        objects[0][1] = new InvisibleWall();
        objects[0][2] = new InvisibleWall();
        objects[0][3] = new InvisibleWall();
        objects[0][4] = new InvisibleWall();
        objects[0][5] = new InvisibleWall();
        objects[0][6] = new InvisibleWall();
        objects[0][7] = new InvisibleWall();
        objects[0][8] = new InvisibleWall();
        objects[0][9] = new InvisibleWall();
        objects[0][10] = new InvisibleWall();
        objects[0][11] = new InvisibleWall();
        objects[0][12] = new InvisibleWall();
        objects[0][13] = new InvisibleWall();
        objects[0][14] = new InvisibleWall();
        objects[0][15] = new InvisibleWall();
        objects[0][16] = new InvisibleWall();
        objects[0][17] = new InvisibleWall();
        objects[0][18] = new InvisibleWall();
        objects[0][19] = new InvisibleWall();
        objects[0][20] = new InvisibleWall();
        objects[0][21] = new InvisibleWall();
        objects[0][22] = new InvisibleWall();
        objects[0][23] = new InvisibleWall();

        objects[1][0] = new InvisibleWall();
        objects[1][1] = new InvisibleWall();
        objects[1][2] = new InvisibleWall();
        objects[1][3] = new InvisibleWall();
        objects[1][4] = new InvisibleWall();
        objects[1][5] = new InvisibleWall();
        objects[1][6] = new InvisibleWall();
        objects[1][7] = new InvisibleWall();
        objects[1][8] = new InvisibleWall();
        objects[1][9] = new InvisibleWall();
        objects[1][10] = new InvisibleWall();
        objects[1][11] = new InvisibleWall();
        objects[1][12] = new InvisibleWall();
        objects[1][13] = new InvisibleWall();
        objects[1][14] = new InvisibleWall();
        objects[1][15] = new InvisibleWall();
        objects[1][16] = new InvisibleWall();
        objects[1][17] = new InvisibleWall();
        objects[1][18] = new InvisibleWall();
        objects[1][19] = new InvisibleWall();
        objects[1][20] = new InvisibleWall();
        objects[1][21] = new InvisibleWall();
        objects[1][22] = new InvisibleWall();
        objects[1][23] = new InvisibleWall();

        objects[2][6] = new InvisibleWall();
        objects[3][6] = new InvisibleWall();
        objects[4][6] = new InvisibleWall();

        objects[2][7] = new InvisibleWall();
        objects[3][7] = new InvisibleWall();
        objects[4][7] = new InvisibleWall();

        objects[2][8] = new InvisibleWall();
        objects[3][8] = new InvisibleWall();

        objects[2][9] = new InvisibleWall();

        //objects[2][13] = new InvisibleWall();
        objects[2][14] = new InvisibleWall();
        objects[2][15] = new InvisibleWall();
        objects[2][16] = new InvisibleWall();
        objects[2][17] = new InvisibleWall();
        objects[2][18] = new InvisibleWall();
        objects[2][19] = new InvisibleWall();
        objects[2][20] = new InvisibleWall();
        objects[2][21] = new InvisibleWall();
        objects[2][22] = new InvisibleWall();
        objects[2][23] = new InvisibleWall();

        //objects[3][13] = new InvisibleWall();
        //objects[3][14] = new InvisibleWall();
        objects[3][15] = new InvisibleWall();
        objects[3][16] = new InvisibleWall();
        objects[3][17] = new InvisibleWall();
        objects[3][18] = new InvisibleWall();
        objects[3][19] = new InvisibleWall();
        objects[3][20] = new InvisibleWall();
        objects[3][21] = new InvisibleWall();
        objects[3][22] = new InvisibleWall();
        objects[3][23] = new InvisibleWall();

        objects[4][16] = new InvisibleWall();
        objects[4][17] = new InvisibleWall();
        objects[4][18] = new InvisibleWall();
        objects[4][19] = new InvisibleWall();
        objects[4][20] = new InvisibleWall();
        objects[4][21] = new InvisibleWall();




        background = new ImageIcon(this.getClass().getResource("backgrounds/infinityQuad.gif")).getImage();
    }

    @Override
    public GameState takeTurn() {
        Thing[][] after = new Thing[30][30];
        //move a teacher depending on the turnNum and the random number. Move the teacher
        //into the "after" array. set object array to after array. start again
        for (int i = 0; i < after.length; i++) {
            for (int j = 0; j < after[0].length; j++) {
                if (objects[i][j] != null) {
                    if (objects[i][j] instanceof Teacher) {
                        Teacher T = (Teacher) objects[i][j];
                        if (turnNum % 2 == 0) {
                            double r = Math.random();
                            if (r <= .5) {
                                if (i + 1 <= 29) {
                                    if (objects[i + 1][j] == null)
                                        after[i + 1][j] = T;
                                    else
                                        after[i][j] = T;
                                } else {
                                    after[i][j] = T;
                                }
                            } else {
                                if (j + 1 <= 29) {
                                    if (objects[i][j + 1] == null)
                                        after[i][j + 1] = T;
                                    else
                                        after[i][j] = T;
                                } else {
                                    after[i][j] = T;
                                }
                            }
                        } else {
                            double r = Math.random();
                            if (r <= .5) {
                                if (i - 1 >= 0) {
                                    if (objects[i - 1][j] == null)
                                        after[i - 1][j] = T;
                                    else
                                        after[i][j] = T;
                                } else {
                                    after[i][j] = T;
                                }
                            } else {
                                if (j - 1 >= 0) {
                                    if (objects[i][j - 1] == null)
                                        after[i][j - 1] = T;
                                    else
                                        after[i][j] = T;
                                } else {
                                    after[i][j] = T;
                                }
                            }
                        }
                    } else {
                        after[i][j] = objects[i][j];
                    }
                }
            }
        }

        objects = after;
        if (objects[seb.x][seb.y] != null) {
            if (objects[seb.x][seb.y] instanceof Teacher) {
                seb.addStress(10);
            }
        }
        for (int i = seb.x - 1; i <= seb.x + 1 && i >= 0 && i < 30; i++) {
            for (int j = seb.y - 1; j <= seb.y + 1 && j >= 0 && j < 30; j++) {
                if (objects[i][j] instanceof Teacher) {
                    seb.addStress(10);
                }
            }
        }
        if(seb.y >= 29 && seb.x >= 15 && seb.x <= 17 ){
            nextLevel = true;
        }
        //System.out.println(seb.currentStress);
        return getGameState();
    }

}