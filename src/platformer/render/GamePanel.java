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
package platformer.render;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import platformer.main.GameLoop;

/**
 *
 * @author adam
 */
public class GamePanel extends JPanel {

    private GameLoop gl;

    public GamePanel(int WIDTH, int HEIGHT, GameLoop gameLoop, Input input) {
	this.addKeyListener(input);
	setPreferredSize(new Dimension(WIDTH, HEIGHT));
	setFocusable(true);
	setDoubleBuffered(true);

	this.gl = gameLoop;
	
	//TODO addKeyListener
    }

    @Override
    public void paintComponent(Graphics g) {
	g.drawImage(gl.level.getBackgroundImage(), 0, 0, this);
	
	for (int x=0; x<gl.level.getWidth(); x++) {
	    for (int y=0; y<gl.level.getHeight(); y++) {
		if (gl.level.isActivatedBlock(x, y)) {
		    g.drawImage(gl.level.getBlockImage(x, y), x * 32, y * 32, this);
		}
	    }
	}
    }
}
