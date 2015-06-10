package fr.ExiaGeek.Case;

import fr.ExiaGeek.Partie;

public class MotDePasse extends Tours {

	public MotDePasse(Partie partie, char dessin, String image, int x, int y) {
		super(partie, dessin, image, x, y);
		this.pv = 80;
		this.cout = 50;
		this.portee = 4;
		this.attReseau = 0;
		this.attSysteme = 10;
		this.vitAttaque = 2;
		this.niveau = 1;
	}

}
