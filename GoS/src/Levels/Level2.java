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
                    } else {
                        if (t instanceof Teacher) {
                            seb.addStress(1);
                        }
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
                    } else {
                        if (t instanceof Teacher) {
                            seb.addStress(1);
                        }
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
                    } else {
                        if (t instanceof Teacher) {
                            seb.addStress(1);
                        }
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
                    } else {
                        if (t instanceof Teacher) {
                            seb.addStress(1);
                        }
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
        objects[19][26] = new Teacher();
        //block the inifity with invisible walls
        objects[15][15] = new InvisibleWall();
        objects[14][14] = new InvisibleWall();
        objects[15][14] = new InvisibleWall();
        objects[16][14] = new InvisibleWall();
        objects[15][13] = new InvisibleWall();
        //block the buildings with invisible walls
        //Gleason
        objects[7][2] = new InvisibleWall();
        objects[8][2] = new InvisibleWall();
        objects[9][2] = new InvisibleWall();
        objects[10][2] = new InvisibleWall();
        objects[11][2] = new InvisibleWall();
        //Booth
        objects[29][3] = new InvisibleWall();
        objects[29][4] = new InvisibleWall();
        objects[29][5] = new InvisibleWall();
        objects[29][6] = new InvisibleWall();
        //Gosnell
        objects[1][0] = new InvisibleWall();
        objects[1][1] = new InvisibleWall();
        objects[1][2] = new InvisibleWall();
        objects[1][3] = new InvisibleWall();
        objects[1][4] = new InvisibleWall();
        objects[1][5] = new InvisibleWall();
        objects[1][6] = new InvisibleWall();




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

        //if(seb.x == 15 && seb.y == 30){
        //  nextLevel = true;
        //}
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
        //System.out.println(seb.currentStress);
        return getGameState();
    }

}