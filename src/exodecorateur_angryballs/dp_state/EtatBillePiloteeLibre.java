package exodecorateur_angryballs.dp_state;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.ComportementBillePilotee;
import exodecorateur_angryballs.projet.Souris;
import exodecorateur_angryballs.vues.CadreAngryBalls;

public class EtatBillePiloteeLibre extends ControleurEtatBillePilotee {

	public EtatBillePiloteeLibre(ComportementBillePilotee bille, ControleurEtatBillePilotee suivant, ControleurEtatBillePilotee retour) {
		super(bille, suivant, retour);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void traiteMousePressed(MouseEvent mouse) {
		
		// Calcul de la distance entre la souris et le centre de la bille pour savoir si on a bien cliqué sur la bille
		double dist = Math.sqrt(Math.pow( (mouse.getX() - bille.getPosition().x) + (mouse.getY() - bille.getPosition().y), 2) );
		
		if(dist <= bille.getRayon()) {
			// On a cliqué sur la bille, elle était libre, maintenant elle est attrapée
			this.bille.setEtatCourant(this.suivant);
			System.out.println("maintenant la bille suit la souris");
		} else {
			System.out.println("cliqué à coté");
		}
		
	}

	@Override
	protected void traiteMouseReleased() {
		// TODO Auto-generated method stub
				
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "état libre";
	}

}
