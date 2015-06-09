package fr.ExiaGeek.Case;

import fr.ExiaGeek.Partie;

public class StackOverflow extends Assaillants {

	public StackOverflow(Partie partie, char dessin, String image, int x, int y) {
		super(partie, dessin, image, x, y);
		
		this.pv = 15;
		this.portee = 0;
		this.attaque = 25;
		this.vitDeplacement = 4;
		this.resistReseau = 0;
		this.butin = 25;
	}

}
