package exodecorateur_angryballs.controlerAnimation;

import java.util.Observable;
import exodecorateur_angryballs.projet.AnimationBilles;

/**
 * 
 * Observe les éléments qui entrainent le lancement de l'animation des billes
 * Actuellement, l'animation est arrêtée soit par un clic sur le bouton "lancer les billes" 
 * ou par la touche L du clavier
 *
 */
@SuppressWarnings("deprecation")
public class ObserverLancerAnimation extends ObserverAnimation {

	public ObserverLancerAnimation(AnimationBilles animationBilles) {
		super(animationBilles);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		super.animationBilles.lancerAnimation();
	}
	

}
