/*
 * Copyright (C) 2015 adam
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
package platformer.level;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author adam
 */
public class TilePack {
    String tilePackDir;
    BufferedImage[] image;
    
    /**
     * Takes specified directory and imports every 
     * image found there into an array
     * @param tilePackDirectory 
     */
    public TilePack(String tilePackDirectory) {
        File[] files = new File(tilePackDirectory).listFiles();
        image = new BufferedImage[files.length];
        for (int x=0; x<files.length; x++) {
            try {
                image[x] = ImageIO.read(files[x]);
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
    
    public BufferedImage[] getAllImages() {
	return this.image;
    }
    
    public BufferedImage getImage(int index) {
	return image[index];
    }
}
