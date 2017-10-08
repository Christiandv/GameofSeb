package Characters;

import javax.swing.*;

/**
 * Created by Caitlin on 10/7/2017.
 */
public class Spider extends Thing
{
    public int health;
    private int maxHealth;

    public Spider(int x, int y)
    {
        super(x, y);
        image = new ImageIcon("src/Characters/resources/spider.gif").getImage();
        maxHealth = 100;
        health = 100;
        isSolid = true;
    }
}
