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
	 * La méthode de gestion de l'accélération fait d'abord appel à la méthode de l'objet décorée, puis elle y ajoute l'attraction
	 * 
	 */
	@Override
	public void gestionAcceleration(Vector<Bille> billes) 
	{
		this.billeDecoree.gestionAcceleration(billes);										//appel récursif
		this.getAcceleration().ajoute(OutilsBille.gestionAccélérationNewton(this, billes));	//ajout de l'attraction par les autres billes
	}	
}
