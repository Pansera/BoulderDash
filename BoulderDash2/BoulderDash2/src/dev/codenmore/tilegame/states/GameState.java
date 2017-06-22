package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.worlds.World;

public class GameState extends State {
	
	//private Player player;
	private World world;
	//private Grass grass;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt"); 
		handler.setWorld(world);
		//player = new Player(handler, 40, 117);
		//grass = new Grass(handler, 100, 100);
		  
	}
	
	@Override
	public void tick() {
		world.tick();
		//player.tick();
		//grass.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		//player.render(g);
		//grass.render(g);
	}

}
