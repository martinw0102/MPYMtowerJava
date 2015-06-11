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
import fr.ExiaGeek.Case.PosteDeTravail;

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
		
		int coordS[] = null;
		
		BDDConnexion bdd = new BDDConnexion();
		bdd.open();
		bdd.selectChemin(this.chemins);
		int coordPoste[];
		//bdd.selectCoordSpawn(coordS);
		bdd.selectXPT(xPoste);
		bdd.close();
		
		Case uneCase = null;
		for(int y = 0; y < HAUTEUR; y++){
			for(int x = 0; x < LARGEUR; x++){
				if((x == 0) || (x == (LARGEUR - 1)) || ((y == 0) || (y == HAUTEUR - 1))){
					uneCase = new Bordure();
				}else if(testChemin(chemins, x, y)){
					uneCase = new Chemin();
				}else{
					uneCase = new CaseVide();
				}
				this.setXY(x, y, uneCase);
			}
		}
		this.plateau = new Plateau(HAUTEUR, LARGEUR, this.cases);
		
		this.placerPT();
	}
	
	private boolean testChemin(ArrayList<Chemin> chemin, int x, int y){
		for(int i = 0; i < chemin.size(); i++){
			if(chemin.get(i).getX() == x && chemin.get(i).getY() == y){
				return true;
			}
		}
		return false;
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
	
	private void placerPT(){
		int x = 0;
		
		BDDConnexion bdd = new BDDConnexion();
		bdd.open();
		//bdd.selectXPT(x);
		bdd.close();
				
		System.out.println(x);
		
		/*final PosteDeTravail pt = new PosteDeTravail(this);
		this.entites.add(pt);
		this.placerEntite(pt, x, y);
		this.plateau.placerPiece(pt);*/
	}
	
	private void placerEntite(final Entite e, int x, int y){
		e.setX(x);
		e.setY(y);
	}
	
	public Case getXY(final int x, final int y){
		return this.cases[x][y];
	}
	
	public void setXY(final int x, final int y, final Case c) {
		this.cases[x][y] = c;
	}
	
	public void calculerScore() {
		    	/*java.util.Date temps = new java.util.Date (System.currentTimeMillis ()); //Relever l'heure avant le debut du progamme (en milliseconde) 
		    	try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    	Date dateFin = new Date (System.currentTimeMillis()); //Relever l'heure a la fin du progamme (en milliseconde) 
		    	Date duree = new Date (System.currentTimeMillis()); //Pour calculer la diff�rence
		    	duree.setTime (dateFin.getTime () - temps.getTime ());  //Calcul de la diff�rence
		    	long secondes = duree.getTime () / 1000;
		    	secondes %= 60;
		    	System.out.println ("Votre score est: " + secondes);
    	Date dateFin = new Date (System.currentTimeMillis()); //Relever l'heure a la fin du progamme (en milliseconde) 
    	Date duree = new Date (System.currentTimeMillis()); //Pour calculer la diff�rence
    	duree.setTime (dateFin.getTime () - dateDebut.getTime ());  //Calcul de la diff�rence
    	long score = duree.getTime () / 1000;
    	score %= 60;
    	System.out.println ("Votre score est: " + score);*/
}		


	public static int getScore() {
		return score;
	}

	public void setScore(int score) {
		Partie.score = score;
	}
}

		
