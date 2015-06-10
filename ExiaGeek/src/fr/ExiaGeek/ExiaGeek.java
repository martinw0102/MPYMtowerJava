package fr.ExiaGeek;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import fr.ExiaGeek.BDD.*;

public class ExiaGeek {
	
	public static void main(String[] args) {		
		BDDConnexion bdd = new BDDConnexion();
		bdd.open();
		Lanceur launcher = new Lanceur();
		//bdd.insertTest();
		/*try {
		File file = new File("C:\\Users\\Martin\\git\\MPYMtowerJava\\ExiaGeek\\src\\fr\\ExiaGeek\\BDD\\Deorro x Chris Brown - Five More Hours.mp3");
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		try {
			Player player = new Player(bis);
			player.play();
		}catch(JavaLayerException ex){
			}
		}catch(IOException e){
			}*/
		bdd.close();
	}
}