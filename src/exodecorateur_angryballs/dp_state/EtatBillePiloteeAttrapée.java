package exodecorateur_angryballs.dp_state;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.ComportementBillePilotee;
import exodecorateur_angryballs.projet.Souris;
import exodecorateur_angryballs.vues.CadreAngryBalls;

public class EtatBillePiloteeAttrap�e extends ControleurEtatBillePilotee {
	
	public EtatBillePiloteeAttrap�e(ComportementBillePilotee bille, ControleurEtatBillePilotee suivant, ControleurEtatBillePilotee retour) {
		super(bille, suivant, retour);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void traiteMousePressed(MouseEvent mouse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void traiteMouseReleased() {
		bille.setEtatCourant(this.suivant);
		System.out.println("La bille est d�sormais libre");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "�tat attrap�e";
	}
}
