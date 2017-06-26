package dev.codenmore.tilegame.BDD;
import java.sql.*;
/**
 * Class which assures the connexion which the database
 * @author Vince
 *
 */
public class ConnexionJM {
	
	Connection cnx=connecteurDB();
	
	public static Connection connecteurDB(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver ok");
			String url = "jdbc:mysql://localhost:3308/boulderdash";
			String user = "root";
			String password = "";
			Connection cnx = DriverManager.getConnection(url,user,password);
			System.out.println("connexion bien faite");
			return cnx;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
