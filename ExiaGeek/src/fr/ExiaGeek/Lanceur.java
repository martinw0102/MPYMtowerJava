package fr.ExiaGeek;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;



public class Lanceur extends JFrame {
	private JPanel container = new JPanel();
	private JComboBox combo = new JComboBox();
	private JLabel label = new JLabel("Liste Maps");
	
	
	private static final long serialVersionUID = -4248310360580329628L;
	
	private JTextField textFieldPseudo = new JTextField("Votre Pseudo");
	private JLabel labelPseudo = new JLabel("    Pseudo : ");
	
	private JButton boutonNouvellePartie = new JButton("Nouvelle partie"),
			boutonChargerPartie = new JButton("Charger une partie"),
			boutonQuitter = new JButton("Quitter");
	
	private listenerNouvellePartie nouvellePartie = new listenerNouvellePartie();
	private listenerChargerPartie chargerPartie = new listenerChargerPartie();
	
	public Lanceur(){
		this.setTitle("ExiaGeek");
        this.setSize(420, 150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.init();
        this.setContentPane(container);
        this.setVisible(true);
        
        this.setTitle("Lanceur");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    
	    container.setLayout(new BorderLayout());
	    String[] tab = {"Map1", "Map2","Map3"};
	    combo = new JComboBox(tab);	   
	    
	    JPanel top = new JPanel();
	    top.add(label);
	    top.add(combo);
	    container.add(top, BorderLayout.WEST);
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
		container.add(panelCarte, BorderLayout.EAST);
		container.add(panelBouton, BorderLayout.SOUTH);
	}
	

	public class listenerNouvellePartie implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			final Partie maPartie = new Partie();
				maPartie.afficher();
				maPartie.jouer();
		}		
	}
	
	
	public class listenerChargerPartie implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			
		}
	}
}
