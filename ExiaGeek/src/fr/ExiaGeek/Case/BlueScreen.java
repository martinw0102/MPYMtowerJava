package fr.ExiaGeek.Case;

import fr.ExiaGeek.Partie;

public class BlueScreen extends Assaillants {

	public BlueScreen(Partie partie, char dessin, String image) {
		super(partie, dessin, image);
		
		this.pv = 60;
		this.portee = 3;
		this.attaque = 35;
		this.vitDeplacement = 3;
		this.resistReseau = 0;
		this.butin = 55;
	}
	

}
