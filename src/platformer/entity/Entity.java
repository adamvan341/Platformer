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
package platformer.entity;

import java.awt.image.BufferedImage;

/**
 *
 * @author adam
 */
abstract public class Entity {
    
    protected float xPos, yPos;
    protected float width, height;
    protected BufferedImage image;
    
    public Entity(float xPos, float yPos, float width, float height, BufferedImage image) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.image = image;
    }
    
    public final float getXPos() {
        return xPos;
    }
    
    public final float getYPos() {
        return yPos;
    }
    
    public final float getWidth() {
        return width;
    }
    
    public final float getHeight() {
        return height;
    }
    
    public final BufferedImage getImage() {
        return image;
    }
}
