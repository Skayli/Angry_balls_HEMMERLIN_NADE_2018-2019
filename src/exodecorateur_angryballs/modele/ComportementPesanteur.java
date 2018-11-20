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
	 * La méthode de gestion de l'accélération fait d'abord appel à la méthode de l'objet décorée, puis elle y ajoute la pesanteur
	 * 
	 */
	@Override
	public void gestionAcceleration(Vector<Bille> billes)
	{
		this.billeDecoree.gestionAcceleration(billes);	//appel récursif
		this.getAcceleration().ajoute(ComportementPesanteur.pesanteur);  //ajout de la pesanteur
	}
	
	public static void setPesanteur(Vecteur pesanteur)
	{
		ComportementPesanteur.pesanteur = pesanteur;
	}
}
