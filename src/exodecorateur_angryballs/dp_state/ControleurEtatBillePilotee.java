package exodecorateur_angryballs.dp_state;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.ComportementBillePilotee;
import exodecorateur_angryballs.projet.Souris;

public abstract class ControleurEtatBillePilotee {
	
	protected ComportementBillePilotee bille;
	protected ControleurEtatBillePilotee suivant;
	protected ControleurEtatBillePilotee retour;
	
	public ControleurEtatBillePilotee(ComportementBillePilotee bille, ControleurEtatBillePilotee suivant, ControleurEtatBillePilotee retour) {
		this.bille = bille;
		this.suivant = suivant;
		this.retour = retour;
	}
	
	protected abstract void traiteMousePressed(MouseEvent mouse);
	protected abstract void traiteMouseReleased();
	
	public abstract String toString();
	
	public void setSuivant(ControleurEtatBillePilotee suivant) {
		this.suivant = suivant;
	}
	
	public void setRetour(ControleurEtatBillePilotee retour) {
		this.retour = retour;
	}

	public void traiteMouseEvent(MouseEvent mouse) {
		if(mouse.getID() == MouseEvent.MOUSE_PRESSED) {
			this.traiteMousePressed(mouse);
		} else if(mouse.getID() == MouseEvent.MOUSE_RELEASED) {
			this.traiteMouseReleased();
		}
	}
}
