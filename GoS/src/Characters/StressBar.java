package Characters;

import Characters.Thing;

import javax.swing.*;

/**
 * Created by JosefFentonLenz on 10/7/2017.
 */
public class StressBar extends Thing
{
    public StressBar()
    {
        super(160,16);
        isSolid = false;
        image = (new ImageIcon(this.getClass().getResource("resources/stressbar.png"))).getImage();
    }
}
