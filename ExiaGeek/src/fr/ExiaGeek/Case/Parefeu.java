package fr.ExiaGeek.Case;

import fr.ExiaGeek.Partie;

public class Parefeu extends Tours {

	public Parefeu(Partie partie, char dessin, String image, int x, int y) {
		super(partie, dessin, image, x, y);
		this.pv = 100;
		this.cout = 80;
		this.portee = 5;
		this.attReseau = 20;
		this.attSysteme = 0;
		this.vitAttaque = 2;
		this.niveau = 1;
	}

}
