package dev.codenmore.tilegame.entitiesTest;

import static org.junit.Assert.*;

import java.awt.Graphics;
import java.util.ArrayList;

import org.junit.Test;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;
import dev.codenmore.tilegame.entities.creatures.Player;

public class EntityManagerTest {
	
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	private Entity e;
	private Graphics g;

	@Test
	public void EntityManagerTest() {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
	}
}
