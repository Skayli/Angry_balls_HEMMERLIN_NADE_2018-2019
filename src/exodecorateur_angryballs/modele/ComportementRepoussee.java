package exodecorateur_angryballs.modele;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

/**
 * 
 * @author Quentin
 *
 */
public class ComportementRepoussee extends DecorateurBilleAcceleration {

	public ComportementRepoussee(Bille billeDecoree) {
		// TODO Auto-generated constructor stub
		super(billeDecoree);
	}

	@Override
	public void gestionAcceleration(Vector<Bille> billes) {
		// TODO Auto-generated method stub
		this.billeDecoree.gestionAcceleration(billes);
		
		this.getAcceleration().ajoute(OutilsBille.gestionAccélérationNewton(this, billes).produit(-1));	//ajout de l'attraction par les autres billes
	}

}
