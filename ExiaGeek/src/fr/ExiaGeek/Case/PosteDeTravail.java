package fr.ExiaGeek.Case;

import java.awt.Image;

import fr.ExiaGeek.Partie;

public class PosteDeTravail extends Entite {

	public PosteDeTravail(Partie partie) {
		super(partie, 'x', "cristal.png");
		this.pv = 200;
	}

	@Override
	public Image getImage() {
		return null;
	}

}
