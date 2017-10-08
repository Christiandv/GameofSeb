package Levels;

import Characters.Ghost;
import Characters.Seb;
import Characters.Spider;
import Engines.GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Caitlin on 10/8/2017.
 */
public class Winning extends Level
{
    int counter = 0;
    @Override
    public boolean receiveInput(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            counter++;
            if( counter ==1){
                objects[10][20] = new Spider(10, 10);
                Graphics gi = background.getGraphics();
                gi.setColor(Color.red);
                gi.drawString("Except for the Spiders",30*2+6,30*3+40);
            }else{
                nextLevel = true;
            }

            return true;
        }
        return false;
    }
    public Winning()
    {
        stressBar = false;
        objects = new Characters.Thing[30][30];
        seb = new Seb(20, 20);

        seb.isVisable = false;

        background = new BufferedImage(16*16, 16*16, BufferedImage.TYPE_INT_RGB);
        Graphics gi = background.getGraphics();
        gi.setColor(Color.gray);
        gi.fillRect(0,0,16*16,16*16);
        gi.setColor(Color.black);
        gi.drawString("Finally home, Seb can rest.",30*2-10,30*3+20);
        gi.drawString("Score: " + seb.getFinalScore(),30*2+40,30*5-6);
        gi.drawString("Press SPACE to restart",30*2,30*5+10);

    }

    @Override
    public GameState takeTurn() {

        return getGameState();
    }
}
