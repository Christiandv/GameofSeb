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
import java.nio.Buffer;import java.awt.Font;
import java.awt.FontMetrics;



public class Opening extends Level {
    int counter = 0;
    Image border = (new ImageIcon(this.getClass().getResource("backgrounds/fancy frame.png"))).getImage();
    @Override
    public boolean receiveInput(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

            counter += 1;
            nextLevel = false;
            if (counter == 1)
            {
                background = new BufferedImage(16 * 16, 16*16, BufferedImage.TYPE_INT_RGB);

                Graphics gi = background.getGraphics();
                gi.drawImage(border,0,0,16*16,16*16,null);

                gi.setColor(Color.BLACK);
                Font font = new Font("Helvetica", Font.BOLD, 12);
                gi.setFont(font);

                gi.setColor(Color.BLACK);
                gi.drawString("    Seb is awoken by    ",30*2,30*3);
                gi.drawString("loud vacuuming upstairs.",30*2,30*3+12);
                gi.drawString("Press SPACE to yell at them.",30*2-10,30*5-5);
                gi.drawString("Catch the bus to campus!",30*2,30*5+7);
            }
            else
            {
                nextLevel = true;
            }
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
        //seb.currentStress = 0;
        //seb.popQuizScore = 0;
        //seb.score = 0;
        //seb.interviews = 0;
        //seb.spidersKilled = 0;
        //seb.textbook = false;
        //seb.shots = 0;
        //seb.raid = false;

        background = new BufferedImage(16 * 16, 16*16, BufferedImage.TYPE_INT_RGB);

        Graphics gi = background.getGraphics();
        gi.drawImage(border,0,0,16*16,16*16,null);

        gi.setColor(Color.BLACK);
        Font font = new Font("Helvetica", Font.BOLD, 12);
        gi.setFont(font);
        gi.drawString("SEB'S VERY BAD DAY",30*2+10,30*3-20);
        gi.drawString("Made by: Ani, Caitlin,",30*2+14,30*5-30);
        gi.drawString(    "  Christian, and Joe  ",30*2+14,30*5-12);
        gi.drawString("Press SPACE",30*2+30,30*5+7);


    }

    @Override
    public GameState takeTurn()
    {
        GameState state = getGameState();
        Seb seb = state.seb;
        seb.currentStress = 0;
        seb.popQuizScore = 0;
        seb.score = 0;
        seb.interviews = 0;
        seb.spidersKilled = 0;
        seb.textbook = false;
        seb.shots = 0;
        seb.raid = false;
        state.seb = seb;
        return state;
    }
}
