package fr.ExiaGeek.BDD;

public class BDDExiaGeek {
	
	public static String getQueryInsertPartie(int score) {
		return "INSERT INTO `partie` (`Score`, `PV_PosteDeTravail`, `PO`, `ID_Carte`)   VALUES ('"+ score +"', '"+ 250 +"', '"+ 7895 +"', '"+ 1 +"')";
	}
	
	public static String getQuerySelect(final int id) {
		return "SELECT * FROM `chemin` WHERE `ID_Carte` = " + id;
	}
	
	public static String getQuerySelectCoord(final int id) {
		return "SELECT * FROM `carte` WHERE `ID_Carte` = " + id;
	}
}
