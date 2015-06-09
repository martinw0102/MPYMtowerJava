package fr.ExiaGeek.Case;

import fr.ExiaGeek.Partie;

public abstract class Tours extends Entite {

	protected int attReseau;
	protected int attSysteme;
	protected int vitAttaque;
	protected int cout;
	protected int niveau;
	
	public Tours(Partie partie, char dessin, String image, int x, int y) {
		super(partie, dessin, image, x, y);
	}

	protected void attaquer(Assaillants assaillant){
		if(assaillant.estVivant()){
			assaillant.prendreDommage(this.attReseau);
			assaillant.prendreDommage(this.attSysteme);
		}
	}
}
