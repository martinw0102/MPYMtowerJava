package fr.ExiaGeek.BDD;

import fr.ExiaGeek.Partie;
import fr.ExiaGeek.Case.Chemin;
import fr.ExiaGeek.Case.PosteDeTravail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

	private ResultSet executeQuery(final String query) {
		try {
			return this.statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private int executeUpdate(final String updateQuery) {
		try {
			return this.statement.executeUpdate(updateQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<Chemin> selectChemin(ArrayList<Chemin> chemin) {
		ResultSet resultSet = this.executeQuery(BDDExiaGeek.getQuerySelectChemin(1));
		try {
			for (; resultSet.next() ;) {
				chemin.add(new Chemin(resultSet.getInt("X_Chemin"), resultSet.getInt("Y_Chemin")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chemin;
	}
	
	public int selectXPT(int x){
		try{
			ResultSet resultSet = this.executeQuery(BDDExiaGeek.getQuerySelectCoord(1));
			x = resultSet.getInt("X_PosteDeTravail");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
	
	public int[] selectCoordSpawn(int[] coord)
	{
		try{
			ResultSet resultSet = this.executeQuery(BDDExiaGeek.getQuerySelectCoord(1));
			coord[0] = resultSet.getInt("X_Spawn");
			coord[1] = resultSet.getInt("Y_Spawn");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return coord;
	}
	
	public void insert() {
		executeUpdate(BDDExiaGeek.getQueryInsertPartie(Partie.getScore()));
		System.out.println("Insertion effectue");
	}
}
