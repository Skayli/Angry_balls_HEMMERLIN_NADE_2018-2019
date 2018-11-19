package exodecorateur_angryballs.projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import exodecorateur_angryballs.controlerAnimation.ObservableLancerAnimation;

/**
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 *  */
public class EcouteurBoutonLancer extends ObservableLancerAnimation implements ActionListener
{
	public EcouteurBoutonLancer() {

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.lancerAnimation();
	}

}
