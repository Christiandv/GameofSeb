import java.util.ArrayList;

public abstract class Level {
    Thing[][] objects;

    public abstract GameState takeTurn();

    public GameState getGameState() {
        ArrayList<Thing> things = new ArrayList<Thing>();
        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < objects[0].length; j++) {
                things.add(objects[i][j]);
            }
        }
        // do other things
        return new GameState(things);
    }

}

