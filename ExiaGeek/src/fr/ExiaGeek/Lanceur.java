package fr.ExiaGeek;

import javax.swing.*;

public class Lanceur extends JFrame{
	private JPanel pan = new JPanel();
	
	private JButton boutonNouvellePartie = new JButton("Nouvelle partie"),
			boutonChargerPartie = new JButton("Charger une partie"),
			boutonQuitter = new JButton("Quitter");
	
	public Lanceur(){
		this.setTitle("ExiaGeek");
        this.setSize(420, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pan.add(boutonNouvellePartie);
        pan.add(boutonChargerPartie);
        pan.add(boutonQuitter);
        
        this.setContentPane(pan);
        this.setVisible(true);
	}
}
