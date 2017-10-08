package Characters;

import javax.swing.*;

/**
 * Created by Caitlin on 10/7/2017.
 */
public class Ghost extends Thing
{
    public Ghost(int x, int y)
    {
        super(x, y);
        isSolid = false;
        image = new ImageIcon("src/Characters/resources/ghost.gif").getImage();
    }
}
