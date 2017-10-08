package Engines;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GraphicsEngine extends JPanel  {

    private boolean ingame;
    private int WIDTH;
    private int HEIGHT;
    private final int DELAY = 30;
    private int scroll = 0;
    GameState GS;
    public GraphicsEngine(int width, int height) {
        WIDTH = width;
        HEIGHT = height;
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public void repaint(GameState GS){
        this.GS = GS;
        repaint();
    }
    // main draw
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLevel(g);
        Toolkit.getDefaultToolkit().sync();
    }

    //  draws all of the things
    private void drawLevel(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,WIDTH,HEIGHT);
        //g.drawImage(img, x,y,width, height, null);

    }



}