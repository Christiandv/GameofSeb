package Engines;


import Characters.Seb;

import java.util.ArrayList;
public class GameState {
    public ArrayList<Characters.Thing> things;
    public Seb seb;
    public GameState(ArrayList<Characters.Thing> things,Seb seb /* background */) {
        this.things = things;
        this.seb = seb;
    }
}
