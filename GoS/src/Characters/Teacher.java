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
        double i = Math.random();
        if(i < .33) {
            image = (new ImageIcon(this.getClass().getResource("resources/teacher.gif"))).getImage();
        } else if (i <.5){
            image = (new ImageIcon(this.getClass().getResource("resources/girl.gif"))).getImage();
        }else{
            image = (new ImageIcon(this.getClass().getResource("resources/rit nerd.gif"))).getImage();
        }
    }
}
