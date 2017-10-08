package Levels;

import Characters.*;
import Engines.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


public class HomeLevel extends Level {
    @Override
    public boolean receiveInput(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            nextLevel = true;
            return true;
        }
        return false;
    }
    public HomeLevel()
    {
        stressBar = false;
        objects = new Characters.Thing[30][30];
        seb = new Seb(10, 20);
        seb.isVisable = false;

        background = new BufferedImage(30 * 8, 30*8, BufferedImage.TYPE_INT_RGB);
        Graphics gi = background.getGraphics();
        gi.setColor(Color.white);
        gi.fillRect(0,0,30*8,30*8);
        gi.setColor(Color.BLACK);
        gi.drawString("After classes, Seb heads home.",30*2-10,30*3+20);
        gi.drawString("Press SPACE to continue",30*2-30,30*5+10);

    }

    @Override
    public GameState takeTurn() {
        return getGameState();
    }
}
