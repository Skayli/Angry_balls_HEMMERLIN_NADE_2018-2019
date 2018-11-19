package exodecorateur_angryballs.projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exodecorateur_angryballs.controlerAnimation.ObservableArreterAnimation;


/**
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 *  */

public class EcouteurBoutonArreter extends ObservableArreterAnimation implements ActionListener {
	
	public EcouteurBoutonArreter() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.arreterAnimation();
	}

}
