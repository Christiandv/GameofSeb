package Characters;

import javax.swing.*;

/**
 * Created by Caitlin on 10/8/2017.
 */
public class Fireball extends Thing
{
    public Fireball(int x, int y)
    {
        super(x, y);
        isSolid = true;
        image = (new ImageIcon(this.getClass().getResource("resources/ghost.gif"))).getImage();
    }
}
