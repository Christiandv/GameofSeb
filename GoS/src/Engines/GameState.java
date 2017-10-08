package Engines;

import java.util.ArrayList;
public class GameState {
    public ArrayList<Characters.Thing> things;
    public GameState(ArrayList<Characters.Thing> things /* background */) {
        this.things = things;
    }
}
