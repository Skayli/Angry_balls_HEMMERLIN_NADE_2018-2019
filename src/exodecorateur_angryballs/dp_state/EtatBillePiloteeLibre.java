package exodecorateur_angryballs.dp_state;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.ComportementBillePilotee;
import exodecorateur_angryballs.projet.Souris;
import exodecorateur_angryballs.vues.CadreAngryBalls;
import mesmaths.geometrie.base.Vecteur;

public class EtatBillePiloteeLibre extends ControleurEtatBillePilotee {

	public EtatBillePiloteeLibre(ComportementBillePilotee bille, ControleurEtatBillePilotee suivant, ControleurEtatBillePilotee retour) {
		super(bille, suivant, retour);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void traiteMousePressed(Vecteur mousePosition) {
		
		// Calcul de la distance entre la souris et le centre de la bille pour savoir si on a bien cliqué sur la bille
		double dist = Math.sqrt(Math.pow( (mousePosition.x - bille.getPosition().x),2) + Math.pow((mousePosition.y - bille.getPosition().y), 2) );
		
		if(dist <= bille.getRayon()) {
			// On a cliqué sur la bille, elle était libre, maintenant elle est attrapée
			this.bille.setEtatCourant(this.suivant);

		} else {
			// Rien a faire : on a cliqué à côté de la bille
		}
		
	}

	@Override
	protected void traiteMouseReleased() {
		// TODO Auto-generated method stub
				
		// Rien à faire quand on relache la souris dans l'état "libre"
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "état libre";
	}

}
