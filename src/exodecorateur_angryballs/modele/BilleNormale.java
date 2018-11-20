package exodecorateur_angryballs.modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import exodecorateur_angryballs.sound.SoundManager;
import mesmaths.cinematique.Cinematique;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

public class BilleNormale extends Bille
{
	
	public  Vecteur position;   // centre de la bille
	public  double rayon;            // rayon > 0
	public  Vecteur vitesse;
	public  Vecteur acceleration;
	public int clef;                // identifiant unique de cette bille
	
	private Color couleur;
	
	private static int prochaineClef = 0;

	public static double ro = 1;        // masse volumique
	
	
	/**
	 * @param centre
	 * @param rayon
	 * @param vitesse
	 * @param acceleration
	 * @param couleur
	 */
	
	public BilleNormale (Vecteur centre, double rayon, Vecteur vitesse, Vecteur acceleration, Color couleur)
	{
		this.position = centre;
		this.rayon = rayon;
		this.vitesse = vitesse;
		this.acceleration = acceleration;
		this.couleur = couleur;
		this.clef = BilleNormale.prochaineClef ++;
	}
	
	/**
	 * @param position
	 * @param rayon
	 * @param vitesse
	 * @param couleur
	 */
	public BilleNormale(Vecteur position, double rayon, Vecteur vitesse, Color couleur)
	{
	this(position,rayon,vitesse,new Vecteur(),couleur);
	}
	
	/**
	 * @return the position
	 */
	public Vecteur getPosition()
	{
		return this.position;
	}
	
	
	
	
	/**
	 * @return the rayon
	 */
	public double getRayon()
	{
		return this.rayon;
	}
	
	
	
	
	/**
	 * @return the vitesse
	 */
	public Vecteur getVitesse()
	{
		return this.vitesse;
	}
	
	
	
	
	/**
	 * @return the accélération
	 */
	public Vecteur getAcceleration()
	{
		return this.acceleration;
	}
	
	
	
	
	/**
	 * @return the clef
	 */
	public int getClef()
	{
		return this.clef;
	}
	

	
	public double masse() 
	{
		return ro*Geop.volumeSphère(rayon);
	}
	
	
	/**
	 * mise à jour de position et vitesse à t+deltaT à partir de position et vitesse à l'instant t
	 * 
	 * modifie le vecteur position et le vecteur vitesse
	 * 
	 * laisse le vecteur accélération intact
	 *
	 * La bille subit par défaut un mouvement uniformément accéléré
	 * */
	public void deplacer(double deltaT) 
	{
		Cinematique.mouvementUniformémentAccéléré( this.getPosition(), this.getVitesse(), this.getAcceleration(), deltaT);
	}
	
	public void dessine (Graphics g)
    {
	    int width, height;
	    int xMin, yMin;
	    
	    xMin = (int)Math.round(position.x-rayon);
	    yMin = (int)Math.round(position.y-rayon);
	
	    width = height = 2*(int)Math.round(rayon); 
	
	    g.setColor(couleur);
	    g.fillOval( xMin, yMin, width, height);
	    g.setColor(Color.CYAN);
	    g.drawOval(xMin, yMin, width, height);
    }


	public String toString() 
	{
	    return "centre = " + position + " rayon = "+rayon +  " vitesse = " + vitesse + " accélération = " + acceleration + " couleur = " + couleur + "clef = " + clef;
	}
	
	/**
	 * 
	 * @see exodecorateur_angryballs.modele.Bille#collisionContour(double, double, double, double)
	 * 
	 * Une bille normale rebondit sur les contours du billard
	 */
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) 
	{
		Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}
	
	
	/**
	 * 
	 * @see exodecorateur_angryballs.modele.Bille#gestionAcceleration(java.util.Vector)
	 * 
	 * Une bille normale a un vecteur accélération nul
	 */
	@Override
	public void gestionAcceleration(Vector<Bille> billes) 
	{
		this.getAcceleration().set(Vecteur.VECTEURNUL);
	}

	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes)
	{	
		return OutilsBille.gestionCollisionBilleBille(this, billes);
	}

}
