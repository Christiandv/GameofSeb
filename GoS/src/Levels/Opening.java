package Levels;

import Characters.Bus;
import Characters.InvisibleWall;
import Characters.Seb;
import Characters.Thing;
import Engines.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.nio.Buffer;


public class Opening extends Level {
    int counter = 0;
    @Override
    public boolean receiveInput(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

            nextLevel = true;
            return true;
        }
        return false;
    }

    public Opening() {
        stressBar = false;
        objects = new Characters.Thing[30][30];
        seb = new Seb(10, 20);
        seb.width = 10;
        seb.height = 10;
        background = new BufferedImage(30 * 8, 30*8, BufferedImage.TYPE_INT_RGB);
        Graphics gi = background.getGraphics();
        gi.setColor(Color.white);
        gi.fillRect(0,0,30*8,30*8);
        gi.setColor(Color.BLACK);
        gi.drawString("SEB'S VERY BAD DAY",30*2-5,30*3);
        gi.drawString("Press Space to be awakened",30*2-20,30*5-5);
        gi.drawString("by your upstairs neighbors!!",30*2-15,30*5+5);


    }

    @Override
    public GameState takeTurn() {


        return getGameState();
    }
}
