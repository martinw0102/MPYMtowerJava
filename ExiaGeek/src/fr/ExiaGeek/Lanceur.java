package fr.ExiaGeek;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Lanceur extends JFrame {

	private static final long serialVersionUID = -4248310360580329628L;

	private JPanel container = new JPanel();
	
	private JTextField textFieldPseudo = new JTextField("Votre Pseudo");
	private JLabel labelPseudo = new JLabel("Pseudo : ");
	
	private JButton boutonNouvellePartie = new JButton("Nouvelle partie"),
			boutonChargerPartie = new JButton("Charger une partie"),
			boutonQuitter = new JButton("Quitter");
	
	private listenerNouvellePartie nouvellePartie = new listenerNouvellePartie();
	private listenerChargerPartie chargerPartie = new listenerChargerPartie();
	
	public Lanceur(){
		this.setTitle("ExiaGeek");
        this.setSize(420, 110);
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
		
		JPanel panelCarte = new JPanel();
		
		JPanel panelBouton = new JPanel();
		
		boutonNouvellePartie.addActionListener(nouvellePartie);
		boutonChargerPartie.addActionListener(chargerPartie);
		boutonQuitter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				int choix = JOptionPane.showConfirmDialog(null,
						"Voulez-vous vraiment quitter ?",
						"Quitter",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				
				if(choix == JOptionPane.OK_OPTION){
					System.out.println("Fermeture de l'application...");
					System.exit(0);
				}
			}
		});
				
		panelBouton.add(boutonNouvellePartie);
		panelBouton.add(boutonChargerPartie);
		panelBouton.add(boutonQuitter);
		
		container.add(panelPseudo, BorderLayout.NORTH);
		container.add(panelCarte, BorderLayout.CENTER);
		container.add(panelBouton, BorderLayout.SOUTH);
	}
	
	public class listenerNouvellePartie implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			final Partie maPartie = new Partie();
			maPartie.afficher();
		}
	}
	
	public class listenerChargerPartie implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			
		}
	}
}
