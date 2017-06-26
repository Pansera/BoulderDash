package dev.codenmore.tilegame.BDD;

import java.sql.*;

public class ReadDB {
	

	
	public int batman = 12;
	public static  int GrassX;
	public static int GrassY;
	public static int VioletX;
	public static int VioletY;
	public static int StoneX;
	public static int StoneY;
	public static int DiamondX;
	public static int DiamondY;
	public static int HoleX;
	public static int HoleY;
	
	
	String map;
	int ID_Map, Width_Map, Height_Map;
	
	public void read(int id_map) {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String connectionUrl = "jdbc:mysql://localhost:3306/boulderdash";
		String connectionUser = "root";
		String connectionPassword = "";
		conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * FROM gfx,map WHERE Id_Map=1 AND ID_Map1 =1");
		while (rs.next()) {
			//ID_Map = rs.getInt("ID_Map");
			Width_Map = rs.getInt("Width_Map");
			Height_Map = rs.getInt("Height_Map");
			
			GrassX = rs.getInt("GrassX");
			GrassY = rs.getInt("GrassY");
			VioletX = rs.getInt("VioletX");
			VioletY = rs.getInt("VioletY");
			StoneX = rs.getInt("StoneX");
			StoneY = rs.getInt("StoneY");
			DiamondX = rs.getInt("DiamondX");
			DiamondY = rs.getInt("DiamondY");
			HoleX = rs.getInt("HoleX");
			HoleY = rs.getInt("HoleY");
			

			
			map = rs.getString("Map");
			//map = test.toCharArray();
			/*System.out.println("ID_Map: " + ID_Map + ", Width_Map: " + Width_Map
					+ ", Height_Map: " + Height_Map+ ", PosX_Player "+ PosX_Player +", PosY_Player "+ PosY_Player + ", Map : \n"+ map);
		*/}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
		try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
	}

}
	//-----------Getter----------//
	
	public String getMap() {
		return map;
	}
	
	public int getID_Map() {
		return ID_Map;
	}

	public int getWidth_Map() {
		return Width_Map;
	}

	public int getHeight_Map() {
		return Height_Map;
	}

	public int getGrassX(){
		return GrassX;
	}

}
