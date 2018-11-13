package exodecorateur_angryballs.vues;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

import exodecorateur_angryballs.modele.Bille;


/**
 * responsable du dessin des billes
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 *  Changements quand même apportés :
 *  	extends JPanel au lieu de Canvas
 *  	afin de pouvoir appliquer un double buffering et éviter le "flashing"
 *  	=> 2 lignes ajoutées dans le constructeur et 1 au debut de la fonction pain(Graphics)
 * 
 * */
public class Billard extends JPanel
{
	Vector<Bille> billes;
	
    public Billard(Vector<Bille> billes) {
    	this.billes = billes;
    	this.setDoubleBuffered(true);
    	this.setBackground(Color.WHITE);
    }
    
    /* (non-Javadoc)
     * @see java.awt.Canvas#paint(java.awt.Graphics)
     */
    public void paint(Graphics graphics) {
    	super.paint(graphics);
    	int i;
    	for ( i = 0; i < this.billes.size(); ++i)
    		this.billes.get(i).dessine(graphics);
    
    	//System.out.println("billes dans le billard = " + billes);
    }
 
}
