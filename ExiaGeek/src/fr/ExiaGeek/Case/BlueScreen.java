package fr.ExiaGeek.Case;

import fr.ExiaGeek.Partie;

public class BlueScreen extends Assaillants {

	public BlueScreen(Partie partie, char dessin, String image, int x, int y) {
		super(partie, dessin, image, x, y);
		
		this.pv = 60;
		this.portee = 0;
		this.attaque = 35;
		this.vitDeplacement = 3;
		this.resistReseau = 0;
		this.butin = 55;
	}
	

}
