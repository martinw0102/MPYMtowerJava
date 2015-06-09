package fr.ExiaGeek.Case;

import fr.ExiaGeek.Partie;

public class FortiGuardWebFiltering extends Assaillants {

	public FortiGuardWebFiltering(Partie partie, char dessin, String image,
			int x, int y) {
		super(partie, dessin, image, x, y);
		
		this.pv = 25;
		this.portee = 0;
		this.attaque = 15;
		this.vitDeplacement = 2;
		this.resistSysteme = 0;
		this.butin = 20;
	}

}
