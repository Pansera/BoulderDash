package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;
import dev.codenmore.tilegame.BDD.ReadDB;



public class Assets {
	
	


	private static final int width = 16, height = 16;
	
	public static BufferedImage dirt, stone, violet, diamond, yellow, hole, grass;
	public static BufferedImage [] player_down, player_up, player_left, player_right, player_kill, player_win, player_stay;
	public static BufferedImage [] btn_start;
	
	public static void init(){
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/player/boutton.png"));
		
	
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet2.crop(width * 4, height * 2, width * 2, height);
		btn_start[1] = sheet2.crop(width * 4, height * 3, width * 2, height);
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteDecor.png"));
		
		dirt = sheet.crop(width * ReadDB.GrassX, height * ReadDB.GrassY, width, height);
		violet = sheet.crop(width * ReadDB.VioletX, height * ReadDB.VioletY, width, height);
		stone = sheet.crop(width * ReadDB.StoneX, height * ReadDB.StoneY, width, height);
		diamond = sheet.crop(width * ReadDB.DiamondX, height * ReadDB.DiamondY, width, height);
		yellow = sheet.crop(width, height * 8, width, height);
		hole = sheet.crop(width * ReadDB.HoleX, height * ReadDB.HoleY, width, height);
		grass = sheet.crop(width, height * 12, width, height);
		
		SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/player/74336T.png"));
		
		player_down = new BufferedImage[5];
		player_up = new BufferedImage[5];
		player_left = new BufferedImage[4];
		player_right = new BufferedImage[4];
		player_kill = new BufferedImage[2];
		player_win = new BufferedImage[2];
		player_stay = new BufferedImage[2];
		
		player_stay[0] = sheet1.crop(0, 0, width, height);
		player_stay[1] = sheet1.crop(width, 0, width, height);
		player_down[0] = sheet1.crop(0, height * 4, width, height);
		player_down[1] = sheet1.crop(width, height * 4, width, height);
		player_down[2] = sheet1.crop(width * 2, height * 4, width, height);
		player_down[3] = sheet1.crop(width * 3, height * 4, width, height);
		player_down[4] = sheet1.crop(0, height * 4, width, height);
		player_up[0] = sheet1.crop(0, height * 2, width, height);
		player_up[1] = sheet1.crop(width, height * 2, width, height);
		player_up[2] = sheet1.crop(width * 2, height * 2, width, height);
		player_up[3] = sheet1.crop(width * 3, height * 2, width, height);
		player_up[4] = sheet1.crop(0, height * 2, width, height);
		player_left[0] = sheet1.crop(0, height, width, height);
		player_left[1] = sheet1.crop(width, height, width, height);
		player_left[2] = sheet1.crop(width * 2, height, width, height);
		player_left[3] = sheet1.crop(0, height, width, height);
		player_right[0] = sheet1.crop(0, height * 3, width, height);
		player_right[1] = sheet1.crop(width, height * 3, width, height);
		player_right[2] = sheet1.crop(width * 2, height * 3, width, height);
		player_right[3] = sheet1.crop(0, height * 3, width, height);
		player_kill[0] = sheet1.crop(width * 4, 0, width, height);
		player_kill[1] = sheet1.crop(width * 5, 0, width, height);
		player_win[0] = sheet1.crop(width * 4, height, width, height);
		player_win[1] = sheet1.crop(width * 4, height, width, height);
	}
	
}
