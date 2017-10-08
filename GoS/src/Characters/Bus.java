package Characters;

import javax.swing.*;

/**
 * Created by Caitlin on 10/7/2017.
 */
public class Bus extends Thing
{
    public Bus(int x, int y)
    {
        super(x, y);
        isSolid = true;
        image = new ImageIcon("src/Characters/resources/rts bus.png").getImage();
    }
}
