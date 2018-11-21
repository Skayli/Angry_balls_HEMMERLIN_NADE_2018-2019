package exodecorateur_angryballs.dp_state;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.ComportementBillePilotee;
import exodecorateur_angryballs.projet.Souris;
import mesmaths.geometrie.base.Vecteur;

/**
 * 
 * Classe abstraite du DP State
 * Il traite 2 évènements : une pression sur la souris, et le relachement du bouton de la souris
 *
 */
public abstract class ControleurEtatBillePilotee {
	
	protected ComportementBillePilotee bille;
	protected ControleurEtatBillePilotee suivant;
	protected ControleurEtatBillePilotee retour;
	
	public ControleurEtatBillePilotee(ComportementBillePilotee bille, ControleurEtatBillePilotee suivant, ControleurEtatBillePilotee retour) {
		this.bille = bille;
		this.suivant = suivant;
		this.retour = retour;
	}
	
	protected abstract void traiteMousePressed(Vecteur mousePosition);
	protected abstract void traiteMouseReleased();
	
	public abstract String toString();
	
	public void setSuivant(ControleurEtatBillePilotee suivant) {
		this.suivant = suivant;
	}
	
	public void setRetour(ControleurEtatBillePilotee retour) {
		this.retour = retour;
	}

	/**
	 * @param mouse L'évènement à la souris
	 * Appelle le traitement correspondant à l'évènement de la souris
	 */
	public void traiteMouseEvent(MouseEvent mouse) {
		if(mouse.getID() == MouseEvent.MOUSE_PRESSED) {
			Vecteur mousePosition = new Vecteur(mouse.getX(), mouse.getY());
			this.traiteMousePressed(mousePosition);
		} else if(mouse.getID() == MouseEvent.MOUSE_RELEASED) {
			this.traiteMouseReleased();
		}
	}
}
