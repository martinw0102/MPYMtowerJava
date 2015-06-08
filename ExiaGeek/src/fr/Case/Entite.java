package fr.Case;

public class Entite extends Case{
	protected int pv;
	protected int portee;
	protected boolean vivant;
	
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
	
	public int getX(){
		return this.x;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setY(int y){
		this.y = y;
	}
}
