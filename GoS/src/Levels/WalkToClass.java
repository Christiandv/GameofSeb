package Levels;

import Characters.Seb;
import Engines.GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Caitlin on 10/8/2017.
 */
public class WalkToClass extends Level
{
    int counter = 0;
    @Override
    public boolean receiveInput(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            counter++;
            if( counter == 1){
                background = new BufferedImage(16*16, 16*16, BufferedImage.TYPE_INT_RGB);
                Graphics gi = background.getGraphics();
                gi.setColor(Color.white);
                gi.fillRect(0,0,16*16,16*16);
                gi.setColor(Color.BLACK);
                gi.drawString("Quick! Make it past the humans!",30*2-20,30*3+20);
                gi.drawString("Your class is due south!",30*2+4,30*5-20);
                gi.drawString("Press SPACE to continue to class",30*2-24,30*5+10);
            }else{
                nextLevel = true;
            }
            //nextLevel = true;
            return true;
        }
        return false;
    }
    public WalkToClass()
    {
        stressBar = false;
        objects = new Characters.Thing[30][30];
        seb = new Seb(10, 20);
        seb.isVisable = false;

        background = new BufferedImage(16*16, 16*16, BufferedImage.TYPE_INT_RGB);
        Graphics gi = background.getGraphics();
        gi.setColor(Color.white);
        gi.fillRect(0,0,16*16,16*16);
        gi.setColor(Color.BLACK);
        gi.drawString("Seb has missed the bus,",30*2-2,30*3+20);
        gi.drawString("and walks the rest of the way to campus.",30*2-42,30*5-20);
        gi.drawString("HE IS LATE!",30*2+30,30*5+10);

    }

    @Override
    public GameState takeTurn() {


        return getGameState();
    }
}
