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

	protected void attaquer(Assaillants cible){
		if(cible.estVivant() && cible.estAPortee(this)){
			cible.prendreDommage(this.attReseau);
			cible.prendreDommage(this.attSysteme);
		}
	}
	
	protected void miseANiveau(){
		this.niveau++;
		
	}
}
