package Levels;

import Characters.BackwardsSeb;
import Characters.Fireball;
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
    int counter = 1;
    int spiderHp = 100;
    ArrayList<String> menu = new ArrayList<String>();

    @Override
    public boolean receiveInput(KeyEvent e) {


        if (counter == 1) {
            Graphics gi = background.getGraphics();
            gi.setColor(Color.gray);
            gi.fillRect(0, 0, 16 * 16, 16 * 16);
            objects[4][13] = new BackwardsSeb(16,16);
            objects[15][4] = new Spider(16,16);
            counter++;
            gi.setColor(Color.white);
            gi.fillRect(0,200, 16 * 16, 16 * 4);
            gi.setColor(Color.black);
            gi.drawString("1.Stress Ball", 25, 210);
            gi.drawString("2.Eloquent Response", 100, 210 );
            gi.drawString("3.Raid", 25, 245);
            gi.drawString("4.Run", 100, 245);
        }

        else if (counter >= 2) {
            //rounds of combat
            Graphics gi = background.getGraphics();
            gi.setColor(Color.BLACK);
            if (e.getKeyChar() == '1')
            {
                gi.setColor(Color.white);
                gi.fillRect(0,200, 16 * 16, 16 * 4);
                gi.setColor(Color.black);
                gi.drawString("Seb used Stress Ball!",25,225);
                objects[10][5] = new Fireball(16, 16);
                spiderHp = 0;
            }
            else if (e.getKeyChar() == '2')
            {
                gi.setColor(Color.white);
                gi.fillRect(0,200, 16 * 16, 16 * 4);
                gi.setColor(Color.black);
                gi.drawString("Seb cries: Have mercy on me!",25,225);
                counter = 0;
            }
            else if (e.getKeyChar() == '3')
            {
                gi.setColor(Color.white);
                gi.fillRect(0,200, 16 * 16, 16 * 4);
                gi.setColor(Color.black);
                gi.drawString("Raid hasn't been programmed in!",25,225);
                counter = 0;
            }
            else if (e.getKeyChar() == 'w')
            {

                nextLevel = true;
                return true;
            }
            else
            {
                gi.setColor(Color.white);
                gi.fillRect(0,200, 16 * 16, 16 * 4);
                gi.setColor(Color.black);
                gi.drawString("The spider is too fast to be outrun!",25,225);
                counter = 0;
            }

            counter++;
        }

        else if (spiderHp <= 0) {
            nextLevel = true;
            return true;

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

    @Override
    public GameState takeTurn() {


        return getGameState();
    }
}
