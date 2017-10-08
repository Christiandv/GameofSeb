package Levels;

import Characters.Ghost;
import Characters.Seb;
import Engines.GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Caitlin on 10/8/2017.
 */
public class End extends Level
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
    public End()
    {
        stressBar = false;
        objects = new Characters.Thing[30][30];
        seb = new Seb(20, 20);
        Ghost ghost = new Ghost(10, 20);
        seb.width = 10;
        seb.height = 10;
        seb.isVisable = false;

        background = new BufferedImage(30 * 8, 30*8, BufferedImage.TYPE_INT_RGB);
        Graphics gi = background.getGraphics();
        gi.setColor(Color.black);
        gi.fillRect(0,0,30*8,30*8);
        gi.setColor(Color.white);
        gi.drawString("the stress has overtaken poor Seb",30*2-30,30*3+20);
        gi.drawString("the final score is: " + seb.getFinalScore(),30*2,30*5-20);
        gi.drawString("Press SPACE to restart",30*2-10,30*5+10);

    }

    @Override
    public GameState takeTurn() {

        return getGameState();
    }
}
