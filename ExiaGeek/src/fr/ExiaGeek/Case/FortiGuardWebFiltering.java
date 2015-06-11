package fr.ExiaGeek.Case;

import fr.ExiaGeek.Partie;

public class FortiGuardWebFiltering extends Assaillants {

	public FortiGuardWebFiltering(Partie partie, char dessin, String image) {
		super(partie, dessin, image);
		
		this.pv = 25;
		this.portee = 2;
		this.attaque = 15;
		this.vitDeplacement = 2;
		this.resistSysteme = 0;
		this.butin = 20;
	}

}
