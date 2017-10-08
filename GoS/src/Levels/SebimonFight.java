package Levels;

import Characters.Seb;
import Engines.GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by joseffentonlenz on 10/8/17.
 */
public class SebimonFight extends Level {
    int counter = 0;
    int spiderHp = 100;
    ArrayList<String> menu = new ArrayList<String>();


    @Override
    public boolean receiveInput(KeyEvent e) {
        counter++;
        if (counter == 1) {
            background = new BufferedImage(16 * 16, 16 * 16, BufferedImage.TYPE_INT_RGB);
            Graphics gi = background.getGraphics();
            gi.setColor(Color.white);
            gi.fillRect(0, 0, 16 * 16, 16 * 16);
            gi.setColor(Color.BLACK);
            gi.drawString("A wild Spider appeared!", 30 * 2 - 20, 30 * 3 + 20);
            menu.add("Stress Ball");
            menu.add("Eloquent Response");
            menu.add("Raid");
            menu.add("Run");
        }

        else if (counter == 2) {
            // add images entering on screen here
            counter++;
        }

        else if (counter >= 3) {
            //rounds of combat

            counter++;
        }

        else if (spiderHp <= 0) {
            //win
        }

        else if (seb.currentStress >= 100){
            //die
        }
        else {
            nextLevel = true;
        }
        //nextLevel = true;
        return true;
    }

    public SebimonFight () {
        stressBar = false;
        objects = new Characters.Thing[30][30];
        seb = new Seb(10, 20);
        seb.isVisable = false;
    }

    @Override
    public GameState takeTurn() {


        return getGameState();
    }
}
