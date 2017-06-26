package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class RockTile extends Tile{
	/** 
	 * Class which define the specs of the rock tile
	 * @param id
	 */
	public RockTile(int id) {
		super(Assets.stone, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
