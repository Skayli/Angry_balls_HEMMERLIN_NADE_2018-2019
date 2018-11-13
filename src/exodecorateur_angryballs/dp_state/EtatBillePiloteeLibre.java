package exodecorateur_angryballs.dp_state;

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
	public void traiteMousePressed() {
		this.bille.setEtatCourant(this.suivant);
		System.out.println("maintenant la bille suit la souris");
	}

	@Override
	public void traiteMouseReleased() {
		// TODO Auto-generated method stub
				
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
