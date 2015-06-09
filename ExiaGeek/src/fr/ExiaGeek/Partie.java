package fr.ExiaGeek;

import fr.ExiaGeek.Case.Case;
import fr.ExiaGeek.Case.CaseVide;
import fr.ExiaGeek.Affichage.Plateau;

public class Partie {
	private final Case cases[][];
	private Plateau plateau;
	
	public int score;
	public int ressource;
	public String pseudo;
	public int nbVague;	 

	public Partie() {
		this.cases = new Case[25][25];
		Case uneCase;
		for(int y = 0; y < 25; y++){
			for(int x = 0; x < 25; x++){
				uneCase = new CaseVide();
				this.setXY(x, y, uneCase);
			}
		}
		this.plateau = new Plateau(25,25, this.cases);
	}
	
	public void afficher(){
		this.plateau.rafraichir();
	}
	
	public void setXY(final int x, final int y, final Case c) {
		this.cases[x][y] = c;
	}
	
	public void calculerScore() {
		
	}
}

		