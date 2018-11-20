package exodecorateur_angryballs.projet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import exodecorateur_angryballs.controlerAnimation.ObserverLancerAnimation;
import javafx.scene.input.KeyCode;

public class EcouteurClavierLancer extends Observable implements KeyListener {
	
	public EcouteurClavierLancer() {
		
	}

	@Override
	public void keyPressed(KeyEvent key) {
		// TODO Auto-generated method stub
		if(key.getKeyChar() == 'l') {
			this.setChanged();
			this.notifyObservers();
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
