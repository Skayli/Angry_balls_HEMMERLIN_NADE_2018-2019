package exodecorateur_angryballs.modele;

import mesmaths.cinematique.Collisions;

public class ComportementPasseMurailles extends DecorateurBilleCollisionContour
{
	
	public ComportementPasseMurailles(Bille billeDecoree)
	{
		super(billeDecoree);
	}

	/**
	 * 
	 * @see exodecorateur_angryballs.modele.Bille#collisionContour(double, double, double, double)
	 * 
	 * Ce comportement remplace celui de l'objet décoré
	 * Les billes rencontrant un contour disparaitront du cadre pour réapparaître de l'autre côté
	 */
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur,
			double hauteur) 
	{
		Collisions.collisionBilleContourPasseMuraille( this.billeDecoree.getPosition(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}

}
