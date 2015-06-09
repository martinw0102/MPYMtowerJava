package fr.ExiaGeek;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Lanceur extends JFrame {
	private JPanel container = new JPanel();
	
	private JTextField textFieldPseudo = new JTextField("Votre Pseudo");
	private JLabel labelPseudo = new JLabel("Pseudo : ");
	
	private JButton boutonNouvellePartie = new JButton("Nouvelle partie"),
			boutonChargerPartie = new JButton("Charger une partie"),
			boutonQuitter = new JButton("Quitter");
	
	public Lanceur(){
		this.setTitle("ExiaGeek");
        this.setSize(420, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.init();
        this.setContentPane(container);
        this.setVisible(true);
	}
	
	private void init(){
		JPanel panelPseudo = new JPanel();
		panelPseudo.add(labelPseudo);
		panelPseudo.add(textFieldPseudo);
		
		JPanel panelBouton = new JPanel();
		panelBouton.add(boutonNouvellePartie);
		panelBouton.add(boutonChargerPartie);
		panelBouton.add(boutonQuitter);
		
		container.add(panelPseudo, BorderLayout.NORTH);
		container.add(panelBouton, BorderLayout.SOUTH);
	}
}
