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
        final int WIDTH = (int)(screenSize.width *.9);
        final int HEIGHT = (int)(screenSize.height * .9);
        GE = new GraphicsEngine(HEIGHT, HEIGHT );
        add(GE);



        setTitle("Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        //setLocation((int)((screenSize.width/2)-(screenSize.height/2)),0);

        //Sets screen size to maximum
       // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);


        //rescales contents based on resolution and screen size

        setBounds((int)((screenSize.width/2)-(HEIGHT/2)),(int)(screenSize.height*.025),HEIGHT, HEIGHT);

        setVisible(true);


    }





    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Game ex = new Game();
            ex.setVisible(true);
        });
    }
}