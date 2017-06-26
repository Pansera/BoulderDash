package dev.codenmore.tilegame.entities.statics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;
/**
 * Class which manage the static entities
 * @author Vince
 *
 */
public abstract class StaticEntity extends Entity{

	public StaticEntity(Handler handler, float x, float y, int width, int height){
		super(handler, x, y, width, height);
	}
	
}
