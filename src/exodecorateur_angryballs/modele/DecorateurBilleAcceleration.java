package exodecorateur_angryballs.modele;

import java.util.Vector;

public abstract class DecorateurBilleAcceleration extends DecorateurBille
{

	public DecorateurBilleAcceleration(Bille billeDecoree) 
	{
		super(billeDecoree);
	}

	

	/**
	 * 
	 * @see exodecodeur_angryballs.modele.Bille#gestionCollisionBilleBille(Vector<Bille> billes)
	 * 
	 * Cette classe du décorateur ne modifie pas la gestion des collisions bille/bille
	 *	@return la gestion des collisions définie par l'objet décoré
	 *
	 */
	public boolean gestionCollisionBilleBille(Vector<Bille> billes)
	{
		return this.billeDecoree.gestionCollisionBilleBille(billes);
	}
	
	/**
	 * 
	 * @see exodecorateur_angryballs.modele.Bille#collisionContour(double, double, double, double)
	 * 
	 * Cette classe du décorateur ne modifie pas la gestion des collisions bille/contour
	 * Il utilise la gestion des collisions avec le contour de l'objet décoré
	 * 
	 */
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur,
			double hauteur)
	{
		this.billeDecoree.collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}

}
