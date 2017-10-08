package Levels;

import Characters.Ghost;
import Characters.Seb;
import Characters.Spider;
import Characters.Teacher;
import Engines.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Caitlin on 10/8/2017.
 */
public class ActualWin extends Level {

    Image border = (new ImageIcon(this.getClass().getResource("backgrounds/fancy frame.png"))).getImage();

    @Override
    public boolean receiveInput(KeyEvent e) {

        nextLevel = true;
        return true;
    }

    public ActualWin() {
        stressBar = false;
        objects = new Characters.Thing[30][30];
        seb = new Seb(20, 20);
        seb.isVisable = false;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                if (i < 6 || i > 24 || j < 12 || j > 18) {

                    if (Math.random() < .2)
                        objects[i][j] = new Teacher();
                    if (Math.random() < .2)
                        objects[i][j] = new Seb(i, j);


                }
            }
        }


        background = new BufferedImage(16 * 16, 16 * 16, BufferedImage.TYPE_INT_RGB);
        Graphics gi = background.getGraphics();
        gi.drawImage(border, 0, 0, 16 * 16, 16 * 16, null);
        gi.setColor(Color.BLACK);
        Font font = new Font("Helvetica", Font.BOLD, 12);
        gi.setFont(font);
        gi.setColor(Color.black);
        gi.drawString("Having defeated the spider", 30 * 2 - 6, 30 * 3 + 20);
        gi.drawString("Seb ascended to a Rap God", 30 * 2 - 6, 30 * 3 + 32);
        gi.drawString("Score: " + seb.getFinalScore(), 30 * 2 + 36, 30 * 5 - 6);
        gi.drawString("Press SPACE to restart", 30 * 2 + 6, 30 * 5 + 10);

    }

    @Override
    public GameState takeTurn() {

        return getGameState();
    }
}
