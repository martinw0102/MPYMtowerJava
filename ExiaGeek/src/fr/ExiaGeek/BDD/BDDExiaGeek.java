package fr.ExiaGeek.BDD;

public class BDDExiaGeek {
	
	public static String getQueryInsert() {
		return "INSERT INTO `exiageek`.`partie` (`ID_Partie`, `Score`, `PV_PosteDeTravail`, `PO`, `ID_Carte`)"
				+ " VALUES (NULL, '12345', '250', '7895', '1');";
	}
}
