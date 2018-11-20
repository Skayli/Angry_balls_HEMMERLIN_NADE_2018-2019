package exodecorateur_angryballs.modele;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public class ComportementPesanteur extends DecorateurBilleAcceleration
{
	protected static Vecteur pesanteur;
	
	public ComportementPesanteur(Bille billeDecoree)
	{
		super(billeDecoree);
	}

	/**
	 * 
	 * @see exodecorateur_angryballs.modele.Bille#gestionAcceleration(java.util.Vector)
	 * 
	 * Cette classe ajoute l'impact de la pesanteur.
	 * La m�thode de gestion de l'acc�l�ration fait d'abord appel � la m�thode de l'objet d�cor�e, puis elle y ajoute la pesanteur
	 * 
	 */
	@Override
	public void gestionAcceleration(Vector<Bille> billes)
	{
		this.billeDecoree.gestionAcceleration(billes);	//appel r�cursif
		this.getAcceleration().ajoute(ComportementPesanteur.pesanteur);  //ajout de la pesanteur
	}
	
	public static void setPesanteur(Vecteur pesanteur)
	{
		ComportementPesanteur.pesanteur = pesanteur;
	}
}
