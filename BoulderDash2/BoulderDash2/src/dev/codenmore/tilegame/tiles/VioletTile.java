package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class VioletTile extends Tile{
	/** 
	 * Class which define the specs of the violet tile
	 * @param id
	 */
	public VioletTile(int id) {
		super(Assets.violet, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
