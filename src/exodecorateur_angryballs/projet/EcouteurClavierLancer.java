package exodecorateur_angryballs.projet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import exodecorateur_angryballs.controlerAnimation.ObservableLancerAnimation;
import javafx.scene.input.KeyCode;

public class EcouteurClavierLancer extends ObservableLancerAnimation implements KeyListener {
	
	public EcouteurClavierLancer() {
		
	}

	@Override
	public void keyPressed(KeyEvent key) {
		// TODO Auto-generated method stub
		if(key.getKeyChar() == 'l') {
			super.lancerAnimation();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
