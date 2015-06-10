package fr.ExiaGeek;

import java.util.ArrayList;

import fr.ExiaGeek.Affichage.Plateau;
import fr.ExiaGeek.Case.Case;
import fr.ExiaGeek.Case.CaseVide;
import fr.ExiaGeek.Case.Entite;

public class Partie {
	private final static int HAUTEUR = 25;
	private final static int LARGEUR = 25;
	
	private final Case cases[][];
	//private final ArrayList<Entite> entites;
	private final Boolean affichageConsole = false;
	private Plateau plateau;
	
	public int ressource;
	public String pseudo;
	public int nbVague;
	private static int score = 0;

	public Partie() {
		this.cases = new Case[HAUTEUR][LARGEUR];
		Case uneCase;
		for(int y = 0; y < HAUTEUR; y++){
			for(int x = 0; x < LARGEUR; x++){
				uneCase = new CaseVide();
				this.setXY(x, y, uneCase);
			}
		}
		this.plateau = new Plateau(HAUTEUR, LARGEUR, this.cases);
	}
	
	public void afficher(){
		if(this.affichageConsole){
			this.afficherConsole();
		}else{
			this.afficherGraphique();
		}
	}
	
	private void afficherConsole(){
		for(int y = 0; y < HAUTEUR; y++){
			for(int x = 0; x < LARGEUR; x++){
				final Entite e = this.getEntite(x, y);
				if(e == null){
					System.out.println(this.getXY(x, y).getDessin());
				}else{
					System.out.println(e.getDessin());
				}
			}
		}
	}
	
	private void afficherGraphique(){
		this.plateau.rafraichir();
	}
	
	public Entite getEntite(final int x, final int y){
		for(final Entite e : this.entites){
			if(e != null){
				if((e.getX() == x) && (e.getY() == y)){
					return e;
				}
			}
		}
		return null;
	}
	
	public Case getXY(final int x, final int y){
		return this.cases[x][y];
	}
	
	public void setXY(final int x, final int y, final Case c) {
		this.cases[x][y] = c;
	}
	
	public void calculerScore() {
	
		int TempsEnMillisecondes = 1000;	

		for (int i = 0; i <= 10; i++) {
			try {
	                Thread.sleep(TempsEnMillisecondes);
	                Partie.score++;
	        } 
	        catch (InterruptedException e) {
	        }
	            System.out.println(Partie.score);
	            
	    }
	}

	public static int getScore() {
		return score;
	}

	public void setScore(int score) {
		Partie.score = score;
	}
}

		