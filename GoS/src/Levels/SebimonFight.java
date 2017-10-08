package Levels;

import Characters.BackwardsSeb;
import Characters.Seb;
import Characters.Spider;
import Engines.GameState;

import javax.swing.*;
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
            gi.setColor(Color.gray);
            gi.fillRect(0, 0, 16 * 16, 16 * 16);
            gi.setColor(Color.BLACK);
            gi.drawString("A wild Spider appeared!", 30 * 2 - 20, 30 * 3 + 20);
            menu.add("1.Stress Ball");
            menu.add("2.Eloquent Response");
            menu.add("3.Raid");
            menu.add("4.Run");
        }

        else if (counter == 2) {
            Graphics gi = background.getGraphics();
            gi.setColor(Color.gray);
            gi.fillRect(0, 0, 16 * 16, 16 * 16);
            objects[4][20] = new BackwardsSeb(16,16);
            objects[15][4] = new Spider(16,16);
            counter++;
        }

        else if (counter >= 3) {
            //rounds of combat
            if (e.getKeyChar() == '1')
            {

            }
            else if (e.getKeyChar() == '2')
            {

            }
            else if (e.getKeyChar() == '3')
            {

            }
            else
            {

            }

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
