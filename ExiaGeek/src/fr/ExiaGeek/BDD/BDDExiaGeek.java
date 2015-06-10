package fr.ExiaGeek.BDD;


public class BDDExiaGeek {
	
	public static String getQueryInsertPartie(int score) {
		return "INSERT INTO `partie` (`Score`, `PV_PosteDeTravail`, `PO`, `ID_Carte`)   VALUES ('"+ score +"', '"+ 250 +"', '"+ 7895 +"', '"+ 1 +"')";
	}
}
