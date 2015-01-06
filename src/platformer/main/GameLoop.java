/*
 * Copyright (C) 2014 Adam Vanderneut
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package platformer.main;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import platformer.entity.Block;
import platformer.entity.Entity;
import platformer.render.GamePanel;

/**
 *
 * @author adam
 */
public class GameLoop implements Runnable {
    boolean gameRunning = true;// Tests if the game is running
    
    GamePanel gp;// Graphics are drawn on the game panel
    public Entity[] e;// A list of all entities in the game
    
    public GameLoop() {
        gp = new GamePanel(640, 480, this);
        e = new Entity[24];
        
        for (int x=0; x<e.length; x++) {
            try {
                e[x] = new Block((float) Math.random()*640, (float)Math.random()*480,
                        ImageIO.read(new File("res/blocks/dirt.png")));
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
        
        JFrame frame = new JFrame("Platformer");
        
        frame.setContentPane(gp);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    /**
     *  Updates the game logic on a per frame basis.
     */
    public void update() {
        
    }

    /**
     *  Opens a gameloop which constantly updates the screen contents and the
     *  game logic.
     */
    @Override
    public void run() {
        long beforeTime;// Time before updating game logic
        long afterTime; // Time after updating game logic
        long deltaTime; // Time between two time checks
        long sleepTime; // Time to rest until next refresh
        final long OPTIMAL_TIME = 1000 / 60;
        
        while (true) {
            beforeTime = System.currentTimeMillis();
            
            update();
            gp.repaint();
            
            // Calculate how long the thread can sleep
            afterTime = System.currentTimeMillis();
            deltaTime = afterTime - beforeTime;
            sleepTime = OPTIMAL_TIME - deltaTime;
            // Sleep
            try {
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }
    }
    
}
