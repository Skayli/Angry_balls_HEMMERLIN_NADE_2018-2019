package exodecorateur_angryballs.modele;

import java.util.Vector;

import exodecorateur_angryballs.visitor.Dessinateur;
import mesmaths.geometrie.base.Vecteur;


/**
 * Cas g�n�ral d'une bille de billard
 * 
 *  CLASSE MODIFIEE
 *  
 * 
 * */
public abstract class Bille
{
//----------------- classe Bille-------------------------------------
	public Bille(){}

	public abstract Vecteur getPosition();

	abstract double masse();

	public abstract double getRayon();

	public abstract Vecteur getVitesse();

	abstract int getClef();
	
	public abstract Couleur getColor();
	
	
//	public abstract void dessine(Graphics g);
	public abstract void dessine(Dessinateur d);

	public abstract void deplacer(double deltaT);
	
	abstract Vecteur getAcceleration();
	
	/**
	 * gestion de l'�ventuelle  collision de cette bille avec les autres billes
	 *
	 * billes est la liste de toutes les billes en mouvement
	 * 
	 * Le comportement par d�faut est le choc parfaitement �lastique (c-�-d rebond sans amortissement)
	 * 
	 * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 billes impliqu�es dans le choc sont modifi�es
	 * si renvoie false, il n'y a pas de collision et les billes sont laiss�es intactes 
	 * */
	public abstract boolean gestionCollisionBilleBille(Vector<Bille> billes);

	
	/**
	 * calcul (c-�-d mise � jour) �ventuel  du vecteur acc�l�ration. 
	 * billes est la liste de toutes les billes en mouvement
	 * Cette m�thode peut avoir besoin de "billes" si this subit l'attraction gravitationnelle des autres billes
	 * La nature du calcul du vecteur acc�l�ration de la bille  est d�finie dans les classes d�riv�es
	 * A ce niveau le vecteur acc�l�ration est mis � z�ro (c'est � dire pas d'acc�l�ration)
	 * */
	public abstract void gestionAcceleration(Vector<Bille> billes);
	
	/**
	 * gestion de la collision entre une bille et un contour du billard
	 */
	public abstract void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur);
	
//----------------- classe Bille -------------------------------------

}