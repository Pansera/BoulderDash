package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class DirtTile extends Tile{
	
	public int x, y;
	
	public DirtTile(int id) {
		super(Assets.dirt, id);
	}

}
