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
package platformer.entity;

/**
 * Implements everything needed for a stage in the platforming video game
 * including a background, an array of blocks, an array of enemies, and a 
 * tile-pack for the blocks.
 * 
 * @author adam
 */
public class Level {
    Block[][] block;
    Background background;
    Enemy[] enemy;
    Checkpoint checkpoint;
    TilePack tilepack;
    
    public Level() {
        
    }
}
