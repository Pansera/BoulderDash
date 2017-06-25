package dev.codenmore.tilegame.BDD;

import java.sql.*;

public class ReadDB {
	
	//public static int salut = 10;

	String map;
	int ID_Map, Width_Map, Height_Map;
	
	public void read(int id_map) {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String connectionUrl = "jdbc:mysql://localhost:3308/boulderdash";
		String connectionUser = "root";
		String connectionPassword = "";
		conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * FROM map WHERE `ID_Map` =" + id_map);
		while (rs.next()) {
			ID_Map = rs.getInt("ID_Map");
			Width_Map = rs.getInt("Width_Map");
			Height_Map = rs.getInt("Height_Map");

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


}
