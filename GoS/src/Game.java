import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
import Engines.*;
import Levels.*;



public class Game extends JFrame {
    ArrayList<Level> levels = new ArrayList<Level>();
    GraphicsEngine GE;
    int currentLevel = 0;
    private Game() {

        initUI();
    }

    private void initUI() {
        final int WIDTH = 700;
        final int HEIGHT = 460;
        GE = new GraphicsEngine(WIDTH, HEIGHT -40);
        add(GE);
        levels.add(new Level1());
        setSize(WIDTH, HEIGHT);

        setTitle("Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Sets screen size to maximum
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);

        //rescales contents based on resolution and screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,screenSize.width, screenSize.height);
        setVisible(true);
        GE.repaint(levels.get(currentLevel).getGameState());

    }
    public void turn(){
        levels.get(currentLevel).takeTurn();
        GE.repaint(levels.get(currentLevel).getGameState());
    }
    // takes keyboard inputs
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            if(levels.get(currentLevel).recieveInput(e))
                turn();

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }
    }



    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Game ex = new Game();
            ex.setVisible(true);
        });
    }
}