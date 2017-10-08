package Engines;


import Characters.Thing;
import Levels.Level;
import Levels.Level1;
import Levels.Level2;
import Levels.Opening;

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
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GraphicsEngine extends JPanel implements ActionListener{
    ArrayList<Level> levels = new ArrayList<Level>();
    int currentLevel = 0;

    BufferedImage bi;
    Graphics gi;
    //private boolean ingame;
    private int WIDTH;
    private int HEIGHT;
    private final int DELAY = 30;
    private int scroll = 0;
    GameState GS ;
    Timer timer;
    Image stressBar;

    public GraphicsEngine(int width, int height) {
        levels.add(new Opening());
        levels.add(new Level1());
        levels.add(new Level2());
        GS = levels.get(currentLevel).getGameState();
        WIDTH = width;
        addKeyListener(new TAdapter());
        HEIGHT = height;
        bi = new BufferedImage(30 * 16, 30 * 16, BufferedImage.TYPE_INT_RGB);
        gi = bi.createGraphics();
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        stressBar = (new ImageIcon(this.getClass().getResource("/Characters/resources/stressbar.png"))).getImage();
        timer = new Timer(60, this);
        timer.start();
    }

//    public void repaint(GameState GS){
//        this.GS = GS;
//        repaint();
//    }

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
        gi.fillRect(0, 0, 30 * 16, 30 * 16);
        gi.drawImage(GS.background, 0,0,30*16, 30*16, null);

        Thing[][] things = GS.things;
        for (int i = 0; i < things.length; i++) {
            for (int j = 0; j < things[0].length; j++) {
                if (things[i][j] != null)
                    things[i][j].draw(gi, i, j);
            }
        }
        GS.seb.draw(gi);
        gi.setColor(Color.green);
        gi.fillRect(7*16+3, 28*16, GS.seb.currentStress, 16);
        gi.drawImage(stressBar, 7*16, 28*16, 240, 16, null);
        // JUST SCALE THE BUFFERED IMAGE DRAW
        g.drawImage(bi, 0, 0, HEIGHT, HEIGHT, this);
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
            if(levels.get(currentLevel).receiveInput(e))
                turn();
        }
    }
    public void turn(){
        GS=levels.get(currentLevel).takeTurn();
        if(GS.nextLevel == true){
            int stress = GS.seb.currentStress;
            this.currentLevel++;
            GS = levels.get(currentLevel).getGameState();
            GS.seb.currentStress = stress;
        }
       // repaint(GS);
        repaint();
    }

    // update function
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}