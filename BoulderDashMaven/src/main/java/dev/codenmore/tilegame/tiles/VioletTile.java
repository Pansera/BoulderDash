package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class VioletTile extends Tile{

	public VioletTile(int id) {
		super(Assets.violet, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
