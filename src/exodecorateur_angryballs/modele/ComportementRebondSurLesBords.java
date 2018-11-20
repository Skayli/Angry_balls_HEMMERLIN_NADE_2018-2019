package exodecorateur_angryballs.modele;

import mesmaths.cinematique.Collisions;

public class ComportementRebondSurLesBords extends DecorateurBilleCollisionContour
{

	public ComportementRebondSurLesBords(Bille billeDecoree) 
	{
		super(billeDecoree);
	}

	
	/**
	 * @see exodecorateur_angryballs.modele.Bille#collisionContour(double, double, double, double)
	 * 
	 * Ce comportement remplace celui de l'objet décoré
	 * Les billes rencontrant un contour rebondiront dessus.
	 * 
	 * (NB : Il s'agit du comportement par défaut des billes. Ce décorateur a été créé afin de pouvoir revenir à l'état initial 
	 * en cours d'exécution, étant donné qu'un comportement hérité de DecorateurBilleCollisionContour remplace le comportement
	 * de l'objet décoré)
	 */
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur,
			double hauteur) 
	{
		Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}

}