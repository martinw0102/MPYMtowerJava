package fr.ExiaGeek.Case;

import fr.ExiaGeek.Partie;

public class ErreurHTTP404 extends Assaillants {

	public ErreurHTTP404(Partie partie) {
		super(partie, 'e', "ennemi1.png");
		 
		this.pv = 35;
		this.portee = 2;
		this.attaque = 10;
		this.vitDeplacement = 1;
		this.resistSysteme = 0;
		this.butin = 20;
	}

}
