package exodecorateur_angryballs.visitor;

import exodecorateur_angryballs.modele.Bille;

public abstract class VisitorBille {
	
	public VisitorBille() {
		
	}
	
	public abstract void visite(Bille bille);
}
