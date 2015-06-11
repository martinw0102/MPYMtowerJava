package fr.ExiaGeek.Case;

import fr.ExiaGeek.Partie;

public abstract class Assaillants extends Entite {
	
	protected int attaque;
	protected int vitDeplacement;
	protected int resistReseau;
	protected int resistSysteme;
	protected int butin;

	public Assaillants(Partie partie, char dessin, String image) {
		super(partie, dessin, image);
	}

	protected void seDeplacer() {
		
	}
	protected void attaquer() {
		
	}
}
