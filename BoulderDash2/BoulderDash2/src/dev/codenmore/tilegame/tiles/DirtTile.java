package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class DirtTile extends Tile{
	/** 
	 * Class which define the specs of the dirt tile
	 * @param id
	 */
	public int x, y;
	
	public DirtTile(int id) {
		super(Assets.dirt, id);
	}
	@Override
	public boolean isSolid(){
		return true;
	}
}
