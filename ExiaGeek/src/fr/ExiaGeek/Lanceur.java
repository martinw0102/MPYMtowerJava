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
	
	public static Object uDate;
	private JPanel container = new JPanel();
	private JComboBox combo = new JComboBox();
	private JLabel label = new JLabel("Liste Maps");
	
	
	private static final long serialVersionUID = -4248310360580329628L;
	//public static long dateDebut;
	
	
	private JTextField textFieldPseudo = new JTextField("Votre Pseudo");
	private JLabel labelPseudo = new JLabel("    Pseudo : ");
	
	private JButton boutonNouvellePartie = new JButton("Nouvelle partie"),
			boutonChargerPartie = new JButton("Charger une partie"),
			boutonQuitter = new JButton("Quitter");
	
	private listenerNouvellePartie nouvellePartie = new listenerNouvellePartie();
	private listenerChargerPartie chargerPartie = new listenerChargerPartie();
	
	public Lanceur(){
		Date dateDebut = new Date();
		this.setTitle("ExiaGeek");
        this.setSize(420, 150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.init();
        this.setContentPane(container);
        this.setVisible(true);
        
        this.setTitle("Animation");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    
	    container.setLayout(new BorderLayout());
	    String[] tab = {"Map1", "Map2","Map3"};
	    combo = new JComboBox(tab);
	    
	    combo.addItemListener(new ItemState());
	   
	    
	    JPanel top = new JPanel();
	    top.add(label);
	    top.add(combo);
	    container.add(top, BorderLayout.WEST);
	    this.setContentPane(container);
	    this.setVisible(true);  
	    
	}
	
	    class ItemState implements ItemListener{
	        public void itemStateChanged(ItemEvent e) {
	          System.out.println("�v�nement d�clench� sur : " + e.getItem());
	        }               
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

						//dateDebut.System.currentTimeMillis(); //Relever l'heure avant le debut du progamme (en milliseconde) 
					    	/*try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    	Date dateFin = new Date (System.currentTimeMillis()); //Relever l'heure a la fin du progamme (en milliseconde) 
				    	Date duree = new Date (System.currentTimeMillis()); //Pour calculer la diff�rence
				    	duree.setTime (dateFin.getTime () - dateDebut.getTime ());  //Calcul de la diff�rence
				    	long score = duree.getTime () / 1000;
				    	score %= 60;
				    	System.out.println ("Votre score est: " + score);*/
		}		
	}
	
	
	public class listenerChargerPartie implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			
		}
	}
}
