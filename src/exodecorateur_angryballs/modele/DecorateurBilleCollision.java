package exodecorateur_angryballs.modele;

import java.util.Vector;

public abstract class DecorateurBilleCollision extends DecorateurBille 
{
	public DecorateurBilleCollision(Bille billeDecoree) 
	{
		super(billeDecoree);
	}
	
	/**
	 * 
	 * @see exodecorateur_angryballs.modele.Bille#gestionAcceleration(java.util.Vector)
	 * 
	 * Ce décorateur ne modifie pas la gestion de l'accélération d'une bille
	 * 
	 * Il utilise donc la gestion de l'accélération de la bille décorée
	 */
	@Override
	public void gestionAcceleration(Vector<Bille> billes) 
	{
		this.billeDecoree.gestionAcceleration(billes);
	}
}
