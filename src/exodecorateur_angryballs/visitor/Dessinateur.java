package exodecorateur_angryballs.visitor;

import exodecorateur_angryballs.modele.Bille;

public abstract class Dessinateur {
	
	public Dessinateur() {
		
	}
	
	public abstract void dessine(Bille bille);
}
