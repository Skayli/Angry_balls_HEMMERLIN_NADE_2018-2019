package exodecorateur_angryballs.vues;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.visitor.Dessinateur;
import exodecorateur_angryballs.visitor.DessinateurAWT;


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
@SuppressWarnings("serial")
public class Billard extends JPanel
{
	Vector<Bille> billes;
	Dessinateur d;
	
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
    	d = new DessinateurAWT(graphics);
    	
    	int i;
    	for ( i = 0; i < this.billes.size(); ++i) {
//    		this.billes.get(i).dessine(graphics);
    		this.billes.get(i).dessine(d);
    		
    	}
    	//System.out.println("billes dans le billard = " + billes);
    }
}
