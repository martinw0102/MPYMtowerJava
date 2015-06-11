package fr.ExiaGeek.Case;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Case implements fr.ExiaGeek.Affichage.PlateauCase {
	protected BufferedImage image = null;
	protected char dessin;
	protected Boolean vide;

	public Case(final char dessin, final String image, final Boolean vide) {
		this.dessin = dessin;
		this.vide = vide;
		try {
			this.image = ImageIO.read(new File("images/" + image));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public char getDessin() {
		return this.dessin;
	}

	@Override
	public BufferedImage getImage() {
		return this.image;
	}

}
