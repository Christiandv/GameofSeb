package Characters;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Caitlin on 10/7/2017.
 */
public class Seb extends Characters.Thing {
    //our hero

    /**
     * inherits x, y, width, and height from Thing
     */
    public int x,y;
    public boolean textbook;
    public boolean raid;
    public int shots;
    public int currentStress;
    public int maxStress;
    public int interviews;
    public int spidersKilled;
    public int popQuizScore;
    public int score;

    public Seb(int x, int y)
    {
        super(1,1);
        this.x = x;
        this.y = y;

        maxStress = 100;
        currentStress = 0;
        shots = 0;
        raid = false;
        textbook = false;
        isSolid = true;
        image = (new ImageIcon(this.getClass().getResource("resources/seb.gif"))).getImage();

        score = 0;
        interviews = 0;
        popQuizScore = 0;
        spidersKilled = 0;
    }

    public void draw(Graphics g){
        draw(g,x,y);
    }
    public int getFinalScore()
    {
        this.score = (interviews + spidersKilled + popQuizScore - currentStress);
        return score;
    }

    public int addStress (int increment){
        if(currentStress + increment <= maxStress){
            return currentStress += increment;
        }
        else{
            System.out.println("the stress overtakes poor seb");
            return currentStress = maxStress;
        }

    }

}
