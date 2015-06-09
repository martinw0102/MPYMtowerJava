package fr.ExiaGeek.BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BDDConnexion {
	private static final String url = "jdbc:mysql:3306//10.162.128.244/exiageek";
	private static final String root = "licorne";
	private static final String password = "";
	private Connection connection;
	private Statement statement;


	public Boolean open() {
		   try {

			      Class.forName("com.mysql.jdbc.Driver");

			      System.out.println("Driver O.K.");


			      String url = "jdbc:mysql://10.162.128.244/exiageek";

			      String user = "licorne";

			      String passwd = "";


			      Connection conn = DriverManager.getConnection(url, user, passwd);

			      System.out.println("Connexion effective !");         

			         

			    } catch (Exception e) {

			      e.printStackTrace();

			    } 
		   return true;

			  }

	public void close() {
		try {
			this.connection.close();
			this.statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
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
			return this.statement.executeUpdate(updateQuery, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private int getLastId() {
		try {
			ResultSet resultSet = this.statement.getGeneratedKeys();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	public void insertTest() {
		BDDExiaGeek.getQueryInsert();
	}
	
	/*public RGBPetri getRGBPetribyId(final int id) {
		ResultSet resultSet = this.executeQuery(BDDRGBPetri.getQuerySelect(id));
		try {
			if (resultSet.first()) {
				RGBPetri rgbPetri = new RGBPetri(resultSet.getInt("WIDTH"), resultSet.getInt("HEIGHT"));
				rgbPetri.setLabel(resultSet.getString("LABEL"));
				ResultSet rSCell = this.executeQuery(BDDRGBCell.getQuerySelectByIdRGBPetri(resultSet.getInt("ID")));
				for (; rSCell.next();) {
					rgbPetri.add(new RGBCell(rgbPetri, new Position(rSCell.getInt("X"), rSCell.getInt("Y")), rSCell.getInt("STRENGTH"), new Color(rSCell.getInt("COLOR"))));
				}
				return rgbPetri;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insertRGBPetri(final RGBPetri rgbPetri) {
		if (this.executeUpdate(BDDRGBPetri.getQueryInsert(rgbPetri)) == 1) {
			int idJavaPetri = this.getLastId();
			if (idJavaPetri != -1) {
				this.executeUpdate(BDDRGBCell.getQueryInsert(rgbPetri, idJavaPetri));
			}
		}
	}
}*/

	public BDDConnexion() {
		this.connection = null;
		this.statement = null;
	}
}
