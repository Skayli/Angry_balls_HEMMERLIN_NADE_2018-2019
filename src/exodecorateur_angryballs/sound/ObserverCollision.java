package exodecorateur_angryballs.sound;

import java.util.Observable;
import java.util.Observer;

public class ObserverCollision implements Observer {
	
	public ObserverCollision() {
	 
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		System.out.println("collision de la bille n°" + (int) arg1);
		SoundManager.getInstance().playSound();
	}
}
