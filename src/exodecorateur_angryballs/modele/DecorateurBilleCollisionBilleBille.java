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
	 * Cette classe du d�corateur ne modifie pas la gestion des collisions bille/contour
	 * Il utilise la gestion des collisions avec le contour de l'objet d�cor�
	 */
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) 
	{
		this.billeDecoree.collisionContour(abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}

}
