package exodecorateur_angryballs.projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import exodecorateur_angryballs.controlerAnimation.ObserverArretAnimation;


/**
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 *  */

public class EcouteurBoutonArreter extends Observable implements ActionListener {
	
	public EcouteurBoutonArreter() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setChanged();
		this.notifyObservers();
	}

}
