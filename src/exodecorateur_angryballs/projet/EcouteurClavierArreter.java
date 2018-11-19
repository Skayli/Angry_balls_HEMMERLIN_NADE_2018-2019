package exodecorateur_angryballs.projet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import exodecorateur_angryballs.controlerAnimation.ObservableArreterAnimation;
import exodecorateur_angryballs.controlerAnimation.ObservableLancerAnimation;

public class EcouteurClavierArreter extends ObservableArreterAnimation implements KeyListener {

	public EcouteurClavierArreter() {
		
	}
	
	@Override
	public void keyPressed(KeyEvent key) {
		// TODO Auto-generated method stub
		if(key.getKeyChar() == 'a') {
			super.arreterAnimation();
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
