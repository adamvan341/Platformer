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

import java.util.Random;
import javax.swing.JFrame;
import platformer.level.Level;
import platformer.render.GamePanel;
import platformer.render.Input;

/**
 *
 * @author adam
 */
public class GameLoop implements Runnable {

    boolean gameRunning = true;// Tests if the game is running

    private GamePanel gPanel;// Graphics are drawn on the game panel
    private Input input;// Handles mouse and keyboard input
    public Level level;

    public GameLoop() {
	GameState.setGameState(GameState.PLAY_STATE);
	
	gPanel = new GamePanel(640, 480, this, input);
	level = new Level(15, 200);
	
	Random r = new Random();
	for (int x=0; x<level.getWidth(); x++) {
	    for (int y=0; y<level.getHeight(); y++) {
		if (r.nextBoolean()) {
		    level.activateBlock(x, y);
		}
	    }
	}
	
	JFrame frame = new JFrame("Platformer");
	frame.setContentPane(gPanel);
	frame.pack();
	frame.setResizable(false);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
    }

    /**
     * Updates the game logic on a per frame basis.
     */
    public void update() {

    }

    /**
     * Opens a game-loop which constantly updates the screen contents and the
     * game logic.
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
	    gPanel.repaint();

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
