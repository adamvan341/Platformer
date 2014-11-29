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
import platformer.entity.Entity;

/**
 *
 * @author adam
 */
public class GamePanel extends JPanel {

    public GamePanel(int WIDTH, int HEIGHT) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        setDoubleBuffered(true);
        //TODO addKeyListener
    }
    
    public void paintComponent(Graphics g, Entity[] e) {
        super.paintComponent(g);
        
        for (Entity ce : e) {
            g.drawImage(ce.getImage(), (int)ce.getXPos(), (int)ce.getYPos(), 
                    (int)ce.getWidth(), (int)ce.getHeight(), this);
        }
    }
    @Override
    public void repaint() {
        super.repaint();
    }
}
