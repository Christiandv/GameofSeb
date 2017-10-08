package Levels;

import Characters.Seb;
import Engines.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Caitlin on 10/8/2017.
 */
public class HomeTransition extends Level
{
    Image border = (new ImageIcon(this.getClass().getResource("backgrounds/fancy frame.png"))).getImage();
    @Override
    public boolean receiveInput(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            nextLevel = true;
            return true;
        }
        return false;
    }

    public HomeTransition()
    {
        stressBar = false;
        objects = new Characters.Thing[30][30];
        seb = new Seb(10, 20);
        seb.isVisable = false;

        background = new BufferedImage(16 * 16, 16*16, BufferedImage.TYPE_INT_RGB);
        Graphics gi = background.getGraphics();
        gi.drawImage(border,0,0,16*16,16*16,null);
        gi.setColor(Color.BLACK);
        Font font = new Font("Helvetica", Font.BOLD, 12);
        gi.setFont(font);
        gi.setColor(Color.BLACK);
        gi.drawString("After classes,",30*2-20,30*3+20);
        gi.drawString("Seb heads home.",30*2-20,30*3+20);
        gi.drawString("Press SPACE to continue",30*2,30*5-10);

    }

    @Override
    public GameState takeTurn() {
        return getGameState();
    }
}
