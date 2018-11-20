package exodecorateur_angryballs.controlerAnimation;

import java.util.Observer;

import exodecorateur_angryballs.projet.AnimationBilles;

@SuppressWarnings("deprecation")
public abstract class ObserverAnimation implements Observer {
	
	protected AnimationBilles animationBilles;
	
	public ObserverAnimation(AnimationBilles animationBilles) {
		this.animationBilles = animationBilles;
	}

}
