package Engines;


import Characters.Thing;
import Levels.*;

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
    int currentLevel = 5;

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
        levels.add(new End());
        levels.add(new Opening());
        levels.add(new Level1());
        levels.add(new WalkToClass());
        levels.add(new Level2());
        levels.add(new HomeTransition());
        levels.add(new Level3());
        levels.add(new Winning());
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
        if(GS.stressBar) {
            gi.setColor(Color.lightGray);
            gi.fillRect(7 * 16 - 5, 28 * 16 - 20, 40,20);
            gi.fillRect(7 * 16 - 5, 28 * 16 - 3 , 250, 20);
            gi.setColor(Color.black);
            gi.drawString("Stress:",7 * 16 - 5, 28 * 16 - 6 );
            gi.setColor(Color.green);

            gi.fillRect(7 * 16 + 3, 28 * 16, (int)(234 * ((double)GS.seb.currentStress /(double) GS.seb.maxStress)), 16);
            gi.drawImage(stressBar, 7 * 16, 28 * 16, 240, 16, null);
        }
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
            if (stress == 100)
            {
                this.currentLevel = 0;
                GS = levels.get(currentLevel).getGameState();
            }
            else if (currentLevel == 7)
            {
                this.currentLevel = 1;
                GS = levels.get(currentLevel).getGameState();
            }
            else
            {
                this.currentLevel++;
                GS = levels.get(currentLevel).getGameState();
            }
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