package exodecorateur_angryballs.modele;

import java.util.Vector;

public class ComportementNewton extends DecorateurBilleAcceleration
{

	public ComportementNewton(Bille billeDecoree) 
	{
		super(billeDecoree);
	}

	/**
	 * 
	 * @see exodecorateur_angryballs.modele.Bille#gestionAcceleration(java.util.Vector)
	 * 
	 * Cette classe ajoute le comportement d'attraction par les autres billes.
	 * La m�thode de gestion de l'acc�l�ration fait d'abord appel � la m�thode de l'objet d�cor�e, puis elle y ajoute l'attraction
	 * 
	 */
	@Override
	public void gestionAcceleration(Vector<Bille> billes) 
	{
		this.billeDecoree.gestionAcceleration(billes);										//appel r�cursif
		this.getAcceleration().ajoute(OutilsBille.gestionAcc�l�rationNewton(this, billes));	//ajout de l'attraction par les autres billes
	}	
}
