import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;


public class Game extends JFrame {
    ArrayList<Level> levels = new ArrayList<Level>();

    private Game() {

        initUI();
    }

    private void initUI() {
        final int WIDTH = 700;
        final int HEIGHT = 460;

        add(new GraphicsEngine(WIDTH, HEIGHT -40));

        setSize(WIDTH, HEIGHT);

        setTitle("Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    // takes keyboard inputs
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {

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