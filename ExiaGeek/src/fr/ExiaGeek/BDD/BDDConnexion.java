package fr.ExiaGeek.BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe de connection à la base de donnée.
 * @see {@link BDDExiaGeek} 
 */
public class BDDConnexion {
	private static final String url = "jdbc:mysql://10.162.128.244/exiageek";
	private static final String user = "licorne";
	private static final String passwd = "";
	
	private Connection connection;
	private Statement statement;
	
	/**
	 * Constructeur de la classe 
	 */
	public BDDConnexion() {
		this.connection = null;
		this.statement = null;
	}
	
	/**
	 * Ouverture de la BDD
	 * @return true si la BDD à été correctement ouverte.
	 */
	public Boolean open() {
	   try {
		   Class.forName("com.mysql.jdbc.Driver"); // Chargement du driver MySQL.
		   System.out.println("Le driver à bien été chargé.");

		   Connection conn = DriverManager.getConnection(url, user, passwd);
		   System.out.println("Connexion à la base de donnée effectué.");
	   } catch (Exception e) { e.printStackTrace(); } 
	   return true;
	}
	
	/**
	 * Fermeture de la BDD
	 */
	public void close() {
		try {
			this.connection.close();
			this.statement.close();
		}catch(SQLException e) { e.printStackTrace(); }
	}	
	
	public void insertTest() {
		//BDDExiaGeek.getQueryInsert();
		Statement statement = (Statement) conn.createStatement();
		statement.executeUpdate("INSERT INTO `partie` (`Score`, `PV_PosteDeTravail`, `PO`, `ID_Carte`)   VALUES ('"+ 123 +"', '"+ 250 +"', '"+ 7895 +"', '"+ 1 +"')");
	}
}
