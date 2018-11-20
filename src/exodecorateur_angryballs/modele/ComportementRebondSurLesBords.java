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
	 * Ce comportement remplace celui de l'objet d�cor�
	 * Les billes rencontrant un contour rebondiront dessus.
	 * 
	 * (NB : Il s'agit du comportement par d�faut des billes. Ce d�corateur a �t� cr�� afin de pouvoir revenir � l'�tat initial 
	 * en cours d'ex�cution, �tant donn� qu'un comportement h�rit� de DecorateurBilleCollisionContour remplace le comportement
	 * de l'objet d�cor�)
	 */
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur,
			double hauteur) 
	{
		Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}

}