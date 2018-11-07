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
	 * La m�thode de gestion de l'acc�l�ration fait d'abord appel � la m�thode de l'objet d�cor�e, puis elle y ajoute les frottements
	 * 
	 */
	@Override
	public void gestionAcceleration(Vector<Bille> billes)
	{
		this.billeDecoree.gestionAcceleration(billes);						//appel r�cursif
		this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse()));	//ajout des frottements
	}
	
}
