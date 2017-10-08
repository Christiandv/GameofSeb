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
        objects[6][10] = new Teacher();
        objects[20][15] = new Teacher();
        objects[15][4] = new Teacher();
        objects[16][20] = new Teacher();
    }

    @Override
    public GameState takeTurn() {
        Thing[][] after = new Thing[30][30];
        //move a teacher depending on the turnNum and the random number. Move the teacher
        //into the "after" array. set object array to after array. start again
        for(int i = 0; i < after.length; i++){
            for(int j = 0; j < after[0].length; j++){
                if(objects[i][j] != null){
                    if(objects[i][j] instanceof Teacher){
                        System.out.println();
                        Teacher T = (Teacher)objects[i][j];
                        if(turnNum%2 ==0){
                            double r = Math.random();
                            if(r<= .5){
                                if(i+1 <= 29) {
                                    after[i + 1][j] = T;
                                }
                            }else{
                                if(j+1 <=29) {
                                    after[i][j + 1] = T;
                                }
                            }
                        }else{
                            double r = Math.random();
                            if(r<= .5){
                                if(i-1 >= 0){
                                    after[i-1][j] = T;
                                }
                            }else{
                                if(j-1 >= 0) {
                                    after[i][j - 1] = T;
                                }
                            }
                        }
                    }

                }
            }
        }

        //if(seb.x == 15 && seb.y == 30){
          //  nextLevel = true;
        //}
        objects = after;
        return getGameState();
    }

}