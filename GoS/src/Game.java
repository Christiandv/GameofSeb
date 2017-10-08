import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
import Engines.*;
import Levels.*;



public class Game extends JFrame{

    GraphicsEngine GE;

    private Game() {

        initUI();
    }

    private void initUI() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int WIDTH = screenSize.width;
        final int HEIGHT = screenSize.height;
        GE = new GraphicsEngine(WIDTH, HEIGHT );
        add(GE);



        setTitle("Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Sets screen size to maximum
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);


        //rescales contents based on resolution and screen size

        setBounds(0,0,screenSize.width, screenSize.height);

        setVisible(true);


    }





    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Game ex = new Game();
            ex.setVisible(true);
        });
    }
}