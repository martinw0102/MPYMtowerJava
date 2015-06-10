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
	
	private Connection conn;
	private Statement statement;
	
	/**
	 * Constructeur de la classe 
	 */
	public BDDConnexion() {
		this.conn = null;
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

		   this.conn = DriverManager.getConnection(url, user, passwd);
		   this.statement = (Statement) this.conn.createStatement();
		   System.out.println("Connexion à la base de donnée effectué.");   
	   } catch (Exception e) { e.printStackTrace(); } 
	   return true;
	}
	
	/**
	 * Fermeture de la BDD
	 */
	public void close() {
		try {
			this.conn.close();
			this.statement.close();
		}catch(SQLException e) { e.printStackTrace(); }
	}

	private int executeUpdate(final String updateQuery) {
		try {
			return this.statement.executeUpdate(updateQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void insertTest() {
		executeUpdate(BDDExiaGeek.getQueryInsert());
		System.out.println("Insertion effectue");
		
		//statement.executeUpdate("INSERT INTO `partie` (`Score`, `PV_PosteDeTravail`, `PO`, `ID_Carte`)   VALUES ('"+ 123 +"', '"+ 250 +"', '"+ 7895 +"', '"+ 1 +"')");
	}
}
