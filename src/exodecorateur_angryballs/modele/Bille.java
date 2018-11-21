package exodecorateur_angryballs.modele;

import java.util.Vector;

import exodecorateur_angryballs.visitor.Dessinateur;
import mesmaths.geometrie.base.Vecteur;


/**
 * Cas général d'une bille de billard
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
	 * gestion de l'éventuelle  collision de cette bille avec les autres billes
	 *
	 * billes est la liste de toutes les billes en mouvement
	 * 
	 * Le comportement par défaut est le choc parfaitement élastique (c-à-d rebond sans amortissement)
	 * 
	 * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 billes impliquées dans le choc sont modifiées
	 * si renvoie false, il n'y a pas de collision et les billes sont laissées intactes 
	 * */
	public abstract boolean gestionCollisionBilleBille(Vector<Bille> billes);

	
	/**
	 * calcul (c-à-d mise à jour) éventuel  du vecteur accélération. 
	 * billes est la liste de toutes les billes en mouvement
	 * Cette méthode peut avoir besoin de "billes" si this subit l'attraction gravitationnelle des autres billes
	 * La nature du calcul du vecteur accélération de la bille  est définie dans les classes dérivées
	 * A ce niveau le vecteur accélération est mis à zéro (c'est à dire pas d'accélération)
	 * */
	public abstract void gestionAcceleration(Vector<Bille> billes);
	
	/**
	 * gestion de la collision entre une bille et un contour du billard
	 */
	public abstract void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur);
	
//----------------- classe Bille -------------------------------------

}