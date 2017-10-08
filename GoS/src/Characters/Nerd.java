package Characters;

import javax.swing.*;

/**
 * Created by Caitlin on 10/7/2017.
 */
public class Nerd extends Thing
{
    public Nerd(int x, int y)
    {
        super(x, y);
        isSolid = true;
        image = new ImageIcon("src/Characters/resources/rit nerd.gif").getImage();
    }
}
