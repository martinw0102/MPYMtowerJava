package fr.ExiaGeek.Case;

import fr.ExiaGeek.Partie;

public class StackOverflow extends Assaillants {

	public StackOverflow(Partie partie, char dessin, String image) {
		super(partie, dessin, image);
		
		this.pv = 15;
		this.portee = 2;
		this.attaque = 25;
		this.vitDeplacement = 4;
		this.resistReseau = 0;
		this.butin = 25;
	}

}
