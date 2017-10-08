package Characters;

/**
 * Created by Caitlin on 10/7/2017.
 */
package GoS.src.Characters;
public class Seb extends Thing{
    //our hero

    /**
     * inherits x, y, width, and height from Thing
     */
    public boolean textbook;
    public boolean raid;
    public int shots;
    public int currentStress;
    private int maxStress;

    public Seb()
    {
        maxStress = 100;
        currentStress = 0;
        shots = 0;
        raid = false;
        textbook = false;
        isSolid = true;
    }
}
