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
		
		// Calcul de la distance entre la souris et le centre de la bille pour savoir si on a bien cliqu� sur la bille
		double dist = Math.sqrt(Math.pow( (mouse.getX() - bille.getPosition().x),2) + Math.pow((mouse.getY() - bille.getPosition().y), 2) );
		
		if(dist <= bille.getRayon()) {
			// On a cliqu� sur la bille, elle �tait libre, maintenant elle est attrap�e
			this.bille.setEtatCourant(this.suivant);

		} else {
			// Rien a faire : on a cliqu� � c�t� de la bille
		}
		
	}

	@Override
	protected void traiteMouseReleased() {
		// TODO Auto-generated method stub
				
		// Rien � faire quand on relache la souris dans l'�tat "libre"
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "�tat libre";
	}

}
