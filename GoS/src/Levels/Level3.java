package Levels;

import Engines.GameState;

import java.awt.event.KeyEvent;

public class Level3 extends Level {
    @Override
    public boolean receiveInput(KeyEvent e){
        return false;
    }

    public Level3(){}

    @Override
    public GameState takeTurn(){
        return null;
    }
}
