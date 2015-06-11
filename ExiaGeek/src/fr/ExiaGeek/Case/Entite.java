package fr.ExiaGeek.Case;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import fr.ExiaGeek.Partie;

public abstract class Entite implements fr.ExiaGeek.Affichage.PlateauPiece{
	protected int x;
	protected int y;
	protected char dessin;
	protected BufferedImage image = null;
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
	
	public Entite(final Partie partie, final char dessin, final String image){
		this(partie, dessin, image, 0, 0);
	}
	
	protected boolean estAPortee(Entite entite){
		if(Math.hypot(entite.getX() - this.getX(), entite.getY() - this.getY()) <= this.portee){
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
	
	@Override
	public BufferedImage getImage(){
		
		BufferedImage image = new BufferedImage(30,30,BufferedImage.TYPE_INT_ARGB);
		Graphics g = image.getGraphics();
		if( g instanceof Graphics2D ){
			Graphics2D g2d = (Graphics2D) g;
			Composite original = g2d.getComposite();
			g2d.setBackground(new Color(0,0,0,0));
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, 0.0f));
			g.clearRect(0, 0, 30, 30);
			g2d.setComposite(original);
		}
		g.drawImage(this.image, 0, 0, 30, 30, null);
		
		return image;
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
