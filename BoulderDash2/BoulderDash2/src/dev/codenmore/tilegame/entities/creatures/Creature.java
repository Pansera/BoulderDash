package dev.codenmore.tilegame.entities.creatures;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;
import dev.codenmore.tilegame.tiles.Tile;
/**
 * Class which manage the behavior of all the creatures
 * @author Vince
 *
 */
public abstract class Creature extends Entity{
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 40,
			                DEFAULT_CREATURE_HEIGHT = 40;
	

	protected int health;
	protected float speed;
	protected float xMove, yMove;
	public int nbDiamond;
	public int nbDiamondMax=15;
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	public void move(){
		moveX();
		moveY();
	}
	
	protected void moveRock(){

    }

    protected void checkRock(int txRock, int tyRock){
        // Verification si une pierre doit tomber
        // Check num 1 : Verifier si la tile supperieur est une pierre
        // Si tile supperieur n'est pas une pierre : alors on break
        // Si tile supperieur est une pierre : alors on deplace la pierre jusqu'a la prochaine position possible

        int tyRockInitial = tyRock;

        int txUnderRock = txRock;
        int tyUnderRock = (int) ((y + yMove + bounds.y) / Tile.TILEHEIGHT);


        if(digDirt(txRock, tyRock)==3){
            // Bouger la pierre jusqu'a nouvelle position possible

            while(digDirt(txUnderRock, tyUnderRock)==0){
                handler.getWorld().changeType(txRock, tyRock, 0);
                handler.getWorld().changeType(txUnderRock, tyUnderRock, 3);
                tyRock = tyUnderRock;
                tyUnderRock = tyRock + 1;
            }

            checkRock(txRock, tyRockInitial - 1);

        }
    }
	
	public void moveX(){
		if(xMove > 0){   //Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				if(digDirt(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)==1||digDirt(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)==4)
				{
					if(digDirt(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)==4)
					{
					nbDiamond++;
					System.out.println(nbDiamond+" diamants récupérés sur "+nbDiamondMax);
					if(nbDiamond==nbDiamondMax)
					{
						System.out.println("Vous avez récupéré tous les diamants");
						System.exit(0);
					}}
					handler.getWorld().changeType(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT, 0);
					checkRock(tx,(int) ((y + yMove + bounds.y) / Tile.TILEHEIGHT) - 1);


				}
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
			
		}else if(xMove < 0){  //Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
			x += xMove;
			}else{
				if(digDirt(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)==1||digDirt(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)==4)
				{
					if(digDirt(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)==4)
					{
					nbDiamond++;
					System.out.println(nbDiamond+" diamants récupérés sur "+nbDiamondMax);
					if(nbDiamond==nbDiamondMax)
					{
						
						System.out.println("Vous avez récupéré tous les diamants");
						System.exit(0);
					}
					}
					handler.getWorld().changeType(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT, 0);
					checkRock(tx,(int) ((y + yMove + bounds.y) / Tile.TILEHEIGHT) - 1);

				}
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
	}
	
	public void moveY(){
		if(yMove < 0){   //Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				if(digDirt((int) (x + bounds.x) / Tile.TILEWIDTH, ty)==1||digDirt((int) (x + bounds.x) / Tile.TILEWIDTH, ty)==4)
				{
					if(digDirt((int) (x + bounds.x) / Tile.TILEWIDTH, ty)==4)
					{
					nbDiamond++;
					System.out.println(nbDiamond+" diamants récupérés sur "+nbDiamondMax);
					if(nbDiamond==nbDiamondMax)
					{
						System.out.println("Vous avez récupéré tous les diamants");
						System.exit(0);
					}}
					handler.getWorld().changeType((int) (x + bounds.x) / Tile.TILEWIDTH, ty, 0);
					int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
                    checkRock(tx,ty- 1);

				}
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
			
		}else if(yMove > 0){  //Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
				
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;

			}else{
				if(digDirt((int) (x + bounds.x) / Tile.TILEWIDTH, ty)==1||digDirt((int) (x + bounds.x) / Tile.TILEWIDTH, ty)==4)
				{
					if(digDirt((int) (x + bounds.x) / Tile.TILEWIDTH, ty)==4)
					{
					nbDiamond++;
					System.out.println(nbDiamond+" diamants récupérés sur "+nbDiamondMax);
					if(nbDiamond==nbDiamondMax)
					{

						System.out.println("Vous avez récupéré tous les diamants");
						System.exit(0);
					}}
					handler.getWorld().changeType((int) (x + bounds.x) / Tile.TILEWIDTH, ty, 0);

				}
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;

			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();
	}
	protected int digDirt(int x, int y){
		return handler.getWorld().getTile(x,y).getId();
	}
	//GETTERS SETTERS
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
