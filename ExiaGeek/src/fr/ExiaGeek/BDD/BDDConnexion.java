package fr.ExiaGeek.BDD;

import java.sql.DriverManager;
import java.sql.SQLException;

public class BDDConnexion {
	private String url = "10.162.128.244";
	private String root = "licorne";
	private String password = "";
	private java.sql.Connection connection;
	private java.sql.Statement statement;
	
	
	public boolean open() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(this.url, this.root, this.password);
			this.statement = this.connection.createStatement();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public void close() {
		
	}
	private java.sql.ResultSet executeQuery(String query) {
		return null;
		
	}
	private int executeUpdate(String query) {
		return (Integer) null;
	}
	
	public BDDConnexion() {
		
	}
}
