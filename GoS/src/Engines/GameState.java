package Engines;


import Characters.Seb;
import Characters.Thing;

import java.util.ArrayList;
public class GameState {
    public boolean nextLevel = false;

    public Thing[][] things;
    public Seb seb;
    public GameState(Thing[][] things, Seb seb, boolean nextLevel /* background */) {
        this.things = things;
        this.seb = seb;
        this.nextLevel = nextLevel;
    }
}
