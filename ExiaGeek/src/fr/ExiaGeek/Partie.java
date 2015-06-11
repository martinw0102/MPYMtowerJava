package fr.ExiaGeek;

import java.util.ArrayList;
import java.util.Date;

import fr.ExiaGeek.Affichage.Plateau;
import fr.ExiaGeek.BDD.BDDConnexion;
import fr.ExiaGeek.Case.Bordure;
import fr.ExiaGeek.Case.Case;
import fr.ExiaGeek.Case.CaseVide;
import fr.ExiaGeek.Case.Chemin;
import fr.ExiaGeek.Case.Entite;

public class Partie {
	private final static int HAUTEUR = 25, LARGEUR = 25;
	
	private final Case cases[][];
	private final ArrayList<Entite> entites;
	private final ArrayList<Chemin> chemins;
	private final Boolean affichageConsole = false;
	private Plateau plateau;
	
	public int ressource;
	public String pseudo;
	public int nbVague;
	private static int score = 0;

	public Partie() {
		this.cases = new Case[HAUTEUR][LARGEUR];
		this.entites = new ArrayList<>();
		this.chemins = new ArrayList<>();	
		
		
		
		Case uneCase;
		for(int y = 0; y < HAUTEUR; y++){
			for(int x = 0; x < LARGEUR; x++){
				if((x == 0) || (x == (LARGEUR - 1)) || ((y == 0) || (y == HAUTEUR - 1))){
					uneCase = new Bordure();
				}else{
					uneCase = new CaseVide();
				}
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
		    	java.util.Date temps = new java.util.Date (System.currentTimeMillis ()); //Relever l'heure avant le debut du progamme (en milliseconde) 
		    	try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	Date dateFin = new Date (System.currentTimeMillis()); //Relever l'heure a la fin du progamme (en milliseconde) 
		    	Date duree = new Date (System.currentTimeMillis()); //Pour calculer la différence
		    	duree.setTime (dateFin.getTime () - temps.getTime ());  //Calcul de la différence
		    	long secondes = duree.getTime () / 1000;
		    	secondes %= 60;
		    	System.out.println ("Votre score est: " + secondes);
	}

	public static int getScore() {
		return score;
	}

	public void setScore(int score) {
		Partie.score = score;
	}
}

		