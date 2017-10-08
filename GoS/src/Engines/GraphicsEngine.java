package Engines;


import Characters.Thing;
import Levels.Level;
import Levels.Level1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GraphicsEngine extends JPanel  {
    ArrayList<Level> levels = new ArrayList<Level>();
    int currentLevel = 0;

    BufferedImage bi;
    Graphics gi;
    private boolean ingame;
    private int WIDTH;
    private int HEIGHT;
    private final int DELAY = 30;
    private int scroll = 0;
    GameState GS ;
    public GraphicsEngine(int width, int height) {
        levels.add(new Level1());
        GS = levels.get(currentLevel).getGameState();
        WIDTH = width;
        addKeyListener(new TAdapter());
        HEIGHT = height;
        bi = new BufferedImage(30*16,30*16,BufferedImage.TYPE_INT_RGB);
        gi = bi.createGraphics();
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
        gi.setColor(Color.white);
        gi.fillRect(0,0,30*18,30*18);
        //g.drawImage(img, x,y,width, height, null);
        gi.setColor(Color.black);
        gi.drawRect(100,100,100,100);
        for(Thing t: GS.things){
            gi.drawRect(t.x*16,t.y*16,16,16);
            t.draw(gi);
        }
        // JUST SCALE THE BUFFERED IMAGE DRAW
        g.drawImage(bi,0,0,WIDTH, HEIGHT, null);
    }

    // takes keyboard inputs
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
        }
        @Override
        public void keyPressed(KeyEvent e) {

            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                System.exit(0);
            }
            if(levels.get(currentLevel).recieveInput(e))
                turn();
        }
    }
    public void turn(){
        levels.get(currentLevel).takeTurn();
        repaint(levels.get(currentLevel).getGameState());
        repaint();
    }

}