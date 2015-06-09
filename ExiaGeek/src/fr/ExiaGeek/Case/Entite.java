package fr.ExiaGeek.Case;

import fr.ExiaGeek.Partie;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Entite implements fr.ExiaGeek.Affichage.PlateauPiece{
	protected int x;
	protected int y;
	protected char dessin;
	protected Image image = null;
	protected Partie partie;
	
	protected int pv;
	protected int portee;
	protected boolean vivant;
	
	public Entite(final Partie partie, final char dessin, final String image, final int x, final int y){
		this.partie = partie;
		this.dessin = dessin;
		this.x = x;
		this.y = y;
		this.setImage(image);
	}
	
	protected boolean estAPortee(Entite entite){
		int x = entite.getX(), y = entite.getY();
		if(this.x + this.portee == x 
				|| this.x - this.portee == x
				|| this.y + this.portee == y
				|| this.y - this.portee == y
				|| this.x + this.portee == y
				|| this.x - this.portee == y
				|| this.y + this.portee == x
				|| this.y - this.portee == x
				|| this.x + this.portee == x && this.y + this.portee == y
				|| this.x + this.portee == x && this.y - this.portee == y
				|| this.x - this.portee == x && this.y - this.portee == y
				|| this.y + this.portee == x && this.x + this.portee == y
				|| this.y + this.portee == x && this.x - this.portee == y
				|| this.y - this.portee == x && this.x - this.portee == y){
			return true;
		}
		return false;
	}
	
	protected void prendreDommage(int dommage){
		if(dommage < this.pv){
			this.pv -= dommage;
		}else{
			this.mourir();
		}
	}
	
	protected void mourir(){
		this.vivant = false;
	}
	
	protected boolean estVivant(){
		if(this.pv > 0){
			return true;
		}
		return false;
	}
	
	public char getDessin(){
		return this.dessin;
	}
	
	@Override
	public Image getImage(){
		return this.image;
	}
	
	@Override
	public int getPositionHorizontale(){
		return this.getX();
	}
	
	 @Override
	 public int getPositionVerticale(){
		 return this.getY();
	 }
	
	public int getX(){
		return this.x;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setImage(final String image){
		try{
			this.image = ImageIO.read(new File("images/" + image));
		}catch (final IOException e) { e.printStackTrace(); }
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setY(int y){
		this.y = y;
	}
}
