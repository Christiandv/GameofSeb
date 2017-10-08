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
        objects[10][20] = new Ghost(10, 10);
        seb.isVisable = false;

        background = new BufferedImage(16*16, 16*16, BufferedImage.TYPE_INT_RGB);
        Graphics gi = background.getGraphics();
        gi.setColor(Color.black);
        gi.fillRect(0,0,16*16,16*16);
        gi.setColor(Color.white);
        gi.drawString("The stress has overtaken poor Seb.",30*2-30,30*3+20);
        gi.drawString("The final score is: " + seb.getFinalScore(),30*2+16,30*5-20);
        gi.drawString("Press SPACE to restart",30*2,30*5+10);

    }

    @Override
    public GameState takeTurn() {

        return getGameState();
    }
}
