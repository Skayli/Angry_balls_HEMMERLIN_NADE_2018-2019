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
	 * Ce comportement remplace celui de l'objet d�cor�
	 * Les billes rencontrant un contour disparaitront du cadre pour r�appara�tre de l'autre c�t�
	 */
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur,
			double hauteur) 
	{
		Collisions.collisionBilleContourPasseMuraille( this.billeDecoree.getPosition(), abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}

}
