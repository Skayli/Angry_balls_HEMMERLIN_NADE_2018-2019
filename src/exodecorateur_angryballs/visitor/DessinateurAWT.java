package exodecorateur_angryballs.visitor;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.Couleur;

public class DessinateurAWT extends VisitorBille {
	
	Graphics g;
	
	public DessinateurAWT(Graphics graphics) {
		super();
		this.g = graphics;
	}

	@Override
	public void visite(Bille bille) {
		// TODO Auto-generated method stub	
	    int width, height;
	    int xMin, yMin;
	    
	    xMin = (int)Math.round(bille.getPosition().x - bille.getRayon());
	    yMin = (int)Math.round(bille.getPosition().y - bille.getRayon());
	
	    width = height = 2*(int)Math.round(bille.getRayon()); 
	    
	    Couleur billeColor = bille.getColor();
	    int billeRed = billeColor.getRed();
	    int billeGreen = billeColor.getGreen();
	    int billeBlue = billeColor.getBlue();
	    
	    Color awtColor = new Color(billeRed, billeGreen, billeBlue);
	    
	    // Transforme la couleur de la bille en une couleur utilisable par AWT
	    	
	    g.setColor(awtColor);
	    g.fillOval( xMin, yMin, width, height);
	    g.setColor(Color.CYAN);
	    g.drawOval(xMin, yMin, width, height);
	}

}
