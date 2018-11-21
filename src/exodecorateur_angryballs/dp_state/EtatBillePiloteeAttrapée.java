package exodecorateur_angryballs.dp_state;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.ComportementBillePilotee;
import exodecorateur_angryballs.projet.Souris;
import exodecorateur_angryballs.vues.CadreAngryBalls;
import mesmaths.geometrie.base.Vecteur;

public class EtatBillePiloteeAttrap�e extends ControleurEtatBillePilotee {
	
	public EtatBillePiloteeAttrap�e(ComportementBillePilotee bille, ControleurEtatBillePilotee suivant, ControleurEtatBillePilotee retour) {
		super(bille, suivant, retour);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void traiteMousePressed(Vecteur mousePosition) {
		// TODO Auto-generated method stub
		
		// Rien � faire quand on clique dans l'�tat "attrap�e"
	}

	@Override
	protected void traiteMouseReleased() {
		// On relache une bille attrap�e
		// Il suffit de changer l'�tat de la bille � "libre"
		bille.setEtatCourant(this.suivant);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "�tat attrap�e";
	}
}
