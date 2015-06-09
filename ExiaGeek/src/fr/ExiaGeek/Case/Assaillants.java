package fr.ExiaGeek.Case;

import fr.ExiaGeek.Partie;

public abstract class Assaillants extends Entite {
	
	protected int attaque;
	protected int vitDeplacement;
	protected int resistReseau;
	protected int resistSysteme;
	protected int butin;
	
	protected void seDeplacer() {
		
	}
	protected void attaquer() {
		
	}

	public Assaillants(Partie partie, char dessin, String image, int x, int y) {
		super(partie, dessin, image, x, y);
	}

}
