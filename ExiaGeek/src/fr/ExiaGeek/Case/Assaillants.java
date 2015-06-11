package fr.ExiaGeek.Case;

import java.util.ArrayList;

import fr.ExiaGeek.Partie;
import fr.ExiaGeek.BDD.BDDConnexion;

public abstract class Assaillants extends Entite {
	protected int attaque;
	protected int vitDeplacement;
	protected int resistReseau;
	protected int resistSysteme;
	protected int butin;

	public Assaillants(Partie partie, char dessin, String image) {
		super(partie, dessin, image);
	}

	public void seDeplacer() {
		this.y -= 1;
	}
	
	protected void attaquer() {
		
	}
}
