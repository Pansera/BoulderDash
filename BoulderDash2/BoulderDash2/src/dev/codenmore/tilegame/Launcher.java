package dev.codenmore.tilegame;

import dev.codenmore.tilegame.BDD.LaunchQuery;
//import dev.codenmore.tilegame.BDD.ConnexionJM;

public class Launcher {

	//public LaunchQuery lq;
	//public ConnexionJM cj;
	
	public static void main(String[] args) {
		Game game = new Game("Tile Game", 600, 600);
		//ConnexionJM cj = new ConnexionJM();
		//LaunchQuery lq = new LaunchQuery();
		//lq.callDB(1);
		
		//START GAME
		game.start();

	}

}
