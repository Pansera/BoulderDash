package dev.codenmore.tilegame.displayTest;

import static org.junit.Assert.*;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import org.junit.Test;

public class DisplayTest {
	
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width;
	private int height;

	@Test
	public void createDisplayTest() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
	@Test	
	public void displayTest(){
		String title = "titre";
		int width = 15;
		int height = 15;
		
		createDisplayTest();

	}
}
