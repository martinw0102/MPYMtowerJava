package fr.ExiaGeek;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class ExiaGeek {
	
	public static void main(String[] args) {
		Lanceur launcher = new Lanceur();
		try {

			File file = new File("C:\\Users\\Nocte\\Desktop\\Musique Jeu 16Bit\\Final Fantasy VII OST - Prelude [Title Theme].mp3");
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			try {
				Player player = new Player(bis);
				player.play();
			}catch(JavaLayerException ex){
				
			}
		}catch(IOException e){
			
		}
		/*BDDConnexion bdd = new BDDConnexion();
		bdd.open();
		bdd.insertTest();
		bdd.close();*/
		}
	}

