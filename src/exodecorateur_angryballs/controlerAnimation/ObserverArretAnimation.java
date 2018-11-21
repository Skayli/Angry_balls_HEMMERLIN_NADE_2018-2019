package exodecorateur_angryballs.controlerAnimation;

import java.util.Observable;

import exodecorateur_angryballs.projet.AnimationBilles;

/**
 * 
 * Observe les éléments qui entrainent l'arret de l'animation
 * Actuellement, l'animation est arrêtée soit par un clic sur le bouton "arrêter les billes" 
 * ou par la touche A du clavier
 *
 */
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
