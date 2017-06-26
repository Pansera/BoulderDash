package dev.codenmore.gfxTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameCameraTest {
	private float xOffset, yOffset;

	@Test
	public void moveTest() {
		float xAmt = 0;
		float yAmt = 0;
		xOffset += xAmt;
		yOffset += yAmt;
		assertEquals(xOffset, xAmt, 1);
		assertEquals(yOffset, yAmt, 1);
		
		xAmt = -1;
		yAmt = -1;
		xOffset += xAmt;
		yOffset += yAmt;
		assertEquals(xOffset, xAmt, 1);
		assertEquals(yOffset, yAmt, 1);
		
		
		xAmt = 1;
		yAmt = 1;
		xOffset += xAmt;
		yOffset += yAmt;
		assertEquals(xOffset, xAmt, 1);
		assertEquals(yOffset, yAmt, 1);
	}

}
