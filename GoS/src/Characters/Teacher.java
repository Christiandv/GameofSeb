package Characters;

import javax.swing.*;

/**
 * Created by Caitlin on 10/7/2017.
 */
public class Teacher extends Thing
{
    public Teacher()
    {
        super(1,1);
        isSolid = true;
        image = (new ImageIcon(this.getClass().getResource("resources/teacher.gif"))).getImage();
    }
}
