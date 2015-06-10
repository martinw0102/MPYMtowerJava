package fr.ExiaGeek.Case;

import fr.ExiaGeek.Partie;

public class NullPointerAssigment extends Assaillants {

	public NullPointerAssigment(Partie partie, char dessin, String image,
			int x, int y) {
		super(partie, dessin, image, x, y);
		
		this.pv = 45;
		this.portee = 2;
		this.attaque = 20;
		this.vitDeplacement = 2;
		this.resistReseau = 0;
		this.butin = 40;
	}

}
