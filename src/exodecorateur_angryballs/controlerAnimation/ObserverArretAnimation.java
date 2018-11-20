package exodecorateur_angryballs.controlerAnimation;

import java.util.Observable;

import exodecorateur_angryballs.projet.AnimationBilles;

@SuppressWarnings("deprecation")
public class ObserverArretAnimation extends ObserverAnimation {

	public ObserverArretAnimation(AnimationBilles animationBilles) {
		super(animationBilles);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		super.animationBilles.arrêterAnimation();
	}

}
