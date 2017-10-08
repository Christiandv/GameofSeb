package Levels;
import Engines.GameState;

import java.awt.event.KeyEvent;

public class Level1 extends Level {
    @Override
    public boolean recieveInput(KeyEvent e) {
        return false;
    }

    public Level1(){
        objects = new Characters.Thing[30][30];
    }

    @Override
    public GameState takeTurn() {
        return getGameState();
    }
}
