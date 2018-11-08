package exodecorateur_angryballs.dp_state;

import exodecorateur_angryballs.projet.Souris;

public abstract class ControleurEtat {
	
	Souris souris;
	public ControleurEtat suivant;
	public ControleurEtat retour;
	
	public ControleurEtat(Souris souris, ControleurEtat suivant, ControleurEtat retour) {
		this.souris = souris;
		this.suivant = suivant;
		this.retour = retour;
	}
	
	public abstract void traiteMousePressed();
	public abstract void traiteMouseReleased();
}
