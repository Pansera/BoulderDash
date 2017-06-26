package dev.codenmore.tilegame.BDD;
/**
 * Class which convert .txt in int
 * @author Vince
 *
 */
public class ConvertTXTtoInt {
	
	int[][] map1;
	
	public int[][] txtToInt(String Map, int Width_Map, int Height_Map){

		Map = Map.replaceAll(System.getProperty("line.separator"), " ");

		String[] tableau = Map.split(" ");
		
		//Map.replace('\n', ' ');
		//String cells[] = lines[0].split(" ");
		map1 = new int[Height_Map][Width_Map];
		
		for(int i = 0; i<(Width_Map * Height_Map); ++i){
			int jj = i%Width_Map;
			int ii = i/Width_Map;
			map1[ii][jj] = Integer.parseInt(tableau[i]);

			

		}

		
		/*for(int j=0; j<Height_Map; j++){
			for(int k=0; k<Width_Map; k++){
				System.out.print(map[j][k]);
			}
			System.out.println("");
		}*/
		return map1;
	}

	public int[][] getMap() {
		return map1;
	}
	
	

}