package exodecorateur_angryballs.dp_state;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.ComportementBillePilotee;
import exodecorateur_angryballs.projet.Souris;
import exodecorateur_angryballs.vues.CadreAngryBalls;

public class EtatBillePiloteeAttrapée extends ControleurEtatBillePilotee {
	
	public EtatBillePiloteeAttrapée(ComportementBillePilotee bille, ControleurEtatBillePilotee suivant, ControleurEtatBillePilotee retour) {
		super(bille, suivant, retour);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void traiteMousePressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void traiteMouseReleased() {
		bille.setEtatCourant(this.suivant);
		System.out.println("La bille est désormais libre");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
