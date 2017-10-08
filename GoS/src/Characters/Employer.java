package Characters;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Caitlin on 10/7/2017.
 */
public class Employer extends Thing
{
    public String question;
    public ArrayList<String> answers;

    public Employer(int x, int y)
    {
        super(x, y);
        isSolid = true;
    }
}
