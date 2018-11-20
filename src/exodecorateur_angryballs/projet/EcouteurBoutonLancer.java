package exodecorateur_angryballs.projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import exodecorateur_angryballs.controlerAnimation.ObserverLancerAnimation;

/**
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 *  */
public class EcouteurBoutonLancer extends Observable implements ActionListener
{
	public EcouteurBoutonLancer() {

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setChanged();
		this.notifyObservers();
	}

}
