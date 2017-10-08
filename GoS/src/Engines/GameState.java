package Engines;


import Characters.Seb;
import Characters.Thing;

import java.awt.*;
import java.util.ArrayList;
public class GameState {
    public boolean nextLevel = false;
    public Image background;
    public Thing[][] things;
    public Seb seb;
    public GameState(Thing[][] things, Seb seb, Image background, boolean nextLevel /* background */) {
        this.things = things;
        this.seb = seb;
        this.nextLevel = nextLevel;
        this.background = background;
    }
}
