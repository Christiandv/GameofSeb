package Engines;


import Characters.Seb;
import Characters.Thing;

import java.awt.*;
import java.util.ArrayList;
public class GameState {
    public boolean nextLevel = false;
    public boolean stressBar;
    public Image background;
    public Thing[][] things;
    public Seb seb;
    public GameState(Thing[][] things, Seb seb, Image background, boolean stressBar, boolean nextLevel /* background */) {
        this.things = things;
        this.seb = seb;
        this.nextLevel = nextLevel;
        this.background = background;
        this.stressBar = stressBar;
    }
}
