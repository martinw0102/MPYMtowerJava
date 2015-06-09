package fr.ExiaGeek.Case;

import fr.ExiaGeek.Partie;

public class ErreurHTTP404 extends Assaillants {

	public ErreurHTTP404(Partie partie, char dessin, String image, int x, int y) {
		super(partie, dessin, image, x, y);
		 
		this.pv = 35;
		this.portee = 0;
		this.attaque = 10;
		this.vitDeplacement = 1;
		this.resistSysteme = 0;
		this.butin = 20;
	}

}
