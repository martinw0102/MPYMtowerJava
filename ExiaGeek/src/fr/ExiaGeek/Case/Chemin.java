package fr.ExiaGeek.Case;

public class Chemin extends Case{
	private int x, y;
	
	public Chemin(){
		super('.', "cheminassaillant.png", false);
	}
	
	public Chemin(int x, int y){
		super('.', "cheminassaillant.png", false);
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
