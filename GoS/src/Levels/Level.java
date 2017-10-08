package Levels;

import Characters.Seb;
import Characters.Thing;
import Engines.GameState;

import java.awt.event.KeyEvent;
import java.util.ArrayList;


public abstract class Level {
    Thing[][] objects;
    Seb seb;


    // handle key presses. return true if a turn should be taken.
    // some actions might need to have multiple buttons pressed in sequence
    public abstract boolean receiveInput(KeyEvent e);

    public abstract GameState takeTurn();

    public GameState getGameState() {
        ArrayList<Thing> things = new ArrayList<Thing>();
        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < objects[0].length; j++) {
                if (objects[i][j] != null)
                    things.add(objects[i][j]);
            }
        }
        // do other things
        return new GameState(things,seb);
    }

}

