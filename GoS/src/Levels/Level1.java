package Levels;
import Characters.Thing;
import Engines.GameState;

import java.awt.event.KeyEvent;


public class Level1 extends Level {
    @Override
    public boolean recieveInput(KeyEvent e) {
        return false;
    }

    public Level1(){
        objects = new Characters.Thing[30][30];
        objects[2][2] = new Thing(2,2);
        objects[2][2].loadImage("src/Characters/resources/seb.gif");

    }

    @Override
    public GameState takeTurn() {
        return getGameState();
    }
}
