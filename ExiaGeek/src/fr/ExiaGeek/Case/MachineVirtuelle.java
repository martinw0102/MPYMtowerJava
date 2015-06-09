package fr.ExiaGeek.Case;

import fr.ExiaGeek.Partie;

public class MachineVirtuelle extends Tours {

	public MachineVirtuelle(Partie partie, char dessin, String image, int x,
			int y) {
		super(partie, dessin, image, x, y);
		this.pv = 50;
		this.cout = 60;
		this.portee = 0;
		this.attReseau = 0;
		this.attSysteme = 10;
		this.vitAttaque = 1;
		this.niveau = 1;
	}

}
