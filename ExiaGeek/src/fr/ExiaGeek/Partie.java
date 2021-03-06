package fr.ExiaGeek;

import java.util.ArrayList;
import java.util.Date;

import fr.ExiaGeek.Affichage.Plateau;
import fr.ExiaGeek.BDD.BDDConnexion;
import fr.ExiaGeek.Case.*;

public class Partie {
	private final static int HAUTEUR = 25, LARGEUR = 25;
	
	private final Case cases[][];
	private final ArrayList<Chemin> chemins;
	private final ArrayList<Assaillants> vagueActuel;
	private final Boolean affichageConsole = false;
	private Plateau plateau;
	
	public int ressource;
	public String pseudo;
	public int nbVague;
	
	private static int score = 0;

	public Partie() {
		this.cases = new Case[HAUTEUR][LARGEUR];
		this.vagueActuel = new ArrayList<>();
		this.chemins = new ArrayList<>();
			
		BDDConnexion bdd = new BDDConnexion();
		bdd.open();
		bdd.selectChemin(this.chemins);
		int xS = bdd.selectXS();
		int yS = bdd.selectYS();
		bdd.close();
		
		Case uneCase = null;
		for(int y = 0; y < HAUTEUR; y++){
			for(int x = 0; x < LARGEUR; x++){
				if((x == 0) || (x == (LARGEUR - 1)) || ((y == 0) || (y == HAUTEUR - 1))){
					uneCase = new Bordure();
				}else if(x == xS && y == yS){
					uneCase = new Spawn();
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
		this.placerEnnemi(xS, yS);
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
		this.plateau.rafraichir();
	}
	
	public Entite getVagueActuel(final int x, final int y){
		for(final Entite e : this.vagueActuel){
			if(e != null){
				if((e.getX() == x) && (e.getY() == y)){
					return e;
				}
			}
		}
		return null;
	}
	
	public void jouer(){
		for(final Assaillants e : this.vagueActuel){
			e.seDeplacer();
		}
	}
	
	private void placerPT(){		
		BDDConnexion bdd = new BDDConnexion();
		bdd.open();
		int xPT = bdd.selectXPT();
		int yPT = bdd.selectYPT();
		bdd.close();
		
		final PosteDeTravail pt = new PosteDeTravail(this);
		this.placerEntite(pt, xPT, yPT);
		this.plateau.placerPiece(pt);
	}
	
	private void placerEnnemi(int x, int y){
		final ErreurHTTP404 e = new ErreurHTTP404(this);
		vagueActuel.add(e);
		this.placerEntite(e, x, y);
		this.plateau.placerPiece(e);
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

	public static int getScore() {
		return score;
	}

	public void setScore(int score) {
		Partie.score = score;
	}
}

		
