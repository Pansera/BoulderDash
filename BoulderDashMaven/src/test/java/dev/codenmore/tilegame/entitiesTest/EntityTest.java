package dev.codenmore.tilegame.entitiesTest;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Test;

public class EntityTest {
	
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	public static final int DEFAULT_HEALTH = 1;
	protected int health;

	protected boolean active = true;
	
	@Test
	public void hurtTest() {
		int amnt = 1;
		if(amnt < 0){
			active = false;
		assertTrue(active = true);
	}
	}
	
	@Test
	public void EntityTest(){
		x = 5;
		y = 5;
		width = 20;
		height = 22;
		health = DEFAULT_HEALTH;
		bounds = new Rectangle(0, 0, width, height);
	}
}
