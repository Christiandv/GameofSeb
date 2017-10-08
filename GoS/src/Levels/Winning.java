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
    @Override
    public boolean receiveInput(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            nextLevel = true;
            return true;
        }
        return false;
    }
    public Winning()
    {
        stressBar = false;
        objects = new Characters.Thing[30][30];
        seb = new Seb(20, 20);
        objects[10][20] = new Spider(10, 10);
        seb.isVisable = false;

        background = new BufferedImage(30 * 8, 30*8, BufferedImage.TYPE_INT_RGB);
        Graphics gi = background.getGraphics();
        gi.setColor(Color.gray);
        gi.fillRect(0,0,30*8,30*8);
        gi.setColor(Color.black);
        gi.drawString("Finally home, Seb can rest.",30*2-30,30*3+20);
        gi.drawString("Except for the spiders. Score: " + seb.getFinalScore(),30*2,30*5-20);
        gi.drawString("Press SPACE to restart",30*2-10,30*5+10);

    }

    @Override
    public GameState takeTurn() {

        return getGameState();
    }
}
