package Engines;


import Characters.Seb;
import Characters.Thing;

import java.util.ArrayList;
public class GameState {
    public Thing[][] things;
    public Seb seb;
    public GameState(Thing[][] things,Seb seb /* background */) {
        this.things = things;
        this.seb = seb;
    }
}
