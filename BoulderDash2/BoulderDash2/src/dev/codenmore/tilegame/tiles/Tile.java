package dev.codenmore.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	/**
	 * Class which define the behavior of the tiles
	 */
	//STATIC STUFF HERE 
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new VioletTile(2);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile rocktile = new RockTile(3);
	public static Tile diamondTile = new DiamondTile(4);
	public static Tile yellowTile = new YellowTile(5);
	public static Tile holeTile = new HoleTile(0);
	
	//CLASS
	
	public static final int TILEWIDTH = 40, TILEHEIGHT = 40;
	
	public BufferedImage texture;
	protected int id;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}

	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}
	public void setId(int id)
	{

		this.id = id;
		System.out.println(id);
	}


	}
