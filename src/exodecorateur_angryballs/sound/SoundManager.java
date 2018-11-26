package exodecorateur_angryballs.sound;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundManager {
	
	private static SoundManager singleton;

	private SoundManager() {
		
	}
	
	public static SoundManager getInstance() {
		if(singleton == null) 
			singleton = new SoundManager();
		
		return singleton;
	}
	
	public void playShockSound(double intensite) {
		
		try {
			//File fichier;
			FileInputStream f;
			File p�re, f1, ici;

			p�re = new File("");
			ici = new File(p�re.getAbsoluteFile(),"musique");
			f1 = new File(ici.getAbsoluteFile(),"bille_bille.wav");

			AudioInputStream audioInputStream;
			
			audioInputStream = AudioSystem.getAudioInputStream(f1);
			AudioFormat format= audioInputStream.getFormat();
			
			SourceDataLine ligne;

			ligne = AudioSystem.getSourceDataLine(format);
			ligne.open(format);

			// Controle du volume 
		    FloatControl gainControl = 	(FloatControl)	ligne.getControl(FloatControl.Type.MASTER_GAIN);
		    float dB = (float) (Math.log(intensite) / Math.log(10.0) * 30.0);
		    dB = Math.min(6, Math.max(-80, dB)); // -80 < dB < 6  
		    gainControl.setValue(dB);

			int tailleFrame;

			tailleFrame = format.getFrameSize();

			int m;  // est le nombre de frames lus en une fois

			m = (int)(0.01*format.getFrameRate()); //nombre de frames en 1/100�me  seconde (frameRate = fr�quence en Herz)

			int tailleTampon;

			tailleTampon = m*tailleFrame; //nombre d'octets lus en une fois dans la boucle

			byte[] tampon = new byte[tailleTampon]; // la taille du tampon doit �tre un multiple de la taille d'un frame
			// correspond � une 1/100 de seconde de son

			ligne.start(); // d�tail � la con � ne pas oublier


			long l;
			l = audioInputStream.getFrameLength(); // taille du fichier audio exprim�e en nombre de frames

			long q, r;

			// l = q*n + r  :  division euclidienne

			q = l/m; //nbre de passages � faire
			r = l%m; // nbre de frames qu'il restera � lire apr�s la boucle
			int reste; // nbre d'octets restant � lire apr�s la boucle
			
			 
			

			reste = (int)(r*tailleFrame);
			long p;
			for ( p = 0 ; p < q; ++p)
			    {
			    audioInputStream.read(tampon); // lit m frames sur le fichier audio
			    ligne.write(tampon, 0, tampon.length); // �crit les m frames sur la ligne et donc les envoie sur un haut-parleur
			    }

			audioInputStream.read(tampon, 0, reste); // lit les r  frames restant sur le fichier audio
			ligne.write(tampon, 0, reste); // �crit les r frames restant sur la ligne et donc les envoie sur un haut-parleur

		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
