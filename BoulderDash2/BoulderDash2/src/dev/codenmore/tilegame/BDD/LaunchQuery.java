package dev.codenmore.tilegame.BDD;

public class LaunchQuery {


	public static int[][] mapUse;
	int width_Map, height_Map;
	public static String Map;
				
	public int[][] callDB(int idMap){
		
		
			// - - - Pour la BDD - - - //
			ReadDB db = new ReadDB();
			db.read(idMap);
			height_Map = db.getHeight_Map();
			width_Map = db.getWidth_Map();
			
			//public  int GrassXO = db.getGrassX;
		

			//String map = db.getMap();

			Map = db.getMap();
			System.out.println(height_Map);
			System.out.println(width_Map);

			//System.out.println(mapUse);


			ConvertTXTtoInt txtInt = new ConvertTXTtoInt();
			txtInt.txtToInt(Map, width_Map, height_Map);
			mapUse = txtInt.getMap();
			//System.out.println("mapUse");
			return mapUse;
			

			}


	public int getWidthMap(){
		return width_Map;
	}
	public int getHeightMap(){
		return height_Map;
	}
	public int[][] getMapUse(){
		return mapUse;
	}
	public String getMap(){
		return Map;
	}
}