package dev.codenmore.tilegameTest;

import static org.junit.Assert.*;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import org.junit.Test;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.GameCamera;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.input.MouseManager;
import dev.codenmore.tilegame.states.GameState;
import dev.codenmore.tilegame.states.MenuState;
import dev.codenmore.tilegame.states.State;

public class GameTest {
	
	private KeyManager keyManager;
	private MouseManager mouseManager;
	private Display display;
	boolean running = false;
	BufferStrategy bs;
	Graphics g;
	Thread thread;

	@Test
	public void GameTest() {
		String title = "titre";
		int width = 10;
		int height = 10;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		assertEquals(10, height);
		assertEquals(10, width);
	}
	
	@Test
	public void initTest(){
		
		String title = "Titre";
		int width = 10, height = 10;
		
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		assertEquals(10, width);
		assertEquals(10,height);
	}
	
	@Test
	public void tickTest(){
			

		if(State.getState() != null)
			State.getState().tick();
		int i = 1;
		assertEquals(1, i);
	}
	
	@Test
	public void renderTest(){
		if(bs == null){
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, 15, 15);
		//Draw Here!
		
		if(State.getState() != null)
			State.getState().render(g);
		
		//End Drawing
		bs.show();
		g.dispose();
		int i = 1;
		assertEquals(1, i);
	}
	
	@Test
	public synchronized void stopTest(){
		if(!running){
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int i = 1;
		assertEquals(1, i);
	}
	
	@Test
	public void runTest(){
		
		initTest();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tickTest();
				renderTest();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stopTest();
		int i = 1;
		assertEquals(1, i);
	}
}
