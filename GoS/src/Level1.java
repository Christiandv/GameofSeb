public class Level1 extends Level {
    public Level1(){
        objects = new Thing[30][30];
    }

    @Override
    public GameState takeTurn() {
        return getGameState();
    }
}
