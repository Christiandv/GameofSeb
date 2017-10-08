package Characters;

import java.awt.*;

public class InvisibleWall extends Thing {
    public InvisibleWall(int x, int y){
        super(x,y);
        isSolid = true;
    }
    public void draw(Graphics g){

    }
}
