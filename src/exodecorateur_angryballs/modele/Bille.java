package exodecorateur_angryballs.modele;

import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public interface Bille {
	abstract Vecteur getPosition();


	abstract double masse();


	/* (non-Javadoc)
	 * @see exodecorateur_angryballs.modele.BilleI#getRayon()
	 */
	public abstract double getRayon();


	/* (non-Javadoc)
	 * @see exodecorateur_angryballs.modele.BilleI#getVitesse()
	 */
	public abstract Vecteur getVitesse();


	abstract int getClef();
	
	
	/* (non-Javadoc)
	 * @see exodecorateur_angryballs.modele.BilleI#dessine(java.awt.Graphics)
	 */
	public abstract void dessine(Graphics g);

	/* (non-Javadoc)
	 * @see exodecorateur_angryballs.modele.BilleI#deplacer(double)
	 */
	public abstract void deplacer(double deltaT);
	
	abstract Vecteur getAcceleration();
	
	/* (non-Javadoc)
	 * @see exodecorateur_angryballs.modele.BilleI#gestionCollisionBilleBille(java.util.Vector)
	 */
	public abstract boolean gestionCollisionBilleBille(Vector<Bille> billes);

	
	/* (non-Javadoc)
	 * @see exodecorateur_angryballs.modele.BilleI#gestionAcceleration(java.util.Vector)
	 */
	public abstract void gestionAcceleration(Vector<Bille> billes);
	
	/* (non-Javadoc)
	 * @see exodecorateur_angryballs.modele.BilleI#collisionContour(double, double, double, double)
	 */
	public abstract void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur); 
}
