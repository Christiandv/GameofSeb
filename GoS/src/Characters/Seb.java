package Characters;


import javax.swing.*;

/**
 * Created by Caitlin on 10/7/2017.
 */
public class Seb extends Characters.Thing {
    //our hero

    /**
     * inherits x, y, width, and height from Thing
     */
    public boolean textbook;
    public boolean raid;
    public int shots;
    public int currentStress;
    private int maxStress;

    public Seb(int x, int y)
    {
        super(x,y);
        maxStress = 100;
        currentStress = 0;
        shots = 0;
        raid = false;
        textbook = false;
        isSolid = true;
        image = new ImageIcon("src/Characters/resources/seb.gif").getImage();
    }

}
