package fr.ExiaGeek.Case;

import fr.ExiaGeek.Partie;

public class Antivirus extends Tours {

	public Antivirus(Partie partie, char dessin, String image, int x, int y) {
		super(partie, dessin, image, x, y);
		
		this.pv = 50;
		this.cout = 30;
		this.portee = 4;
		this.attReseau = 15;
		this.attSysteme = 0;
		this.vitAttaque = 3;
		this.niveau = 1;
	}
	
	
}
