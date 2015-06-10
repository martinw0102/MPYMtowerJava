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
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;


public class Lanceur extends JFrame {
	
	private JPanel container1 = new JPanel();
	private JComboBox combo = new JComboBox();
	private JLabel label = new JLabel("Liste Maps");
	
	
	private static final long serialVersionUID = -4248310360580329628L;

	private JPanel container = new JPanel();
	
	private JTextField textFieldPseudo = new JTextField("Votre Pseudo");
	private JLabel labelPseudo = new JLabel("     Pseudo : ");
	
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
        this.setContentPane(container1);
        this.setVisible(true);
        
        this.setTitle("Animation");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    
	    container1.setLayout(new BorderLayout());
	    String[] tab = {"Map1", "Map2","Map3"};
	    combo = new JComboBox(tab);
	    
	    JPanel top = new JPanel();
	    top.add(label);
	    top.add(combo);
	    container1.add(top, BorderLayout.WEST);
	    this.setContentPane(container1);
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
		
		container1.add(panelPseudo, BorderLayout.NORTH);
		container1.add(panelCarte, BorderLayout.EAST);
		container1.add(panelBouton, BorderLayout.SOUTH);
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
