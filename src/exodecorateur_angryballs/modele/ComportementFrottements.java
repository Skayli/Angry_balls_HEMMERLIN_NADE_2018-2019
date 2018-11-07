package exodecorateur_angryballs.modele;

import java.util.Vector;

import mesmaths.mecanique.MecaniquePoint;

public class ComportementFrottements extends DecorateurBilleAcceleration
{

	public ComportementFrottements(Bille billeDecoree) 
	{
		super(billeDecoree);
	}

	/**
	 * 
	 * @see exodecorateur_angryballs.modele.Bille#gestionAcceleration(java.util.Vector)
	 * 
	 * Cette classe ajoute le comportement de frottement dans l'air.
	 * La méthode de gestion de l'accélération fait d'abord appel à la méthode de l'objet décorée, puis elle y ajoute les frottements
	 * 
	 */
	@Override
	public void gestionAcceleration(Vector<Bille> billes)
	{
		this.billeDecoree.gestionAcceleration(billes);						//appel récursif
		this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse()));	//ajout des frottements
	}
	
}
