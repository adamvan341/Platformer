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
import java.io.IOException;
import platformer.entity.Background;
import platformer.entity.Block;

/**
 * Implements everything needed for a stage in the platforming video game
 * including a background, an array of blocks, an array of enemies, and a
 * tile-pack for the blocks.
 *
 * @author adam
 */
public class Level {

    String authorName;// Name of Author
    String levelName;// Name of Level

    public Block[][] block;// Array of blocks (brick, grass, etc)
    Background background;// Background image entity
    // Enemy[] enemy;// Array of entities PLANNED FEATURE
    // Checkpoint[] checkpoint;// Checkpoint array, Player can respawn from these
    TilePack tilePack;// Images available to the block array

    public Level(int height, int width) {
	System.out.println("Height " + height + " Width " + width);
	block = new Block [height][width];
	
	System.out.println("AHeight " + height + " Width " + width);
	tilePack = new TilePack("res/blocks/");
	
	for (int y=0; y<block.length; y++) {
	    for (int x=0; x<block[y].length; x++) {
		block[y][x] = new Block(y * 32, x * 32, tilePack.getImage(1));
	    }
	}

	this.authorName = "DEFAULT_AUTHOR";
	this.levelName = "DEFAULT_LEVEL_NAME";
	try {
	    background = new Background("res/background.png");
	} catch (IOException ex) {
	}
    }

    public Level(int width, int height, String tilePackDir,
	    String backgroundFile, String authorName, String levelName) {
	this(width, height);
	tilePack = new TilePack(tilePackDir);
	try {
	    background = new Background(backgroundFile);
	} catch (IOException ex) {
	}
	this.authorName = authorName;
	this.levelName = levelName;
    }

    public void setAuthorName(String authorName) {
	this.authorName = authorName;
    }

    public String getAuthorName() {
	return authorName;
    }

    public void setLevelName(String levelName) {
	this.levelName = levelName;
    }

    public String getLevelName() {
	return levelName;
    }

    public void activateBlock(int x, int y, BufferedImage image) {
	block[y][x].setImage(image);
	block[y][x].activate();
    }

    public void activateBlock(int x, int y) {
	block[y][x].activate();
    }

    public void deactivateBlock(int x, int y) {
	block[y][x].deactivate();
    }

    public boolean isActivatedBlock(int x, int y) {
	return block[y][x].isActivated();
    }

    public BufferedImage getBlockImage(int x, int y) {
	return block[y][x].getImage();
    }

    public TilePack getTilePack() {
	return tilePack;
    }

    public void setTilePack(TilePack tilePack) {
	this.tilePack = tilePack;
    }

    public int getWidth() {
	return block[1].length;
    }

    public int getHeight() {
	return block.length;
    }

    public BufferedImage getBackgroundImage() {
	return background.getImage();
    }

}
