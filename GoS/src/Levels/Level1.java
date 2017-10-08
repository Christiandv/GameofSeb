package Levels;
import Characters.Seb;
import Characters.Thing;
import Engines.GameState;

import java.awt.event.KeyEvent;


public class Level1 extends Level {
    @Override
    public boolean recieveInput(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if( !objects[seb.x][seb.y-1].isSolid){
                seb.y--;
            }
        }else if(e.getKeyCode() == KeyEvent.VK_UP){
            if( !objects[seb.x][seb.y-1].isSolid){
                seb.y--;
            }
        }else
            return true;
    }

    public Level1(){
        objects = new Characters.Thing[30][30];
        seb = new Seb(6,6);
        objects[2][2] = new Thing(2,2);
        objects[2][2].isSolid= true;
        objects[2][2].loadImage("src/Characters/resources/seb.gif");

    }

    @Override
    public GameState takeTurn() {
        return getGameState();
    }
}
