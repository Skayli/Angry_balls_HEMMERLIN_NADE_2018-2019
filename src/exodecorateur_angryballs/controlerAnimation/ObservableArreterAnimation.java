package exodecorateur_angryballs.controlerAnimation;

import java.util.Observable;

@SuppressWarnings("deprecation")
public abstract class ObservableArreterAnimation extends Observable {

	public ObservableArreterAnimation() {
		
	}
	
	protected void arreterAnimation() {
		this.setChanged();
		this.notifyObservers("stop");
	}
}
