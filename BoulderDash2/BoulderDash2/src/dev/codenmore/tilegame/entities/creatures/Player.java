package dev.codenmore.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;
/**
 * Class which manage the behavior of the player
 * @author Vince
 *
 */
public class Player extends Creature {

	//Animations
	private Animation animDown, animUp, animLeft, animRight, animKill, animWin, animStay;
	
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 4;  //4
		bounds.y = 2;  //25
		bounds.width = 31;  //32
		bounds.height = 37;  //16
		
		//Animations
		animStay = new Animation(200, Assets.player_stay);
		animDown = new Animation(200, Assets.player_down);
		animUp = new Animation(200, Assets.player_up);
		animLeft = new Animation(200, Assets.player_left);
		animRight = new Animation(200, Assets.player_right);
		animKill = new Animation(200, Assets.player_kill);
		animWin = new Animation(200, Assets.player_win);
	}

	@Override
	public void tick() {
		//Animations 
		animStay.tick();
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		animKill.tick();
		animWin.tick();
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);     
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up){
			yMove = -speed;}
		if(handler.getKeyManager().down){
			yMove = speed;}
		if(handler.getKeyManager().left){
			xMove = -speed;}
		if(handler.getKeyManager().right){
			xMove = speed;}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		/*g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
		           (int) (y + bounds.y - handler.getGameCamera().getyOffset()), 
		           bounds.width, bounds.height);*/
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			return animLeft.getCurrentFrame();
		}else if(xMove > 0){
			return animRight.getCurrentFrame();
		}else if(yMove < 0){
			return animUp.getCurrentFrame();
		}else if (yMove > 0){
			return animDown.getCurrentFrame();
		}else{
			return animStay.getCurrentFrame();
		}
		
	}

}
