package exodecorateur_angryballs.modele;

import java.util.Vector;

public abstract class DecorateurBilleCollisionBilleBille extends DecorateurBilleCollision
{

	public DecorateurBilleCollisionBilleBille(Bille billeDecoree) 
	{
		super(billeDecoree);
	}

	/**
	 * 
	 * @see exodecorateur_angryballs.modele.DecorateurBilleCollision#collisionContour(double, double, double, double)
	 * 
	 * Cette classe du décorateur ne modifie pas la gestion des collisions bille/contour
	 * Il utilise la gestion des collisions avec le contour de l'objet décoré
	 */
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) 
	{
		this.billeDecoree.collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}

}
