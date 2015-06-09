package fr.ExiaGeek;

import fr.ExiaGeek.BDD.*;

public class ExiaGeek {
	
	public static void main(String[] args) {
		Lanceur launcher = new Lanceur();
		BDDConnexion bdd = new BDDConnexion();
		bdd.open();
		bdd.insertTest();
		bdd.close();
	}
}
