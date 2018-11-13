package exodecorateur_angryballs.modele;

import java.util.Vector;

public abstract class DecorateurBilleCollisionContour extends DecorateurBilleCollision
{

	public DecorateurBilleCollisionContour(Bille billeDecoree) 
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
	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes)
	{
		return OutilsBille.gestionCollisionBilleBille(this, billes);
	}
}
