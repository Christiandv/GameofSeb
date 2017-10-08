package Characters;

import javax.swing.*;

/**
 * Created by Caitlin on 10/7/2017.
 */
public class Spider extends Thing
{


    public Spider(int x, int y)
    {
        super(x, y);
        image = (new ImageIcon(this.getClass().getResource("resources/spider.gif"))).getImage();
        isSolid = false;
    }
}
