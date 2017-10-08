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
public class WalkToClass extends Level
{
    int counter = 0;
    Image border = (new ImageIcon(this.getClass().getResource("backgrounds/fancy frame.png"))).getImage();

    @Override
    public boolean receiveInput(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            counter++;
            if( counter == 1){
                background = new BufferedImage(16 * 16, 16*16, BufferedImage.TYPE_INT_RGB);
                Graphics gi = background.getGraphics();
                gi.drawImage(border,0,0,16*16,16*16,null);
                gi.setColor(Color.BLACK);
                Font font = new Font("Helvetica", Font.BOLD, 12);
                gi.setFont(font);
                gi.setColor(Color.BLACK);
                gi.drawString("          Quick!        ",30*2+20,30*3+8);
                gi.drawString("Make it past the humans!",30*2,30*3+20);
                gi.drawString("Your class is due south!",30*2+4,30*3+32);
                gi.drawString("Press SPACE to continue ",30*2,30*5+10);
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

        background = new BufferedImage(16 * 16, 16*16, BufferedImage.TYPE_INT_RGB);
        Graphics gi = background.getGraphics();
        gi.drawImage(border,0,0,16*16,16*16,null);
        gi.setColor(Color.BLACK);
        Font font = new Font("Helvetica", Font.BOLD, 12);
        gi.setFont(font);
        gi.setColor(Color.BLACK);
        gi.drawString("Seb has missed the bus.",30*2-2,30*3+20);
        gi.drawString("He walks the rest of",30*2+12,30*5-20);
        gi.drawString(" the way to campus. ",30*2+12,30*5-8);
        gi.drawString("HE IS LATE!",30*2+36,30*5+10);

    }

    @Override
    public GameState takeTurn() {


        return getGameState();
    }
}
