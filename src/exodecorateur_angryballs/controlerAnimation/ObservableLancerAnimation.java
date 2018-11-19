package exodecorateur_angryballs.controlerAnimation;

import java.util.Observable;

@SuppressWarnings("deprecation")
public abstract class ObservableLancerAnimation extends Observable {

	public ObservableLancerAnimation() {
		
	}
	
	protected void lancerAnimation() {
		this.setChanged();
		this.notifyObservers("lancer");
	}
}
