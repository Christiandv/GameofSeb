package Levels;

import Characters.Seb;
import Characters.Thing;
import Engines.GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public abstract class Level {
    Thing[][] objects;
    Seb seb;
    boolean nextLevel = false;
    boolean endScreen = false;
    public Image background;
    boolean stressBar;


    // handle key presses. return true if a turn should be taken.
    // some actions might need to have multiple buttons pressed in sequence
    public abstract boolean receiveInput(KeyEvent e);

    public abstract GameState takeTurn();

    public GameState getGameState() {


        // do other things
        return new GameState(objects,seb, background, stressBar, nextLevel, endScreen);
    }

}

