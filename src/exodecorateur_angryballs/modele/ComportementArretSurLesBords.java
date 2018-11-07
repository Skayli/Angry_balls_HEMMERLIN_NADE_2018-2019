package exodecorateur_angryballs.modele;

import mesmaths.cinematique.Collisions;

public class ComportementArretSurLesBords extends DecorateurBilleCollisionContour
{

	public ComportementArretSurLesBords(Bille billeDecoree)
	{
		super(billeDecoree);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur,
			double hauteur)
	{
		Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, largeur);
		Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(), this.getVitesse(), ordonnéeCoinHautGauche, hauteur);
	}

}
