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
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import platformer.entity.Background;
import platformer.entity.Entity;
import platformer.main.GameLoop;

/**
 *
 * @author adam
 */
public class GamePanel extends JPanel {
    
    private GameLoop gl;
    private Background bg;
    
    public GamePanel(int WIDTH, int HEIGHT, GameLoop gameLoop) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        setDoubleBuffered(true);
        
        this.gl = gameLoop;
        try {
            bg = new Background(ImageIO.read(new File("res/background.png")));
            
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //TODO addKeyListener
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg.getImage(), 0, 0, this);
        
        for (Entity ce : gl.e) {
            g.drawImage(ce.getImage(), (int)ce.getXPos(), (int)ce.getYPos(), 
                    (int)ce.getWidth(), (int)ce.getHeight(), this);
        }
    }
}
